package rip.sleep.injection.mixins;

import java.io.IOException;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.module.modules.TargetHUD;
import rip.sleep.module.modules.HUD;
import rip.sleep.Sleep;
import rip.sleep.module.modules.TargetList;

@SideOnly(Side.CLIENT)
@Mixin({GuiChat.class})
public abstract class MixinGuiChat extends GuiScreen {
   @Shadow
   protected GuiTextField field_146415_a;
   private int x;
   private int y;
   private int dragX;
   private int dragY;
   private int x2;
   private int y2;
   private boolean dragging;
   private int dragX2;
   private int dragY2;
   private boolean dragging2;

   @Inject(
      method = {"initGui"},
      at = {@At("RETURN")}
   )
   private void init(CallbackInfo var1) {
      this.dragging = false;
   }

   public void mouseReleased(int var1, int var2, int var3) {
      if (HUD.c91289(var1, var2)) {
         this.dragX = var1 - HUD.c46389();
         this.dragY = var2 - HUD.c28175();
         this.dragging = false;
      }

      if (TargetHUD.c91289(var1, var2)) {
         this.dragX = var1 - TargetHUD.c46389();
         this.dragY = var2 - TargetHUD.c28175();
         this.dragging = false;
         if (Sleep.INSTANCE.c43557() != null) {
            Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c94512);
         }
      }

      if (TargetList.c91289(var1, var2)) {
         this.dragX2 = var1 - TargetList.c70725();
         this.dragY2 = var2 - TargetList.c78433();
         this.dragging2 = false;
         if (Sleep.INSTANCE.c43557() != null) {
            Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c94512);
         }
      }

   }

   @Overwrite
   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      IChatComponent var4 = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
      if (!HUD.c91289(var1, var2) && (!var4.getClass().getName().startsWith("net.labymod") || !var4.getClass().getSimpleName().equals("ModGuiChat"))) {
         if (!TargetHUD.c91289(var1, var2) && (!var4.getClass().getName().startsWith("net.labymod") || !var4.getClass().getSimpleName().equals("ModGuiChat"))) {
            if (TargetList.c91289(var1, var2)) {
               this.dragX2 = var1 - TargetList.c70725();
               this.dragY2 = var2 - TargetList.c78433();
               this.dragging2 = true;
            } else if (!this.handleComponentClick(var4)) {
               this.field_146415_a.mouseClicked(var1, var2, var3);
               super.mouseClicked(var1, var2, var3);
            }
         } else {
            this.dragX = var1 - TargetHUD.c46389();
            this.dragY = var2 - TargetHUD.c28175();
            this.dragging = true;
         }
      } else {
         this.dragX = var1 - HUD.c46389();
         this.dragY = var2 - HUD.c28175();
         this.dragging = true;
      }
   }

   @Inject(
      method = {"drawScreen"},
      at = {@At("HEAD")}
   )
   public void mouse(int var1, int var2, float var3, CallbackInfo var4) {
      if (HUD.c91289(var1, var2)) {
         if (!Mouse.isButtonDown(0) && this.dragging) {
            this.dragging = false;
         }

         if (this.dragging) {
            HUD.c95424(var1 - this.dragX);
            HUD.c88120(var2 - this.dragY);
         }
      }

      if (TargetList.c91289(var1, var2)) {
         if (!Mouse.isButtonDown(0) && this.dragging2) {
            this.dragging2 = false;
            if (Sleep.INSTANCE.c43557() != null) {
               Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c94512);
            }
         }

         if (this.dragging2) {
            TargetList.c93075(var1 - this.dragX2);
            TargetList.c92639(var2 - this.dragY2);
         }
      }

      if (TargetHUD.c91289(var1, var2)) {
         if (!Mouse.isButtonDown(0) && this.dragging) {
            this.dragging = false;
            if (Sleep.INSTANCE.c43557() != null) {
               Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c94512);
            }
         }

         if (this.dragging) {
            TargetHUD.c95424(var1 - this.dragX);
            TargetHUD.c88120(var2 - this.dragY);
         }
      }

   }
}
