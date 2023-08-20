//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityParticleEmitter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(Side.CLIENT)
@Mixin({EffectRenderer.class})
public abstract class MixinEffectRenderer {
   @Shadow
   private List particleEmitters;

   @Shadow
   protected abstract void updateEffectLayer(int var1);

   @Overwrite
   public void updateEffects() {
      try {
         for(int i = 0; i < 4; ++i) {
            this.updateEffectLayer(i);
         }

         Iterator it = this.particleEmitters.iterator();

         while(it.hasNext()) {
            EntityParticleEmitter entityParticleEmitter = (EntityParticleEmitter)it.next();
            entityParticleEmitter.onUpdate();
            if (entityParticleEmitter.isDead) {
               it.remove();
            }
         }
      } catch (ConcurrentModificationException var3) {
         ;
      }

   }

   @Inject(
      method = {"addBlockDestroyEffects", "addBlockHitEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void removeBlockBreakingParticles(CallbackInfo ci) {
      �?.�?();
       camera = ().�?(.class);
      if (camera.�?() && .�?.getValue().booleanValue()) {
         ci.cancel();
      }

   }
}
