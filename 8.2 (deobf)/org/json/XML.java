package org.json;

import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

public class XML {
   public static final Character AMP = '&';
   public static final Character APOS = '\'';
   public static final Character BANG = '!';
   public static final Character EQ = '=';
   public static final Character GT = '>';
   public static final Character LT = '<';
   public static final Character QUEST = '?';
   public static final Character QUOT = '"';
   public static final Character SLASH = '/';
   public static final String NULL_ATTR = "xsi:nil";

   private static Iterable codePointIterator(final String string) {
      return new Iterable() {
         public Iterator iterator() {
            return new Iterator() {
               private int nextIndex = 0;
               private int length = string.length();

               public boolean hasNext() {
                  return this.nextIndex < this.length;
               }

               public Integer next() {
                  int result = string.codePointAt(this.nextIndex);
                  this.nextIndex += Character.charCount(result);
                  return result;
               }

               public void remove() {
                  throw new UnsupportedOperationException();
               }
            };
         }
      };
   }

   public static String escape(String string) {
      StringBuilder sb = new StringBuilder(string.length());
      Iterator var2 = codePointIterator(string).iterator();

      while(var2.hasNext()) {
         int cp = ((Integer)var2.next()).intValue();
         switch(cp) {
         case 34:
            sb.append("&quot;");
            break;
         case 38:
            sb.append("&amp;");
            break;
         case 39:
            sb.append("&apos;");
            break;
         case 60:
            sb.append("&lt;");
            break;
         case 62:
            sb.append("&gt;");
            break;
         default:
            if (mustEscape(cp)) {
               sb.append("&#x");
               sb.append(Integer.toHexString(cp));
               sb.append(';');
            } else {
               sb.appendCodePoint(cp);
            }
         }
      }

      return sb.toString();
   }

   private static boolean mustEscape(int cp) {
      return Character.isISOControl(cp) && cp != 9 && cp != 10 && cp != 13 || (cp < 32 || cp > 55295) && (cp < 57344 || cp > 65533) && (cp < 65536 || cp > 1114111);
   }

   public static String unescape(String string) {
      StringBuilder sb = new StringBuilder(string.length());
      int i = 0;

      for(int length = string.length(); i < length; ++i) {
         char c = string.charAt(i);
         if (c == '&') {
            int semic = string.indexOf(59, i);
            if (semic > i) {
               String entity = string.substring(i + 1, semic);
               sb.append(XMLTokener.unescapeEntity(entity));
               i += entity.length() + 1;
            } else {
               sb.append(c);
            }
         } else {
            sb.append(c);
         }
      }

      return sb.toString();
   }

   public static void noSpace(String string) throws JSONException {
      int length = string.length();
      if (length == 0) {
         throw new JSONException("Empty string.");
      } else {
         for(int i = 0; i < length; ++i) {
            if (Character.isWhitespace(string.charAt(i))) {
               throw new JSONException("'" + string + "' contains a space character.");
            }
         }

      }
   }

   private static boolean parse(XMLTokener x, JSONObject context, String name, XMLParserConfiguration config) throws JSONException {
      JSONObject jsonobject = null;
      Object token = x.nextToken();
      if (token == BANG) {
         char c = x.next();
         if (c == '-') {
            if (x.next() == '-') {
               x.skipPast("-->");
               return false;
            }

            x.back();
         } else if (c == '[') {
            token = x.nextToken();
            if ("CDATA".equals(token) && x.next() == '[') {
               String string = x.nextCDATA();
               if (string.length() > 0) {
                  context.accumulate(config.cDataTagName, string);
               }

               return false;
            }

            throw x.syntaxError("Expected 'CDATA['");
         }

         int i = 1;

         while(true) {
            token = x.nextMeta();
            if (token == null) {
               throw x.syntaxError("Missing '>' after '<!'.");
            }

            if (token == LT) {
               ++i;
            } else if (token == GT) {
               --i;
            }

            if (i <= 0) {
               break;
            }
         }

         return false;
      } else if (token == QUEST) {
         x.skipPast("?>");
         return false;
      } else if (token == SLASH) {
         token = x.nextToken();
         if (name == null) {
            throw x.syntaxError("Mismatched close tag " + token);
         } else if (!token.equals(name)) {
            throw x.syntaxError("Mismatched " + name + " and " + token);
         } else if (x.nextToken() != GT) {
            throw x.syntaxError("Misshaped close tag");
         } else {
            return true;
         }
      } else if (token instanceof Character) {
         throw x.syntaxError("Misshaped tag");
      } else {
         String tagName = (String)token;
         token = null;
         jsonobject = new JSONObject();
         boolean nilAttributeFound = false;

         while(true) {
            if (token == null) {
               token = x.nextToken();
            }

            if (!(token instanceof String)) {
               if (token == SLASH) {
                  if (x.nextToken() != GT) {
                     throw x.syntaxError("Misshaped tag");
                  }

                  if (nilAttributeFound) {
                     context.accumulate(tagName, JSONObject.NULL);
                  } else if (jsonobject.length() > 0) {
                     context.accumulate(tagName, jsonobject);
                  } else {
                     context.accumulate(tagName, "");
                  }

                  return false;
               }

               if (token != GT) {
                  throw x.syntaxError("Misshaped tag");
               }

               while(true) {
                  token = x.nextContent();
                  if (token == null) {
                     if (tagName != null) {
                        throw x.syntaxError("Unclosed tag " + tagName);
                     }

                     return false;
                  }

                  if (token instanceof String) {
                     String string = (String)token;
                     if (string.length() > 0) {
                        jsonobject.accumulate(config.cDataTagName, config.keepStrings ? string : stringToValue(string));
                     }
                  } else if (token == LT && parse(x, jsonobject, tagName, config)) {
                     if (jsonobject.length() == 0) {
                        context.accumulate(tagName, "");
                     } else if (jsonobject.length() == 1 && jsonobject.opt(config.cDataTagName) != null) {
                        context.accumulate(tagName, jsonobject.opt(config.cDataTagName));
                     } else {
                        context.accumulate(tagName, jsonobject);
                     }

                     return false;
                  }
               }
            }

            String string = (String)token;
            token = x.nextToken();
            if (token == EQ) {
               token = x.nextToken();
               if (!(token instanceof String)) {
                  throw x.syntaxError("Missing value");
               }

               if (config.convertNilAttributeToNull && "xsi:nil".equals(string) && Boolean.parseBoolean((String)token)) {
                  nilAttributeFound = true;
               } else if (!nilAttributeFound) {
                  jsonobject.accumulate(string, config.keepStrings ? (String)token : stringToValue((String)token));
               }

               token = null;
            } else {
               jsonobject.accumulate(string, "");
            }
         }
      }
   }

   public static Object stringToValue(String string) {
      if (string.equals("")) {
         return string;
      } else if (string.equalsIgnoreCase("true")) {
         return Boolean.TRUE;
      } else if (string.equalsIgnoreCase("false")) {
         return Boolean.FALSE;
      } else if (string.equalsIgnoreCase("null")) {
         return JSONObject.NULL;
      } else {
         char initial = string.charAt(0);
         if (initial >= '0' && initial <= '9' || initial == '-') {
            try {
               if (string.indexOf(46) <= -1 && string.indexOf(101) <= -1 && string.indexOf(69) <= -1 && !"-0".equals(string)) {
                  Long myLong = Long.valueOf(string);
                  if (string.equals(myLong.toString())) {
                     if (myLong.longValue() == (long)myLong.intValue()) {
                        return myLong.intValue();
                     }

                     return myLong;
                  }
               } else {
                  Double d = Double.valueOf(string);
                  if (!d.isInfinite() && !d.isNaN()) {
                     return d;
                  }
               }
            } catch (Exception var3) {
               ;
            }
         }

         return string;
      }
   }

   public static JSONObject toJSONObject(String string) throws JSONException {
      return toJSONObject(string, XMLParserConfiguration.ORIGINAL);
   }

   public static JSONObject toJSONObject(Reader reader) throws JSONException {
      return toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
   }

   public static JSONObject toJSONObject(Reader reader, boolean keepStrings) throws JSONException {
      return keepStrings ? toJSONObject(reader, XMLParserConfiguration.KEEP_STRINGS) : toJSONObject(reader, XMLParserConfiguration.ORIGINAL);
   }

   public static JSONObject toJSONObject(Reader reader, XMLParserConfiguration config) throws JSONException {
      JSONObject jo = new JSONObject();
      XMLTokener x = new XMLTokener(reader);

      while(x.more()) {
         x.skipPast("<");
         if (x.more()) {
            parse(x, jo, (String)null, config);
         }
      }

      return jo;
   }

   public static JSONObject toJSONObject(String string, boolean keepStrings) throws JSONException {
      return toJSONObject(new StringReader(string), keepStrings);
   }

   public static JSONObject toJSONObject(String string, XMLParserConfiguration config) throws JSONException {
      return toJSONObject(new StringReader(string), config);
   }

   public static String toString(Object object) throws JSONException {
      return toString(object, (String)null, XMLParserConfiguration.ORIGINAL);
   }

   public static String toString(Object object, String tagName) {
      return toString(object, tagName, XMLParserConfiguration.ORIGINAL);
   }

   public static String toString(Object object, String tagName, XMLParserConfiguration config) throws JSONException {
      StringBuilder sb = new StringBuilder();
      if (object instanceof JSONObject) {
         if (tagName != null) {
            sb.append('<');
            sb.append(tagName);
            sb.append('>');
         }

         JSONObject jo = (JSONObject)object;

         for(String key : jo.keySet()) {
            Object value = jo.opt(key);
            if (value == null) {
               value = "";
            } else if (value.getClass().isArray()) {
               value = new JSONArray(value);
            }

            if (key.equals(config.cDataTagName)) {
               if (value instanceof JSONArray) {
                  JSONArray ja = (JSONArray)value;
                  int jaLength = ja.length();

                  for(int i = 0; i < jaLength; ++i) {
                     if (i > 0) {
                        sb.append('\n');
                     }

                     Object val = ja.opt(i);
                     sb.append(escape(val.toString()));
                  }
               } else {
                  sb.append(escape(value.toString()));
               }
            } else if (value instanceof JSONArray) {
               JSONArray ja = (JSONArray)value;
               int jaLength = ja.length();

               for(int i = 0; i < jaLength; ++i) {
                  Object val = ja.opt(i);
                  if (val instanceof JSONArray) {
                     sb.append('<');
                     sb.append(key);
                     sb.append('>');
                     sb.append(toString(val, (String)null, config));
                     sb.append("</");
                     sb.append(key);
                     sb.append('>');
                  } else {
                     sb.append(toString(val, key, config));
                  }
               }
            } else if ("".equals(value)) {
               sb.append('<');
               sb.append(key);
               sb.append("/>");
            } else {
               sb.append(toString(value, key, config));
            }
         }

         if (tagName != null) {
            sb.append("</");
            sb.append(tagName);
            sb.append('>');
         }

         return sb.toString();
      } else if (object == null || !(object instanceof JSONArray) && !object.getClass().isArray()) {
         String string = object == null ? "null" : escape(object.toString());
         return tagName == null ? "\"" + string + "\"" : (string.length() == 0 ? "<" + tagName + "/>" : "<" + tagName + ">" + string + "</" + tagName + ">");
      } else {
         JSONArray ja;
         if (object.getClass().isArray()) {
            ja = new JSONArray(object);
         } else {
            ja = (JSONArray)object;
         }

         int jaLength = ja.length();

         for(int i = 0; i < jaLength; ++i) {
            Object val = ja.opt(i);
            sb.append(toString(val, tagName == null ? "array" : tagName, config));
         }

         return sb.toString();
      }
   }
}
