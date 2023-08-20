//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({FontRenderer.class})
public abstract class MixinFontRenderer {
   @ModifyArg(
      method = {"renderString"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/FontRenderer;renderStringAtPos(Ljava/lang/String;Z)V"
)
   )
   public String changeString(String in) {
      String title = �?.mc.theWorld != null && �?.mc.theWorld.getScoreboard() != null && �?.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1) != null ? �?.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName() : " ";
      return !StringUtils.stripControlCodes(title).contains("MEGA WALLS") ? in : in.replace("§k", "");
   }
}
