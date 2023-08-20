package ft.sleep.api.events.misc;

import ft.sleep.api.Event;

public class EventMouse extends Event {
   private final EventMouse.Button button;

   public EventMouse(EventMouse.Button button) {
      this.button = button;
   }

   public EventMouse.Button getButton() {
      return this.button;
   }

   public static enum Button {
      Left,
      Right,
      Middle;
   }
}
