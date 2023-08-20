package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.util.IChatComponent;

public class ChatEvent extends Event {
   private String message;
   private IChatComponent ChatComponent;

   public ChatEvent(String message, IChatComponent ChatComponent) {
      this.message = message;
      this.ChatComponent = ChatComponent;
   }

   public IChatComponent getChatComponent() {
      return this.ChatComponent;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public void setChatComponent(IChatComponent ChatComponent) {
      this.ChatComponent = ChatComponent;
   }
}
