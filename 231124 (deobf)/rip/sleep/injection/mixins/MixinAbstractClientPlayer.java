package rip.sleep.injection.mixins;

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
import rip.sleep.command.commands.ChangeSkinCommand;
import rip.sleep.management.SkinManager;

@SideOnly(Side.CLIENT)
@Mixin({AbstractClientPlayer.class})
public abstract class MixinAbstractClientPlayer extends MixinEntityPlayer {
   @Inject(
      method = {"getLocationSkin()Lnet/minecraft/util/ResourceLocation;"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getSkin(CallbackInfoReturnable<ResourceLocation> var1) {
      if (Objects.equals(this.func_146103_bH().getName(), Minecraft.getMinecraft().thePlayer.getGameProfile().getName()) && !ChangeSkinCommand.c22987.isEmpty()) {
         var1.setReturnValue(SkinManager.c19604.c56907(ChangeSkinCommand.c22987));
      }
   }

   @Inject(
      method = {"getSkinType"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getSkinType(CallbackInfoReturnable<String> var1) {
      if (Objects.equals(this.func_146103_bH().getName(), Minecraft.getMinecraft().thePlayer.getGameProfile().getName()) && !ChangeSkinCommand.c22987.isEmpty()) {
         var1.setReturnValue(ChangeSkinCommand.c74114 ? "slim" : "default");
      }
   }
}
