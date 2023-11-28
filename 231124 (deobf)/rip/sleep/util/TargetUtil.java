package rip.sleep.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.Sleep;
import rip.sleep.value.Value;

public class TargetUtil {
   public static boolean c17356(Entity var0) {
      Module[] var1 = Value.c27574();
      return var0 instanceof EntityPlayer && var0.getName() != null && Sleep.getInstance().c43557().c25756.c43312(RenderUtilG.c70907(var0.getName()));
   }

   public static boolean c45033(Entity var0) {
      Module[] var1 = Value.c27574();
      return var0 instanceof EntityPlayer && var0.getName() != null && Sleep.getInstance().c43557().c36876.c21722(RenderUtilG.c70907(var0.getName()));
   }

   private static JSONException c16653(JSONException var0) {
      return var0;
   }
}
