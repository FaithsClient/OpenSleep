package ft.sleep.api.events.misc;

import ft.sleep.api.Event;

public class EventChat extends Event {
   private String message;

   public EventChat(String message) {
      this.message = message;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
