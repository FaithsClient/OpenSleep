package rip.sleep.value.values;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.value.Value;

public class StringValue extends Value<String> {
   public boolean c13510;

   public StringValue(String var1, String var2) {
      super(var1);
      this.c28440(var2);
   }

   public StringValue(String var1, Supplier<Boolean> var2, String var3) {
      super(var1, var2);
      this.c28440(var3);
   }

   public JsonElement c75132() {
      return new JsonPrimitive((String)this.c36545());
   }

   public void c10550(JsonElement var1) {
      if (var1.isJsonPrimitive()) {
         this.c28440(var1.getAsString());
      }

   }

   public boolean c71447() {
      return this.c13510;
   }

   public void c14402(boolean var1) {
      this.c13510 = var1;
   }

   public void c82079(char var1) {
      this.c28440((String)this.c36545() + var1);
   }

   private static JSONException c6647(JSONException var0) {
      return var0;
   }
}
