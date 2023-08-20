//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.world.ChatEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({GuiNewChat.class})
public abstract class MixinGuiNewChat {
   @Shadow
   private static final Logger logger = LogManager.getLogger();
   private String lastMessage = "";
   private int amount;
   private int line;

   @Shadow
   protected abstract void setChatLine(IChatComponent var1, int var2, int var3, boolean var4);

   @Overwrite
   public void printChatMessage(IChatComponent chatComponent) {
      if (!î ‘î ”î “î ”.î ?.getSetting("AntiSpam").getValue().booleanValue()) {
         this.printChatMessageWithOptionalDeletion(chatComponent, this.line);
      } else {
         String rawMessage = this.fixString(chatComponent.getFormattedText());
         if (this.lastMessage.equals(rawMessage)) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().deleteChatLine(this.line);
            ++this.amount;
            chatComponent.appendText(EnumChatFormatting.GRAY + " [x" + this.amount + "]");
         } else {
            this.amount = 1;
         }

         ++this.line;
         this.lastMessage = rawMessage;
         if (this.line > 256) {
            this.line = 0;
         }

         this.printChatMessageWithOptionalDeletion(chatComponent, this.line);
      }
   }

   private String fixString(String str) {
      str = str.replaceAll("\uf8ff", "");
      StringBuilder sb = new StringBuilder();

      for(char c : str.toCharArray()) {
         if (c > 'ï¼?' && c < 'ï½?') {
            sb.append(Character.toChars(c - 'ï»?'));
         } else {
            sb.append(c);
         }
      }

      return sb.toString();
   }

   @Overwrite
   public void printChatMessageWithOptionalDeletion(IChatComponent chatComponent, int chatLineId) {
      ChatEvent event = new ChatEvent(chatComponent.getUnformattedText(), chatComponent);
      EventBus.getInstance().call(event);
      if (!event.isCancelled()) {
         this.setChatLine(event.getChatComponent(), chatLineId, Minecraft.getMinecraft().ingameGUI.getUpdateCounter(), false);
         logger.info("[CHAT] " + event.getChatComponent().getUnformattedText());
      }
   }
}
