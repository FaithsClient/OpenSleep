package linxiu.injection.mixins;


import linxiu.injection.interfaces.IKeyBinding;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(KeyBinding.class)
public class MixinKeyBinding implements IKeyBinding {

	@Shadow
	private boolean pressed;
	
	@Override
	public boolean getPress() {
		return pressed;
	}

	@Override
	public void setPress(Boolean b) {
		pressed = b;
	}
	
}
