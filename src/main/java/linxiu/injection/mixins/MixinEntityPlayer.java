package linxiu.injection.mixins;

import com.mojang.authlib.GameProfile;
import linxiu.injection.interfaces.IEntityPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityPlayer.class)
public abstract class MixinEntityPlayer implements IEntityPlayer {

	@Shadow
	public int itemInUseCount;
	@Shadow
	public float speedInAir;

	@Shadow
	public PlayerCapabilities capabilities = new PlayerCapabilities();

	@Override
	public boolean isAllowEdit() {
		return this.capabilities.allowEdit;
	}

	@Shadow
	public abstract GameProfile getGameProfile();

	@Override
	public void setSpeedInAir(float i) {
		speedInAir = i;
	}

	@Override
	public float getSpeedInAir() {
		return speedInAir;
	}

	@Override
	public void setItemInUseCount(int i) {
		itemInUseCount = i;
	}
}
