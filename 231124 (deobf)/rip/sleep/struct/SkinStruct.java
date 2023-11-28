package rip.sleep.struct;

import java.util.UUID;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class SkinStruct {
   public static final ResourceLocation c45317 = new ResourceLocation("textures/entity/steve.png");
   public static final ResourceLocation c21430 = new ResourceLocation("textures/entity/alex.png");

   public static ResourceLocation c63069() {
      return c45317;
   }

   public static ResourceLocation c61172(UUID var0) {
      return c30458(var0) ? c21430 : c45317;
   }

   public static String c61283(UUID var0) {
      return c30458(var0) ? "slim" : "default";
   }

   private static boolean c30458(UUID var0) {
      Module[] var1 = Value.c27574();
      return (var0.hashCode() & 1) == 1;
   }

   private static JSONException c51670(JSONException var0) {
      return var0;
   }
}
