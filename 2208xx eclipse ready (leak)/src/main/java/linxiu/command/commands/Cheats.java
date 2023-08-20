/*
 * Decompiled with CFR 0_132.
 */
package linxiu.command.commands;

import linxiu.Client;
import linxiu.command.Command;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.utils.Helper;
import net.minecraft.util.EnumChatFormatting;

public class Cheats
extends Command {
    public Cheats() {
        super("Cheats", new String[]{"mods"}, "", "sketit");
    }

    @Override
    public String execute(String[] args) {
        if (args.length == 0) {
            Client.getModuleManager();
            StringBuilder list = new StringBuilder(ModuleManager.getModules().size() + " Cheats - ");
            Client.getModuleManager();
            for (Module cheat : ModuleManager.getModules()) {
                list.append(cheat.isEnabled() ? EnumChatFormatting.GREEN : EnumChatFormatting.RED).append(cheat.getName()).append(", ");
            }
            Helper.sendMessage("> " + list.substring(0, list.toString().length() - 2));
        } else {
            Helper.sendMessage("> Correct usage .cheats");
        }
        return null;
    }
}

