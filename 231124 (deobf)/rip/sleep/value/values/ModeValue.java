package rip.sleep.value.values;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.value.Value;

public class ModeValue extends Value<String> {
   public String[] c20127;
   public boolean c46593;

   public ModeValue(String var1, String[] var2, String var3) {
      super(var1);
      this.c20127 = var2;
      this.c28440(var3);
   }

   public ModeValue(String var1, Supplier<Boolean> var2, String[] var3, String var4) {
      super(var1, var2);
      this.c20127 = var3;
      this.c28440(var4);
   }

   public String c54460() {
      return (String)super.c36545();
   }

   public JsonElement c75132() {
      return new JsonPrimitive(this.c54460());
   }

   public void c10550(JsonElement var1) {
      if (var1.isJsonPrimitive()) {
         this.c28440(var1.getAsString());
      }

   }

   public String[] c42690() {
      return this.c20127;
   }

   public String c21632() {
      return this.c54460();
   }

   public String c66356(int var1) {
      return this.c20127[var1];
   }

   public void c94243(String var1) {
      Value.c27574();
      String[] var3 = this.c20127;
      int var4 = var3.length;
      int var5 = 0;
      if (var5 < var4) {
         String var6 = var3[var5];
         if (var6.equalsIgnoreCase(var1)) {
            this.c28440(var6);
         }

         ++var5;
      }

   }

   public int c28098(String var1) {
      Value.c27574();
      String[] var3 = this.c20127;
      int var4 = var3.length;
      int var5 = 0;
      if (var5 < var4) {
         String var6 = var3[var5];
         if (var6.equalsIgnoreCase(var1)) {
            return var5;
         }

         ++var5;
      }

      return 0;
   }

   public boolean c93891(String var1) {
      String[] var3 = this.c20127;
      Value.c27574();
      int var4 = var3.length;
      int var5 = 0;
      if (var5 < var4) {
         String var6 = var3[var5];
         if (var6.equalsIgnoreCase(var1)) {
            return true;
         }

         ++var5;
      }

      return false;
   }

   // $FF: synthetic method
   public Object c36545() {
      return this.c54460();
   }

   private static JSONException c6647(JSONException var0) {
      return var0;
   }
}
