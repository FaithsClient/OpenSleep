package rip.sleep.injection.mixins;

import rip.sleep.injection.in.IRenderManager;
import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({RenderManager.class})
public class MixinRenderManager implements IRenderManager {
   @Shadow
   private double field_78725_b;
   @Shadow
   private double field_78726_c;
   @Shadow
   private double field_78723_d;
   @Shadow
   private double field_78730_l;
   @Shadow
   private double field_78731_m;
   @Shadow
   private double field_78728_n;

   public double getVieWerPosX() {
      return this.field_78730_l;
   }

   public double getVieWerPosY() {
      return this.field_78731_m;
   }

   public double getVieWerPosZ() {
      return this.field_78728_n;
   }

   public double getRenderPosX() {
      return this.field_78725_b;
   }

   public double getRenderPosY() {
      return this.field_78726_c;
   }

   public double getRenderPosZ() {
      return this.field_78723_d;
   }
}
