package rip.sleep.value.values;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class MultiBooleanValue extends Value<BooleanValue> {
   private final List<BooleanValue> c93616;
   public boolean c97349;

   public MultiBooleanValue(String var1, BooleanValue... var2) {
      super(var1);
      this.c93616 = Arrays.asList(var2);
   }

   public MultiBooleanValue(String var1, Supplier<Boolean> var2, BooleanValue... var3) {
      super(var1, var2);
      this.c93616 = Arrays.asList(var3);
   }

   public BooleanValue c72319(String var1) {
      return (BooleanValue)this.c93616.stream().filter((var1x) -> {
         return var1x.getName().equalsIgnoreCase(var1);
      }).findFirst().orElse((Object)null);
   }

   public List<BooleanValue> c97929() {
      return this.c93616;
   }

   public JsonElement c75132() {
      JsonObject var2 = new JsonObject();
      Value.c27574();
      Iterator var3 = this.c97929().iterator();
      if (var3.hasNext()) {
         BooleanValue var4 = (BooleanValue)var3.next();
         var2.addProperty(var4.getName(), var4.c1473());
      }

      return var2;
   }

   public void c10550(JsonElement var1) {
      Module[] var2 = Value.c27574();
      if (var1.isJsonObject()) {
         Iterator var3 = this.c97929().iterator();
         if (var3.hasNext()) {
            BooleanValue var4 = (BooleanValue)var3.next();
            var4.c28440(Boolean.valueOf(var1.getAsJsonObject().get(var4.getName()).getAsBoolean()));
         }

      }
   }

   private static JSONException c6647(JSONException var0) {
      return var0;
   }
}
