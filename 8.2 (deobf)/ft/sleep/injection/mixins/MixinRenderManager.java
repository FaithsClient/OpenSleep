//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.injection.interfaces.IRenderManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({RenderManager.class})
public class MixinRenderManager implements IRenderManager {
   @Shadow
   private double renderPosX;
   @Shadow
   private double renderPosY;
   @Shadow
   private double renderPosZ;
   @Shadow
   private double viewerPosX;
   @Shadow
   private double viewerPosY;
   @Shadow
   private double viewerPosZ;

   public double getVieWerPosX() {
      return this.viewerPosX;
   }

   public double getVieWerPosY() {
      return this.viewerPosY;
   }

   public double getVieWerPosZ() {
      return this.viewerPosZ;
   }

   public double getRenderPosX() {
      return this.renderPosX;
   }

   public double getRenderPosY() {
      return this.renderPosY;
   }

   public double getRenderPosZ() {
      return this.renderPosZ;
   }
}
