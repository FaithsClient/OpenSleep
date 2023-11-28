package rip.sleep.wrapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.IEventListener;

public class EventWrapper implements IEventListener {
   final Object c10319;
   final Method c31048;

   public EventWrapper(Object var1, Method var2) {
      this.c10319 = var1;
      this.c31048 = var2;
   }

   public void invoke(Event var1) {
      Method var10000 = this.c31048;
      Object var10001 = this.c10319;
      Object[] var10002 = new Object[1];
      Object[] var10003 = var10002;
      byte var10004 = 0;
      Method var10005 = this.c31048;

      try {
         var10003[var10004] = var10005.getParameterTypes()[0].cast(var1);
         var10000.invoke(var10001, var10002);
      } catch (IllegalArgumentException | IllegalAccessException var3) {
         var3.printStackTrace();
      } catch (InvocationTargetException var4) {
         throw new RuntimeException(var4.getTargetException());
      }

   }
}
