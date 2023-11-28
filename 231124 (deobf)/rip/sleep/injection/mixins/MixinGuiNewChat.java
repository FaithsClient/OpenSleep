package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.module.modules.MWAddons;
import rip.sleep.event.events.ChatReceivedEvent;

@Mixin({GuiNewChat.class})
public abstract class MixinGuiNewChat {
   @Shadow
   private static final Logger field_146249_a = LogManager.getLogger();
   private String lastMessage = "";
   private int amount;
   private int line;

   @Shadow
   protected abstract void func_146237_a(IChatComponent var1, int var2, int var3, boolean var4);

   @Overwrite
   public void func_146227_a(IChatComponent var1) {
      if (!MWAddons.c34018.c72319("AntiSpam").c1473().booleanValue()) {
         this.func_146234_a(var1, this.line);
      } else {
         String var2 = this.fixString(var1.getFormattedText());
         if (this.lastMessage.equals(var2)) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().deleteChatLine(this.line);
            ++this.amount;
            var1.appendText(EnumChatFormatting.GRAY + " [x" + this.amount + "]");
         } else {
            this.amount = 1;
         }

         ++this.line;
         this.lastMessage = var2;
         if (this.line > 256) {
            this.line = 0;
         }

         this.func_146234_a(var1, this.line);
      }
   }

   private String fixString(String var1) {
      var1 = var1.replaceAll("\uf8ff", "");
      StringBuilder var2 = new StringBuilder();

      for(char var6 : var1.toCharArray()) {
         if (var6 > '！' && var6 < '｠') {
            var2.append(Character.toChars(var6 - 'ﻠ'));
         } else {
            var2.append(var6);
         }
      }

      return var2.toString();
   }

   @Overwrite
   public void func_146234_a(IChatComponent var1, int var2) {
      ChatReceivedEvent var3 = new ChatReceivedEvent(var1.getUnformattedText(), var1);
      EventBus.getInstance().call(var3);
      if (!var3.c58917()) {
         this.func_146237_a(var3.c70851(), var2, Minecraft.getMinecraft().ingameGUI.getUpdateCounter(), false);
         field_146249_a.info("[CHAT] " + var3.c70851().getUnformattedText());
      }
   }
}
