package rip.sleep.injection.mixins;

import rip.sleep.injection.in.IS27PacketExplosion;
import net.minecraft.network.play.server.S27PacketExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({S27PacketExplosion.class})
public class MixinS27PacketExplosion implements IS27PacketExplosion {
   @Shadow
   private float field_149152_f;
   @Shadow
   private float field_149153_g;
   @Shadow
   private float field_149159_h;

   public void setX(float var1) {
      this.field_149152_f = var1;
   }

   public void setY(float var1) {
      this.field_149153_g = var1;
   }

   public void setZ(float var1) {
      this.field_149159_h = var1;
   }
}
