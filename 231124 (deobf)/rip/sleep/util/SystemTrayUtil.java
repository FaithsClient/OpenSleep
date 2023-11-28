package rip.sleep.util;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class SystemTrayUtil {
   public static void c85430(String var0, String var1, MessageType var2, Long var3) throws AWTException {
      if (SystemTray.isSupported()) {
         TrayIcon var4 = new TrayIcon(Toolkit.getDefaultToolkit().createImage("icon.png"), var0);
         SystemTray.getSystemTray().add(var4);
         var4.displayMessage(var0, var1, var2);
         (new Thread(() -> {
            Long var10000 = var3;

            try {
               Thread.sleep(var10000.longValue());
            } catch (InterruptedException var3x) {
               throw new RuntimeException(var3x);
            }

            SystemTray.getSystemTray().remove(var4);
         })).start();
         var4.setImageAutoSize(true);
      }

   }
}
