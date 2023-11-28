package rip.sleep.injection.mixins;

import com.mojang.authlib.GameProfile;
import rip.sleep.injection.in.IEntityPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({EntityPlayer.class})
public abstract class MixinEntityPlayer implements IEntityPlayer {
   @Shadow
   private ItemStack field_71074_e;
   @Shadow
   public int field_71072_f;
   @Shadow
   public float field_71102_ce;
   @Shadow
   public PlayerCapabilities field_71075_bZ = new PlayerCapabilities();

   public boolean isAllowEdit() {
      return this.field_71075_bZ.allowEdit;
   }

   @Shadow
   public abstract GameProfile func_146103_bH();

   @Shadow
   public abstract boolean func_71039_bw();

   @Shadow
   public abstract ItemStack func_71011_bu();

   public void setSpeedInAir(float var1) {
      this.field_71102_ce = var1;
   }

   public float getSpeedInAir() {
      return this.field_71102_ce;
   }

   public void setItemInUseCount(int var1) {
      this.field_71072_f = var1;
   }

   public int getItemInUseCount() {
      return this.field_71072_f;
   }

   public boolean isFood() {
      return this.func_71039_bw() && (this.field_71074_e.getItem().getItemUseAction(this.field_71074_e) == EnumAction.EAT || this.field_71074_e.getItem().getItemUseAction(this.field_71074_e) == EnumAction.DRINK);
   }
}
