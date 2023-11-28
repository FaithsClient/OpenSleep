package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.util.IChatComponent;

public class ChatReceivedEvent extends Event {
   private String c97863;
   private IChatComponent c98463;

   public ChatReceivedEvent(String var1, IChatComponent var2) {
      this.c97863 = var1;
      this.c98463 = var2;
   }

   public IChatComponent c70851() {
      return this.c98463;
   }

   public String c49307() {
      return this.c97863;
   }

   public void c78494(String var1) {
      this.c97863 = var1;
   }

   public void c11068(IChatComponent var1) {
      this.c98463 = var1;
   }
}
