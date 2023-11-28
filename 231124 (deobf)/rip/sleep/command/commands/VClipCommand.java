package rip.sleep.command.commands;

import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.util.MathUtilB;
import rip.sleep.util.TimerUtilF;
import rip.sleep.value.Value;

public class VClipCommand extends Command {
   private final TimerUtilF c91392 = new TimerUtilF();

   public VClipCommand() {
      super("Vc", new String[]{"Vclip", "clip", "verticalclip", "clip"}, "", "Teleport down a specific ammount");
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (!ChatUtilA.c29634("enjoytheban")) {
         if (var1.length > 0) {
            if (MathUtilB.c81955(var1[0], (byte)4)) {
               float var3 = Float.parseFloat(var1[0]);
               ChatUtilA.mc.thePlayer.sendQueue.addToSendQueue(new C04PacketPlayerPosition(ChatUtilA.mc.thePlayer.posX, ChatUtilA.mc.thePlayer.posY - (double)var3, ChatUtilA.mc.thePlayer.posZ, true));
               ChatUtilA.mc.thePlayer.setPosition(ChatUtilA.mc.thePlayer.posX, ChatUtilA.mc.thePlayer.posY + (double)var3, ChatUtilA.mc.thePlayer.posZ);
               ChatUtilA.c34080("> Vclipped " + var3 + " blocks");
            }

            this.c73172(EnumChatFormatting.GRAY + var1[0] + " is not a valid number");
         }

         this.c73172(EnumChatFormatting.GRAY + "Valid .vclip <number>");
      }

      ChatUtilA.c34080("> You cannot use vclip on the ETB Server.");
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
