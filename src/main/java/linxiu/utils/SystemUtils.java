package linxiu.utils;

import java.awt.*;

public class SystemUtils {
    public static void addNotification(String title, String text, TrayIcon.MessageType type,Long delay) throws AWTException {
        if (SystemTray.isSupported()) {
            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("icon.png"), title);
            SystemTray.getSystemTray().add(trayIcon);
            trayIcon.displayMessage(title, text, type);
            new Thread(() -> {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                SystemTray.getSystemTray().remove(trayIcon);

            }).start();
            trayIcon.setImageAutoSize(true);
        }
    }
}
