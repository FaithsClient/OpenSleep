//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(Side.CLIENT)
@Mixin({AbstractClientPlayer.class})
public abstract class MixinAbstractClientPlayer extends MixinEntityPlayer {
   @Inject(
      method = {"getLocationSkin()Lnet/minecraft/util/ResourceLocation;"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getSkin(CallbackInfoReturnable callbackInfoReturnable) {
      if (Objects.equals(this.getGameProfile().getName(), Minecraft.getMinecraft().thePlayer.getGameProfile().getName()) && !î “î ”î ?.î “î ‘î ?.isEmpty()) {
         callbackInfoReturnable.setReturnValue(î ”î ”î ”î ‘î ?.î ?.î ?(î “î ”î ?.î “î ‘î ?));
      }
   }

   @Inject(
      method = {"getSkinType"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getSkinType(CallbackInfoReturnable callbackInfoReturnable) {
      if (Objects.equals(this.getGameProfile().getName(), Minecraft.getMinecraft().thePlayer.getGameProfile().getName()) && !î “î ”î ?.î “î ‘î ?.isEmpty()) {
         callbackInfoReturnable.setReturnValue(î “î ”î ?.î “î ”î ? ? "slim" : "default");
      }
   }
}
