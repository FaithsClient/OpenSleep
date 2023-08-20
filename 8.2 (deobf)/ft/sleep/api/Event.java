package ft.sleep.api;

public abstract class Event {
   public boolean cancelled;
   public byte type;

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCanceled() {
      this.cancelled = true;
   }

   public void cancel() {
      this.cancelled = true;
   }

   public void setCancelled(boolean cancelled) {
      this.cancelled = cancelled;
   }

   public byte getType() {
      return this.type;
   }

   public void setType(byte type) {
      this.type = type;
   }
}
