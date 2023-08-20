//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.misc.EventTitle;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.events.rendering.EventRenderGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SideOnly(Side.CLIENT)
@Mixin({GuiIngame.class})
public class MixinGuiIngame extends Gui {
   public Minecraft mc;
   @Shadow
   public String displayedTitle = "";
   @Shadow
   public String displayedSubTitle = "";
   @Shadow
   public int titlesTimer;
   @Shadow
   public int titleFadeIn;
   @Shadow
   public int titleDisplayTime;
   @Shadow
   public int titleFadeOut;

   @Inject(
      method = {"showCrosshair"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void injectCrosshair(CallbackInfoReturnable cir) {
      if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1 || Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
         cir.setReturnValue(Boolean.valueOf(false));
      }

   }

   @Inject(
      method = {"renderBossHealth"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderBossHealth(CallbackInfo ci) {
      �?.�?();
       camera2 = ().�?(.class);
      �?.�?();
       camera = ().�?(.class);
      �?.�?();
       staff = ().�?(.class);
      if (camera.�?() && .�?.getValue().booleanValue() || staff.�?() || .�?.getValue().booleanValue()) {
         ci.cancel();
      }

   }

   @Overwrite
   public void displayTitle(String title, String subTitle, int timeFadeIn, int displayTime, int timeFadeOut) {
      if (title == null && subTitle == null && timeFadeIn < 0 && displayTime < 0 && timeFadeOut < 0) {
         this.displayedTitle = "";
         this.displayedSubTitle = "";
         this.titlesTimer = 0;
      } else if (title != null) {
         EventBus.getInstance().call(new EventTitle(title));
         this.displayedTitle = title;
         this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
      } else if (subTitle != null) {
         this.displayedSubTitle = subTitle;
      } else {
         if (timeFadeIn >= 0) {
            this.titleFadeIn = timeFadeIn;
         }

         if (displayTime >= 0) {
            this.titleDisplayTime = displayTime;
         }

         if (timeFadeOut >= 0) {
            this.titleFadeOut = timeFadeOut;
         }

         if (this.titlesTimer > 0) {
            this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
         }
      }

   }

   @Inject(
      method = {"renderGameOverlay"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void renderGameOverlay(float partialTicks, CallbackInfo ci) {
      ScaledResolution scaledresolution = new ScaledResolution(this.mc);
      EventBus.getInstance().call(new EventRenderGui(scaledresolution));
      EventBus.getInstance().call(new EventRender2D(scaledresolution, partialTicks));
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }

   @Inject(
      method = {"renderTooltip"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderTooltip(ScaledResolution sr, float partialTicks, CallbackInfo ci) {
      EventBus.getInstance().call(new EventRender2D(sr, partialTicks));
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }
}
