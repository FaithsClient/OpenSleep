package ft.sleep.util;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class SystemUtils {
   public static void _flags(String udubevus, String apesamov, MessageType sazedume, Long uriremay) throws AWTException {
      if (SystemTray.isSupported()) {
         Object livosoyu = new TrayIcon(Toolkit.getDefaultToolkit().createImage("icon.png"), (String)udubevus);
         SystemTray.getSystemTray().add(livosoyu);
         livosoyu.displayMessage((String)udubevus, (String)apesamov, (MessageType)sazedume);
         (new Thread(SystemUtils::_textbook)).start();
         livosoyu.setImageAutoSize(true);
      }

   }

   public static void _textbook(Long vacuum, TrayIcon thereof) {
      Thread.sleep(((Long)vacuum).longValue());
      SystemTray.getSystemTray().remove((TrayIcon)thereof);
   }
}
