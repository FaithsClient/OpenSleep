package rip.sleep.value.values;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.value.Value;

public class IntValue extends Value<Integer> {
   public boolean c65296;

   public IntValue(String var1, int var2) {
      super(var1);
      this.c28440(Integer.valueOf(var2));
   }

   public IntValue(String var1, Supplier<Boolean> var2, int var3) {
      super(var1, var2);
      this.c28440(Integer.valueOf(var3));
   }

   public boolean c47112() {
      return this.c65296;
   }

   public Integer c41161() {
      return (Integer)super.c36545();
   }

   public JsonElement c75132() {
      return new JsonPrimitive(this.c41161());
   }

   public void c10550(JsonElement var1) {
      if (var1.isJsonPrimitive()) {
         this.c28440(Integer.valueOf(var1.getAsInt()));
      }

   }

   public void c57429(boolean var1) {
      this.c65296 = var1;
   }

   public float[] c7761() {
      Value.c27574();
      float[] var2 = new float[3];
      int var6 = Math.max(this.c41161().intValue() >>> 16 & 255, this.c41161().intValue() >>> 8 & 255);
      if ((this.c41161().intValue() & 255) > var6) {
         var6 = this.c41161().intValue() & 255;
      }

      int var7 = Math.min(this.c41161().intValue() >>> 16 & 255, this.c41161().intValue() >>> 8 & 255);
      if ((this.c41161().intValue() & 255) < var7) {
         var7 = this.c41161().intValue() & 255;
      }

      float var4 = (float)var6 / 255.0F;
      float var3 = var6 != 0 ? (float)(var6 - var7) / (float)var6 : 0.0F;
      if (var3 == 0.0F) {
         float var5 = 0.0F;
      }

      float var8 = (float)(var6 - (this.c41161().intValue() >>> 16 & 255)) / (float)(var6 - var7);
      float var9 = (float)(var6 - (this.c41161().intValue() >>> 8 & 255)) / (float)(var6 - var7);
      float var10 = (float)(var6 - (this.c41161().intValue() & 255)) / (float)(var6 - var7);
      float var11 = ((this.c41161().intValue() >>> 16 & 255) == var6 ? var10 - var9 : ((this.c41161().intValue() >>> 8 & 255) == var6 ? 2.0F + var8 - var10 : 4.0F + var9 - var8)) / 6.0F;
      if (var11 < 0.0F) {
         ++var11;
      }

      var2[0] = var11;
      var2[1] = var3;
      var2[2] = var4;
      return var2;
   }

   // $FF: synthetic method
   public Object c36545() {
      return this.c41161();
   }

   private static JSONException c6647(JSONException var0) {
      return var0;
   }
}
