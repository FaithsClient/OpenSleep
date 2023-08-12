package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.world.EventAttack;
import linxiu.injection.interfaces.IPlayerControllerMP;
import linxiu.management.ModuleManager;
import linxiu.module.modules.ghost.Reach;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerControllerMP.class)
public abstract class MixinPlayerControllerMP implements IPlayerControllerMP {
	@Shadow
	private WorldSettings.GameType currentGameType;

	@Shadow
	private float curBlockDamageMP;

	@Shadow
	private int blockHitDelay;

	@Shadow
	public abstract void syncCurrentPlayItem();

	@Override
	public void runsyncCurrentPlayItem() {
		this.syncCurrentPlayItem();
	}

	@Inject(method = "attackEntity", at = { @At("HEAD") })
	public void attack(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
		EventBus.getInstance().call(new EventAttack(targetEntity, true));
	}

	@Inject(method = "attackEntity", at = { @At("RETURN") })
	public void attack2(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
		EventBus.getInstance().call(new EventAttack(targetEntity, false));
	}

	@Override
	public float getCurBlockDamageMP() {
		// TODO Auto-generated method stub
		return curBlockDamageMP;
	}

	@Override
	public int getBlockDELAY() {
		return blockHitDelay;

	}

	@Override
	public void setCurBlockDamageMP(float f) {
		curBlockDamageMP = f;

	}

	@Override
	public void setBlockHitDelay(int i) {
		blockHitDelay = i;

	}
}
