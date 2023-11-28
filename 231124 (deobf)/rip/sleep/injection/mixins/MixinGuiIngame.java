package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
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
import rip.sleep.module.modules.StaffAnalyser;
import rip.sleep.module.modules.HUD;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.Camera;
import rip.sleep.event.events.Render2DEventB;

@SideOnly(Side.CLIENT)
@Mixin({GuiIngame.class})
public class MixinGuiIngame extends Gui {
   public Minecraft mc;
   @Shadow
   public String field_175201_x = "";
   @Shadow
   public String field_175200_y = "";
   @Shadow
   public int field_175195_w;
   @Shadow
   public int field_175199_z;
   @Shadow
   public int field_175192_A;
   @Shadow
   public int field_175193_B;

   @Inject(
      method = {"showCrosshair"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void injectCrosshair(CallbackInfoReturnable<Boolean> var1) {
      if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 1 || Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
         var1.setReturnValue(Boolean.valueOf(false));
      }

   }

   @Inject(
      method = {"renderBossHealth"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderBossHealth(CallbackInfo var1) {
      Sleep var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      Camera var2 = (Camera) ModuleManager.c25475(Camera.class);
      var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      HUD var3 = (HUD) ModuleManager.c25475(HUD.class);
      var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      StaffAnalyser var4 = (StaffAnalyser) ModuleManager.c25475(StaffAnalyser.class);
      if (var3.c24622() && HUD.c7166.c1473().booleanValue() || var4.c24622() || Camera.c22415.c1473().booleanValue()) {
         var1.cancel();
      }

   }

   @Overwrite
   public void func_175178_a(String var1, String var2, int var3, int var4, int var5) {
      this.field_175201_x = "";
      this.field_175200_y = "";
      this.field_175195_w = 0;
   }

   @Inject(
      method = {"renderGameOverlay"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void renderGameOverlay(float var1, CallbackInfo var2) {
      ScaledResolution var3 = new ScaledResolution(this.mc);
      EventBus.getInstance().call(new Render2DEventB(var3));
      EventBus.getInstance().call(new Render2DEventA(var3, var1));
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }

   @Inject(
      method = {"renderTooltip"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderTooltip(ScaledResolution var1, float var2, CallbackInfo var3) {
      EventBus.getInstance().call(new Render2DEventA(var1, var2));
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }
}
