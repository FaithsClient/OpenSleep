package linxiu.injection.mixins;

import linxiu.management.ModuleManager;
import linxiu.module.modules.uhc.Freecam;
import linxiu.module.modules.uhc.Xray;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VisGraph.class)
public abstract class MixinVisGraph {
	
	
	@Inject(method = "func_178606_a", at = @At("HEAD"))
	private void func_178606_a(BlockPos pos, CallbackInfo ci) {
		 if (Xray.isEnabled || ModuleManager.getModuleByClass(Freecam.class).isEnabled()) {
         }
	}
}
