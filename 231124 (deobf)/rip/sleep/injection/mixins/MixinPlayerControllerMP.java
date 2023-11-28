package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import rip.sleep.injection.in.IPlayerControllerMP;
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
import rip.sleep.event.events.AttackEntityEvent;
import rip.sleep.event.events.DamageBlockEvent;

@Mixin({PlayerControllerMP.class})
public abstract class MixinPlayerControllerMP implements IPlayerControllerMP {
   @Shadow
   private final Minecraft field_78776_a;
   @Shadow
   private GameType field_78779_k = GameType.SURVIVAL;
   @Shadow
   private BlockPos field_178895_c = new BlockPos(-1, -1, -1);
   @Shadow
   private final NetHandlerPlayClient field_78774_b;

   @Shadow
   public abstract void func_78750_j();

   public MixinPlayerControllerMP(Minecraft var1, NetHandlerPlayClient var2) {
      this.field_78776_a = var1;
      this.field_78774_b = var2;
   }

   public void runsyncCurrentPlayItem() {
      this.func_78750_j();
   }

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPlayerDamageBlock(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
      DamageBlockEvent var4 = new DamageBlockEvent(var1, var2);
      EventBus.getInstance().call(var4);
      if (var4.c58917()) {
         var3.setReturnValue(Boolean.valueOf(false));
      }

   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("HEAD")}
   )
   public void attack(EntityPlayer var1, Entity var2, CallbackInfo var3) {
      EventBus.getInstance().call(new AttackEntityEvent(var2, true));
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("RETURN")}
   )
   public void attack2(EntityPlayer var1, Entity var2, CallbackInfo var3) {
      EventBus.getInstance().call(new AttackEntityEvent(var2, false));
   }
}
