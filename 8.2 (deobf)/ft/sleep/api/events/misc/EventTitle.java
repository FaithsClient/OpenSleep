package ft.sleep.api.events.misc;

import ft.sleep.api.Event;

public class EventTitle extends Event {
   private final String message;

   public EventTitle(String message) {
      this.message = message;
   }

   public String getMessage() {
      return this.message;
   }
}
