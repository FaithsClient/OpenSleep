//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import java.io.IOException;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
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

@SideOnly(Side.CLIENT)
@Mixin({GuiChat.class})
public abstract class MixinGuiChat extends GuiScreen {
   @Shadow
   protected net.minecraft.client.gui.GuiTextField inputField;
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
   private void init(CallbackInfo callbackInfo) {
      this.dragging = false;
   }

   public void mouseReleased(int mouseX, int mouseY, int state) {
      if (.�?(mouseX, mouseY) && state == 0) {
         this.dragX = mouseX - .�?();
         this.dragY = mouseY - .�?();
         this.dragging = false;
      }

      if (.�?(mouseX, mouseY) && state == 0) {
         this.dragX = mouseX - .�?();
         this.dragY = mouseY - .�?();
         this.dragging = false;
         if (�?.�?.�?() != null) {
            �?.�?.�?().saveConfig(�?.�?.�?().configs);
         }
      }

      if (.�?(mouseX, mouseY) && state == 0) {
         this.dragX2 = mouseX - .�?();
         this.dragY2 = mouseY - .�?();
         this.dragging2 = false;
         if (�?.�?.�?() != null) {
            �?.�?.�?().saveConfig(�?.�?.�?().configs);
         }
      }

   }

   @Overwrite
   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
      IChatComponent ichatcomponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
      if ((.�?(mouseX, mouseY) || ichatcomponent != null && ichatcomponent.getClass().getName().startsWith("net.labymod") && ichatcomponent.getClass().getSimpleName().equals("ModGuiChat")) && mouseButton == 0) {
         this.dragX = mouseX - .�?();
         this.dragY = mouseY - .�?();
         this.dragging = true;
      } else if ((.�?(mouseX, mouseY) || ichatcomponent != null && ichatcomponent.getClass().getName().startsWith("net.labymod") && ichatcomponent.getClass().getSimpleName().equals("ModGuiChat")) && mouseButton == 0) {
         this.dragX = mouseX - .�?();
         this.dragY = mouseY - .�?();
         this.dragging = true;
      } else if (.�?(mouseX, mouseY) && mouseButton == 0) {
         this.dragX2 = mouseX - .�?();
         this.dragY2 = mouseY - .�?();
         this.dragging2 = true;
      } else if (mouseButton != 0 || !this.handleComponentClick(ichatcomponent)) {
         this.inputField.mouseClicked(mouseX, mouseY, mouseButton);
         super.mouseClicked(mouseX, mouseY, mouseButton);
      }
   }

   @Inject(
      method = {"drawScreen"},
      at = {@At("HEAD")}
   )
   public void mouse(int mouseX, int mouseY, float partialTicks, CallbackInfo info) {
      if (.�?(mouseX, mouseY)) {
         if (!Mouse.isButtonDown(0) && this.dragging) {
            this.dragging = false;
         }

         if (this.dragging) {
            .�?(mouseX - this.dragX);
            .�?(mouseY - this.dragY);
         }
      }

      if (.�?(mouseX, mouseY)) {
         if (!Mouse.isButtonDown(0) && this.dragging2) {
            this.dragging2 = false;
            if (�?.�?.�?() != null) {
               �?.�?.�?().saveConfig(�?.�?.�?().configs);
            }
         }

         if (this.dragging2) {
            .�?(mouseX - this.dragX2);
            .�?(mouseY - this.dragY2);
         }
      }

      if (.�?(mouseX, mouseY)) {
         if (!Mouse.isButtonDown(0) && this.dragging) {
            this.dragging = false;
            if (�?.�?.�?() != null) {
               �?.�?.�?().saveConfig(�?.�?.�?().configs);
            }
         }

         if (this.dragging) {
            .�?(mouseX - this.dragX);
            .�?(mouseY - this.dragY);
         }
      }

   }
}
