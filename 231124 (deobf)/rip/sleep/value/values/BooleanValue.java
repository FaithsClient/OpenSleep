package rip.sleep.value.values;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class BooleanValue extends Value<Boolean> {
   public int c27085;

   public BooleanValue(String var1, String var2, Boolean var3) {
      super(var1, var2);
      this.c28440(var3);
   }

   public BooleanValue(String var1, Boolean var2) {
      super(var1);
      this.c28440(var2);
   }

   public BooleanValue(String var1, String var2, Supplier<Boolean> var3, Boolean var4) {
      super(var1, var2, var3);
      this.c28440(var4);
   }

   public BooleanValue(String var1, Supplier<Boolean> var2, Boolean var3) {
      super(var1, var2);
      this.c28440(var3);
   }

   public Boolean c1473() {
      return (Boolean)super.c36545();
   }

   public JsonElement c75132() {
      return new JsonPrimitive(this.c1473());
   }

   public void c10550(JsonElement var1) {
      if (var1.isJsonPrimitive()) {
         this.c28440(Boolean.valueOf(var1.getAsBoolean()));
      }

   }

   public void c26405() {
      Module[] var1 = Value.c27574();
      this.c28440(Boolean.valueOf(!this.c1473().booleanValue()));
   }

   // $FF: synthetic method
   public Object c36545() {
      return this.c1473();
   }

   private static JSONException c6647(JSONException var0) {
      return var0;
   }
}
