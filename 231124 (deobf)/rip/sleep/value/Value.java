package rip.sleep.value;

import com.google.gson.JsonElement;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public abstract class Value<V> {
   private final String c23704;
   private final String c99139;
   public V c26356;
   protected final Supplier<Boolean> c69927;
   public float c25721 = 0.0F;
   public float c96866 = 0.0F;
   private static Module[] c81002;

   public Value(String var1, String var2) {
      this.c23704 = var1;
      this.c99139 = var2;
      this.c69927 = () -> {
         return true;
      };
   }

   public Value(String var1, String var2, Supplier<Boolean> var3) {
      this.c23704 = var1;
      this.c99139 = var2;
      this.c69927 = var3;
   }

   public Value(String var1) {
      this.c23704 = "";
      this.c99139 = var1;
      this.c69927 = () -> {
         return true;
      };
   }

   public Value(String var1, Supplier<Boolean> var2) {
      this.c23704 = "";
      this.c99139 = var1;
      this.c69927 = var2;
   }

   public String c33395() {
      return this.c23704;
   }

   public String getName() {
      return this.c99139.replaceAll(" ", "");
   }

   public V c36545() {
      return this.c26356;
   }

   public void c28440(V var1) {
      this.c26356 = (V)var1;
      if (Sleep.getInstance().c43557() != null) {
         Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c94512);
      }

   }

   public abstract JsonElement c75132();

   public abstract void c10550(JsonElement var1);

   public Boolean c64597() {
      return (Boolean)this.c69927.get();
   }

   public static void c96815(Module[] var0) {
      c81002 = var0;
   }

   public static Module[] c27574() {
      return c81002;
   }

   private static JSONException c52791(JSONException var0) {
      return var0;
   }

   static {
      if (c27574() != null) {
         c96815(new Module[1]);
      }

   }
}
