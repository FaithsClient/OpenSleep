/*
 * Decompiled with CFR 0_132.
 */
package linxiu.command.commands;

import linxiu.command.Command;
import linxiu.utils.Helper;
import linxiu.utils.math.MathUtil;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.EnumChatFormatting;

public class VClip
extends Command {
    private final TimerUtil timer = new TimerUtil();

    public VClip() {
        super("Vc", new String[]{"Vclip", "clip", "verticalclip", "clip"}, "", "Teleport down a specific ammount");
    }

    @Override
    public String execute(String[] args) {
        if (!Helper.onServer("enjoytheban")) {
            if (args.length > 0) {
                if (MathUtil.parsable(args[0], (byte)4)) {
                    float distance = Float.parseFloat(args[0]);
                    if (Helper.mc.thePlayer.ticksExisted % 12 == 0) {
                    	Helper.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(Helper.mc.thePlayer.posX, Helper.mc.thePlayer.posY - (double)distance, Helper.mc.thePlayer.posZ, true));
                        Helper.mc.thePlayer.setPosition(Helper.mc.thePlayer.posX, Helper.mc.thePlayer.posY + (double)distance, Helper.mc.thePlayer.posZ);
                    }
                    Helper.sendMessage("> Vclipped " + distance + " blocks");
                } else {
                    this.syntaxError(EnumChatFormatting.GRAY + args[0] + " is not a valid number");
                }
            } else {
                this.syntaxError(EnumChatFormatting.GRAY + "Valid .vclip <number>");
            }
        } else {
            Helper.sendMessage("> You cannot use vclip on the ETB Server.");
        }
        return null;
    }
}

