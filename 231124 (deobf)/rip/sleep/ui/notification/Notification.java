package rip.sleep.ui.notification;

import rip.sleep.ui.notification.NotificationTypeB;
import rip.sleep.util.MathUtilE;
import rip.sleep.util.TimerUtilF;

public class Notification {
   private final String c54975;
   private final NotificationTypeB c7360;
   private final MathUtilE c45128 = new MathUtilE(0.0F, 0.0F);
   private final TimerUtilF c16002 = new TimerUtilF();
   private final TimerUtilF c76697 = new TimerUtilF();
   private final long c12115;
   public boolean c33063 = false;

   public Notification(String var1) {
      this.c54975 = var1;
      this.c16002.c99119();
      this.c76697.c99119();
      this.c12115 = 1000L;
      this.c7360 = NotificationTypeB.INFO;
   }

   public Notification(String var1, NotificationTypeB var2) {
      this.c54975 = var1;
      this.c16002.c99119();
      this.c76697.c99119();
      this.c12115 = 1000L;
      this.c7360 = var2;
   }

   public Notification(String var1, long var2) {
      this.c54975 = var1;
      this.c16002.c99119();
      this.c76697.c99119();
      this.c12115 = var2;
      this.c7360 = NotificationTypeB.INFO;
   }

   public Notification(String var1, long var2, NotificationTypeB var4) {
      this.c54975 = var1;
      this.c16002.c99119();
      this.c76697.c99119();
      this.c12115 = var2;
      this.c7360 = var4;
   }

   public NotificationTypeB c53608() {
      return this.c7360;
   }

   public String c31064() {
      return this.c54975;
   }

   public MathUtilE c92876() {
      return this.c45128;
   }

   public TimerUtilF c17863() {
      return this.c76697;
   }

   public TimerUtilF c67096() {
      return this.c16002;
   }

   public long c21476() {
      return this.c12115;
   }
}
