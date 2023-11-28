package rip.sleep.injection.mixins;

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
import rip.sleep.module.modules.NoBlockParticle;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;

@SideOnly(Side.CLIENT)
@Mixin({EffectRenderer.class})
public abstract class MixinEffectRenderer {
   @Shadow
   private List<EntityParticleEmitter> field_178933_d;

   @Shadow
   protected abstract void func_178922_a(int var1);

   @Overwrite
   public void func_78868_a() {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"addBlockDestroyEffects", "addBlockHitEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void removeBlockBreakingParticles(CallbackInfo var1) {
      Sleep var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      NoBlockParticle var2 = (NoBlockParticle) ModuleManager.c25475(NoBlockParticle.class);
      if (var2.c24622()) {
         var1.cancel();
      }

   }
}
