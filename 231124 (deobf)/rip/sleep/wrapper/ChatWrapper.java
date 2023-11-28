package rip.sleep.wrapper;

import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent.Serializer;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.value.Value;

public class ChatWrapper {
   private final ChatComponentText c22015;
   public static final String c67797 = "§7";
   public static final String c93418 = "§1";
   private static final String c88138 = "§7[§1Sleep§7] ";

   private ChatWrapper(ChatComponentText var1) {
      this.c22015 = var1;
   }

   public static String c57919(String var0, String var1) {
      return var0.replaceAll("(?i)" + var1 + "([0-9a-fklmnor])", "§$1");
   }

   public void c33039() {
      Minecraft.getMinecraft().thePlayer.addChatMessage(this.c22015);
   }

   private ChatComponentText c60394() {
      return this.c22015;
   }

   ChatWrapper(ChatComponentText var1, ChatWrapper var2) {
      this(var1);
   }

   public static void c77151(String var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("text", var0);
      Minecraft.getMinecraft().thePlayer.addChatMessage(Serializer.jsonToComponent(var1.toString()));
   }

   public static void c82702(String var0) {
      c77151("§7[§1Sleep§7] " + var0);
   }

   public static class c83885 {
      private static final EnumChatFormatting c76019 = EnumChatFormatting.WHITE;
      private final ChatComponentText c31531 = new ChatComponentText("");
      private boolean c39555;
      private ChatStyle c52067;
      private ChatComponentText c49308;

      public c83885(boolean var1, boolean var2) {
         Value.c27574();
         this.c39555 = false;
         this.c52067 = new ChatStyle();
         this.c49308 = new ChatComponentText("");
         Sleep.INSTANCE.getClass();
         this.c31531.appendSibling((new ChatWrapper.c83885(false, false)).c87734(EnumChatFormatting.BOLD + "Sleep: ").c30477(EnumChatFormatting.RED).c49484().c60394());
         this.c39555 = var2;
      }

      public c83885() {
         this.c39555 = false;
         this.c52067 = new ChatStyle();
         this.c49308 = new ChatComponentText("");
      }

      public ChatWrapper.c83885 c87734(String var1) {
         this.c10024();
         Value.c27574();
         this.c49308 = new ChatComponentText(var1);
         this.c52067 = new ChatStyle();
         if (this.c39555) {
            this.c30477(c76019);
         }

         return this;
      }

      public ChatWrapper.c83885 c30477(EnumChatFormatting var1) {
         this.c52067.setColor(var1);
         return this;
      }

      public ChatWrapper.c83885 c75458() {
         this.c52067.setBold(Boolean.valueOf(true));
         return this;
      }

      public ChatWrapper.c83885 c48173() {
         this.c52067.setItalic(Boolean.valueOf(true));
         return this;
      }

      public ChatWrapper.c83885 c4929() {
         this.c52067.setStrikethrough(Boolean.valueOf(true));
         return this;
      }

      public ChatWrapper.c83885 c19372() {
         this.c52067.setUnderlined(Boolean.valueOf(true));
         return this;
      }

      public ChatWrapper c49484() {
         this.c10024();
         return new ChatWrapper(this.c31531, (ChatWrapper)null);
      }

      private void c10024() {
         this.c31531.appendSibling(this.c49308.setChatStyle(this.c52067));
      }

      private static JSONException c22(JSONException var0) {
         return var0;
      }
   }
}
