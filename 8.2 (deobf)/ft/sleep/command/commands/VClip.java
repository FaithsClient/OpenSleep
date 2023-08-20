//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.command.commands;

import ft.sleep.command.Command;
import ft.sleep.util.math.MathUtil;
import ft.sleep.util.other.Helper;
import ft.sleep.util.timer.TimerUtil;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.util.EnumChatFormatting;

public class VClip extends Command {
   public TimerUtil header$ = new TimerUtil();

   public VClip() {
      super("Vc", new String[]{"Vclip", "clip", "verticalclip", "clip"}, "", "Teleport down a specific ammount");
   }

   public String _absolute(String[] enuyunup) {
      if (!Helper._atlantic("enjoytheban")) {
         if (((Object[])enuyunup).length > 0) {
            if (MathUtil._racks((String)((Object[])enuyunup)[0], (byte)4)) {
               Object tupagese = Float.parseFloat((String)((Object[])enuyunup)[0]);
               if (Helper.sprint$.thePlayer.ticksExisted % 12 == 0) {
                  Helper.sprint$.thePlayer.sendQueue.addToSendQueue(new C04PacketPlayerPosition(Helper.sprint$.thePlayer.posX, Helper.sprint$.thePlayer.posY - (double)tupagese, Helper.sprint$.thePlayer.posZ, true));
                  Helper.sprint$.thePlayer.setPosition(Helper.sprint$.thePlayer.posX, Helper.sprint$.thePlayer.posY + (double)tupagese, Helper.sprint$.thePlayer.posZ);
               }

               Helper._seller("> Vclipped " + tupagese + " blocks");
            } else {
               ateligeg._kidney(EnumChatFormatting.GRAY + ((Object[])enuyunup)[0] + " is not a valid number");
            }
         } else {
            ateligeg._kidney(EnumChatFormatting.GRAY + "Valid .vclip <number>");
         }
      } else {
         Helper._seller("> You cannot use vclip on the ETB Server.");
      }

      return null;
   }
}
