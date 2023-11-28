package rip.sleep.injection.mixins;

import rip.sleep.injection.in.IS12PacketEntityVelocity;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({S12PacketEntityVelocity.class})
public class MixinS12PacketEntityVelocity implements IS12PacketEntityVelocity {
   @Shadow
   private int field_149415_b;
   @Shadow
   private int field_149416_c;
   @Shadow
   private int field_149414_d;

   public void setX(int var1) {
      this.field_149415_b = var1;
   }

   public void setY(int var1) {
      this.field_149416_c = var1;
   }

   public void setZ(int var1) {
      this.field_149414_d = var1;
   }
}
