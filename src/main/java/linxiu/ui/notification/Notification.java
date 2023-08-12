package linxiu.ui.notification;

import linxiu.utils.render.TranslateUtil;
import linxiu.utils.timer.TimerUtil;

public class Notification {

    //信息
    private final String message;

    private final NotificationType type;

    //动画控制
    private final TranslateUtil scissor = new TranslateUtil(0, 0);

    //出入控制
    private final TimerUtil removeTimer = new TimerUtil();
    private final TimerUtil animationTimer = new TimerUtil();

    //时间控制
    private final long time;

    public boolean shouldRemove = false;

    public Notification(String message) {
        this.message = message;
        removeTimer.reset();
        animationTimer.reset();
        time = 1000;

        type = NotificationType.INFO;
    }

    public Notification(String message, NotificationType type) {
        this.message = message;
        removeTimer.reset();
        animationTimer.reset();
        time = 1000;
        this.type = type;
    }

    public Notification(String message, long time) {
        this.message = message;
        removeTimer.reset();
        animationTimer.reset();
        this.time = time;

        type = NotificationType.INFO;
    }

    public Notification(String message, long time, NotificationType type) {
        this.message = message;
        removeTimer.reset();
        animationTimer.reset();
        this.time = time;
        this.type = type;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public TranslateUtil getScissor() {
        return scissor;
    }

    public TimerUtil getAnimationTimer() {
        return animationTimer;
    }

    public TimerUtil getRemoveTimer() {
        return removeTimer;
    }

    public long getTime() {
        return time;
    }
}