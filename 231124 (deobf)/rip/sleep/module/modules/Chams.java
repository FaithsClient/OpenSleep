package rip.sleep.module.modules;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PostRenderLivingEvent;
import rip.sleep.event.events.PreRenderLivingEvent;
import rip.sleep.event.events.UnknownRenderEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class Chams extends Module {
   private final BooleanValue c72983 = new BooleanValue("New", true);

   public Chams() {
      super("Chams", new String[]{"Chams"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   public void c83205() {
      super.c83205();
   }

   @EventTarget
   public void c33920(PreRenderLivingEvent var1) {
      Module[] var2 = Value.c27574();
      if (!this.c72983.c1473().booleanValue()) {
         mc.entityRenderer.disableLightmap();
         GlStateManager.disableLighting();
         GL11.glEnable(32823);
         GL11.glPolygonOffset(1.0F, -1100000.0F);
      }

   }

   @EventTarget
   public void c45347(PostRenderLivingEvent var1) {
      Module[] var2 = Value.c27574();
      if (!this.c72983.c1473().booleanValue()) {
         GL11.glDisable(32823);
         GL11.glPolygonOffset(1.0F, 1100000.0F);
         mc.entityRenderer.disableLightmap();
         GlStateManager.disableLighting();
      }

   }

   @EventTarget
   public void c91847(UnknownRenderEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c72983.c1473().booleanValue()) {
         if (var1.c74212() instanceof EntityPlayer && var1.c74212() != mc.thePlayer && var1.c1161()) {
            GL11.glEnable(32823);
            GL11.glPolygonOffset(1.0F, -1100000.0F);
         }

         if (var1.c74212() instanceof EntityPlayer && var1.c64297()) {
            GL11.glDisable(32823);
            GL11.glPolygonOffset(1.0F, 1100000.0F);
         }
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
