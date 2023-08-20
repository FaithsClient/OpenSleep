package ft.sleep.util.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

public class JsonBridge {
   public static JsonElement _driver(String eyimabug) throws JsonSyntaxException {
      return _andrea(new StringReader((String)eyimabug));
   }

   public static JsonElement _andrea(Reader agunolal) throws JsonIOException, JsonSyntaxException {
      Object uroviman = new JsonReader((Reader)agunolal);
      Object idasetof = _length(uroviman);
      if (!idasetof.isJsonNull() && uroviman.peek() != JsonToken.END_DOCUMENT) {
         throw new JsonSyntaxException("Did not consume the entire document.");
      } else {
         return idasetof;
      }
   }

   public static JsonElement _length(JsonReader grocery) throws JsonIOException, JsonSyntaxException {
      Object gerald = ((JsonReader)grocery).isLenient();
      ((JsonReader)grocery).setLenient(true);
      Object solid = Streams.parse((JsonReader)grocery);
      ((JsonReader)grocery).setLenient(gerald);
      return solid;
   }

   /** @deprecated */
   @Deprecated
   public JsonElement _catalyst(String migupepe) throws JsonSyntaxException {
      return _driver((String)migupepe);
   }

   /** @deprecated */
   @Deprecated
   public JsonElement _answer(Reader nicole) throws JsonIOException, JsonSyntaxException {
      return _andrea((Reader)nicole);
   }

   /** @deprecated */
   @Deprecated
   public JsonElement _sailing(JsonReader eyobacuv) throws JsonIOException, JsonSyntaxException {
      return _length((JsonReader)eyobacuv);
   }
}
