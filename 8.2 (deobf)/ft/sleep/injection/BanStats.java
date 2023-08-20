package ft.sleep.injection;

class BanStats {
   private BanData watchdog;
   private BanData staff;

   public BanData getWatchdog() {
      return this.watchdog;
   }

   public void setWatchdog(BanData watchdog) {
      this.watchdog = watchdog;
   }

   public BanData getStaff() {
      return this.staff;
   }

   public void setStaff(BanData staff) {
      this.staff = staff;
   }
}
