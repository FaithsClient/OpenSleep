package linxiu.command.commands;



import java.io.IOException;

import linxiu.command.Command;
import linxiu.module.modules.player.IRC;
import linxiu.ui.IRCThread;

public class CommandReconnect extends Command {
    public CommandReconnect() {
        super("reconnect", new String[]{"rc"}, "Reconnect IRC Server", "");
    }

    @Override
    public String execute(String[] args) {
    	IRC.sendMessage("CLOSE");
    	 new Thread(() -> {
             try {
                 Thread.sleep(1000L);
             } catch (InterruptedException e3) {
                 e3.printStackTrace();
             }
         	new IRCThread().start();
         }).start();
        return null;
    }
}
