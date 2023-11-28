package rip.sleep.injection.mixins;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import rip.sleep.util.ChatUtilA;

@Mixin({FontRenderer.class})
public abstract class MixinFontRenderer {
   @ModifyArg(
      method = {"renderString"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/FontRenderer;renderStringAtPos(Ljava/lang/String;Z)V"
)
   )
   public String changeString(String var1) {
      String var2 = ChatUtilA.mc.theWorld != null && ChatUtilA.mc.theWorld.getScoreboard() != null && ChatUtilA.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1) != null ? ChatUtilA.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName() : " ";
      return !StringUtils.stripControlCodes(var2).contains("MEGA WALLS") ? var1 : var1.replace("§k", "");
   }
}
