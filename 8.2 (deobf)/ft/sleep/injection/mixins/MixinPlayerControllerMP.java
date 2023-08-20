//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.world.EventAttack;
import ft.sleep.api.events.world.EventDamageBlock;
import ft.sleep.injection.interfaces.IPlayerControllerMP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.WorldSettings.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PlayerControllerMP.class})
public abstract class MixinPlayerControllerMP implements IPlayerControllerMP {
   @Shadow
   private final Minecraft mc;
   @Shadow
   private GameType currentGameType = GameType.SURVIVAL;
   @Shadow
   private BlockPos currentBlock = new BlockPos(-1, -1, -1);
   @Shadow
   private final NetHandlerPlayClient netClientHandler;

   @Shadow
   public abstract void syncCurrentPlayItem();

   public MixinPlayerControllerMP(Minecraft mcIn, NetHandlerPlayClient p_i45062_2_) {
      this.mc = mcIn;
      this.netClientHandler = p_i45062_2_;
   }

   public void runsyncCurrentPlayItem() {
      this.syncCurrentPlayItem();
   }

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPlayerDamageBlock(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable ci) {
      EventDamageBlock event = new EventDamageBlock(posBlock, directionFacing);
      EventBus.getInstance().call(event);
      if (event.isCancelled()) {
         ci.setReturnValue(Boolean.valueOf(false));
      }

   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("HEAD")}
   )
   public void attack(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
      EventBus.getInstance().call(new EventAttack(targetEntity, true));
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("RETURN")}
   )
   public void attack2(EntityPlayer playerIn, Entity targetEntity, CallbackInfo info) {
      EventBus.getInstance().call(new EventAttack(targetEntity, false));
   }
}
