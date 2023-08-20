//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventPostRenderPlayer;
import ft.sleep.api.events.rendering.EventPreRenderPlayer;
import ft.sleep.api.events.rendering.EventRenderLivingEntity;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class Chams extends Module {
   public Option jungle$ = new Option("New", true);

   public Chams() {
      super("ft.sleep.module.modules.Chams", new String[]{"ft.sleep.module.modules.Chams"}, ModuleType.ignored$);
   }

   public void _regime() {
      super._regime();
   }

   @EventHandler
   public void _florists(EventPreRenderPlayer var1) {
      if (!opupudes.jungle$.getValue().booleanValue()) {
         opupudes.mc.entityRenderer.disableLightmap();
         GlStateManager.disableLighting();
         GL11.glEnable(32823);
         GL11.glPolygonOffset(1.0F, -1100000.0F);
      }

   }

   @EventHandler
   public void _remember(EventPostRenderPlayer var1) {
      if (!enabled.jungle$.getValue().booleanValue()) {
         GL11.glDisable(32823);
         GL11.glPolygonOffset(1.0F, 1100000.0F);
         enabled.mc.entityRenderer.disableLightmap();
         GlStateManager.disableLighting();
      }

   }

   @EventHandler
   public void _previews(EventRenderLivingEntity minus) {
      if (katrina.jungle$.getValue().booleanValue()) {
         if (((EventRenderLivingEntity)minus).getEntity() instanceof EntityPlayer && ((EventRenderLivingEntity)minus).getEntity() != katrina.mc.thePlayer && ((EventRenderLivingEntity)minus).isPre()) {
            GL11.glEnable(32823);
            GL11.glPolygonOffset(1.0F, -1100000.0F);
         } else if (((EventRenderLivingEntity)minus).getEntity() instanceof EntityPlayer && ((EventRenderLivingEntity)minus).isPost()) {
            GL11.glDisable(32823);
            GL11.glPolygonOffset(1.0F, 1100000.0F);
         }
      }

   }
}
