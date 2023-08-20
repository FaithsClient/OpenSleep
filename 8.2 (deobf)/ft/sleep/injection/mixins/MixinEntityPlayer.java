//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import com.mojang.authlib.GameProfile;
import ft.sleep.injection.interfaces.IEntityPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({EntityPlayer.class})
public abstract class MixinEntityPlayer implements IEntityPlayer {
   @Shadow
   private ItemStack itemInUse;
   @Shadow
   public int itemInUseCount;
   @Shadow
   public float speedInAir;
   @Shadow
   public PlayerCapabilities capabilities = new PlayerCapabilities();

   public boolean isAllowEdit() {
      return this.capabilities.allowEdit;
   }

   @Shadow
   public abstract GameProfile getGameProfile();

   @Shadow
   public abstract boolean isUsingItem();

   @Shadow
   public abstract ItemStack getItemInUse();

   public void setSpeedInAir(float i) {
      this.speedInAir = i;
   }

   public float getSpeedInAir() {
      return this.speedInAir;
   }

   public void setItemInUseCount(int i) {
      this.itemInUseCount = i;
   }

   public boolean isFood() {
      return this.isUsingItem() && (this.itemInUse.getItem().getItemUseAction(this.itemInUse) == EnumAction.EAT || this.itemInUse.getItem().getItemUseAction(this.itemInUse) == EnumAction.DRINK);
   }
}
