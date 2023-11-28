package rip.sleep.wrapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.IEventListener;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

public class EventBusWrapper {
   public static final EventBusWrapper c96604 = new EventBusWrapper(MinecraftForge.EVENT_BUS);
   final EventBus c84869;
   final int c19675;
   private ConcurrentHashMap<Object, ArrayList<IEventListener>> c61817;

   private EventBusWrapper(EventBus var1) {
      this.c84869 = var1;
      Class var2 = var1.getClass();
      Class var10000 = var2;
      String var10001 = "listeners";

      try {
         Field var3 = var10000.getDeclaredField(var10001);
         var3.setAccessible(true);
         this.c61817 = (ConcurrentHashMap)var3.get(var1);
         Field var4 = var2.getDeclaredField("busID");
         var4.setAccessible(true);
         this.c19675 = var4.getInt(var1);
      } catch (Throwable var5) {
         throw new RuntimeException(var5);
      }
   }

   public void c35372(Object param1) {
      // $FF: Couldn't be decompiled
   }

   private void c71772(Class<?> var1, Object var2, Method var3) {
      Module[] var4 = Value.c27574();
      Class var10000 = var1;
      byte var10001 = 0;

      try {
         Constructor var5 = var10000.getConstructor();
         var5.setAccessible(true);
         Event var6 = (Event)var5.newInstance();
         EventWrapper var7 = new EventWrapper(var2, var3);
         var6.getListenerList().register(this.c19675, ((SubscribeEvent)var3.getAnnotation(SubscribeEvent.class)).priority(), var7);
         ArrayList var8 = (ArrayList)this.c61817.get(var2);
         if (var8 == null) {
            var8 = new ArrayList();
            this.c61817.put(var2, var8);
         }

         var8.add(var7);
      } catch (Throwable var9) {
         var9.printStackTrace();
      }

   }

   public int hashCode() {
      return this.c84869.hashCode();
   }

   public boolean equals(Object var1) {
      return this.c84869.equals(var1);
   }

   public void c7287(Object var1) {
      this.c84869.unregister(var1);
   }

   public boolean c96904(Event var1) {
      return this.c84869.post(var1);
   }

   public void c61116(EventBus var1, Event var2, IEventListener[] var3, int var4, Throwable var5) {
      this.c84869.handleException(var1, var2, var3, var4, var5);
   }

   public String toString() {
      return this.c84869.toString();
   }

   private static Throwable c41960(Throwable var0) {
      return var0;
   }
}
