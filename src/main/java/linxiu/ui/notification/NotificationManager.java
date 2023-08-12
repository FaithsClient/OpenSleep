package linxiu.ui.notification;

import linxiu.api.EventBus;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.module.modules.render.HUD;
import linxiu.ui.font.CFontRenderer;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.RenderUtil;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationManager {
	private final CopyOnWriteArrayList<Notification> notifications = new CopyOnWriteArrayList<>();

	public NotificationManager() {
		EventBus.getInstance().register(this);
	}

	@EventHandler
	void onRenderOverlay(EventRender2D event) {
		ScaledResolution sr = event.getSR();
		int yy = 25;
		for (Notification notification : notifications) {
			CFontRenderer font = FontLoaders.kiona17, small = FontLoaders.kiona14;
			String typeR = notification.getType().name().charAt(0) + notification.getType().name().substring(1).toLowerCase();
			int targetWid = Math.max(font.getStringWidth(typeR), small.getStringWidth(notification.getMessage() + 4));

			float x = notification.getScissor().getX();
			float y = notification.getScissor().getY();

			RenderUtil.drawRoundedRect2(sr.getScaledWidth() - x - 15, sr.getScaledHeight() - y - 22, sr.getScaledWidth() - 5, sr.getScaledHeight() - y, 3.0, new Color(7, 7, 7, 140).getRGB());

			small.drawString(notification.getMessage(), sr.getScaledWidth() - x - 12, sr.getScaledHeight() - y - 9, -1);
			font.drawString(typeR, sr.getScaledWidth() - x - 12, sr.getScaledHeight() - y - 19, new Color(HUD.colorValue.getValue()).getRGB());
			FontLoaders.logo18.drawString("g", sr.getScaledWidth() - 15, sr.getScaledHeight() - y - 18, new Color(HUD.colorValue.getValue()).getRGB());

			if (notification.shouldRemove) {
				notification.getScissor().interpolate(targetWid, -20, .15F);
			} else if (notification.getAnimationTimer().hasTimeElapsed(notification.getTime())) {
				notification.getScissor().interpolate(targetWid, yy, .15F);
				yy += 30;
			} else {
				notification.getScissor().interpolate(targetWid, yy, .15F);
				yy += 35;
			}

			if (notification.getRemoveTimer().hasTimeElapsed(notification.getTime() + 500)) {
				notification.shouldRemove = true;
			}

			if (notification.getScissor().getY() < -19) {
				notifications.remove(notification);
			}
		}
	}

	public CopyOnWriteArrayList<Notification> getNotifications() {
		return notifications;
	}
}