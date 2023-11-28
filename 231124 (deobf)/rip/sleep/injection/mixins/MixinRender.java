package rip.sleep.injection.mixins;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({Render.class})
public abstract class MixinRender {
   @Shadow
   protected RenderManager field_76990_c;

   @Shadow
   public <T extends Entity> void func_76986_a(T var1, double var2, double var4, double var6, float var8, float var9) {
   }

   @Shadow
   protected abstract <T extends Entity> boolean func_180548_c(T var1);
}
