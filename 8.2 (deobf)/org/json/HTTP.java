package org.json;

import java.util.Locale;

public class HTTP {
   public static final String CRLF = "\r\n";

   public static JSONObject toJSONObject(String string) throws JSONException {
      JSONObject jo = new JSONObject();
      HTTPTokener x = new HTTPTokener(string);
      String token = x.nextToken();
      if (token.toUpperCase(Locale.ROOT).startsWith("HTTP")) {
         jo.put("HTTP-Version", token);
         jo.put("Status-Code", x.nextToken());
         jo.put("Reason-Phrase", x.nextTo('\u0000'));
         x.next();
      } else {
         jo.put("Method", token);
         jo.put("Request-URI", x.nextToken());
         jo.put("HTTP-Version", x.nextToken());
      }

      while(x.more()) {
         String name = x.nextTo(':');
         x.next(':');
         jo.put(name, x.nextTo('\u0000'));
         x.next();
      }

      return jo;
   }

   public static String toString(JSONObject jo) throws JSONException {
      StringBuilder sb = new StringBuilder();
      if (jo.has("Status-Code") && jo.has("Reason-Phrase")) {
         sb.append(jo.getString("HTTP-Version"));
         sb.append(' ');
         sb.append(jo.getString("Status-Code"));
         sb.append(' ');
         sb.append(jo.getString("Reason-Phrase"));
      } else {
         if (!jo.has("Method") || !jo.has("Request-URI")) {
            throw new JSONException("Not enough material for an HTTP header.");
         }

         sb.append(jo.getString("Method"));
         sb.append(' ');
         sb.append('"');
         sb.append(jo.getString("Request-URI"));
         sb.append('"');
         sb.append(' ');
         sb.append(jo.getString("HTTP-Version"));
      }

      sb.append("\r\n");

      for(String key : jo.keySet()) {
         String value = jo.optString(key);
         if (!"HTTP-Version".equals(key) && !"Status-Code".equals(key) && !"Reason-Phrase".equals(key) && !"Method".equals(key) && !"Request-URI".equals(key) && !JSONObject.NULL.equals(value)) {
            sb.append(key);
            sb.append(": ");
            sb.append(jo.optString(key));
            sb.append("\r\n");
         }
      }

      sb.append("\r\n");
      return sb.toString();
   }
}
