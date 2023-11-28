package rip.sleep.event;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import rip.sleep.module.Module;

public class EventBus {
   private final ConcurrentHashMap<Class<? extends Event>, List<EventBus.Handler>> registry = new ConcurrentHashMap();
   private final Comparator<EventBus.Handler> comparator = (var0, var1) -> {
      return Byte.compare(var0.priority, var1.priority);
   };
   private final Lookup lookup = MethodHandles.lookup();
   private static final EventBus instance = new EventBus();

   public static EventBus getInstance() {
      return instance;
   }

   public void register(Object... var1) {
      Event.v();
      int var4 = var1.length;
      int var5 = 0;
      if (var5 < var4) {
         Object var6 = var1[var5];
         Method[] var7 = var6.getClass().getDeclaredMethods();
         int var8 = var7.length;
         int var9 = 0;
         if (var9 < var8) {
            Method var10 = var7[var9];
            if (var10.getParameterCount() == 1 && var10.isAnnotationPresent(EventTarget.class)) {
               Class var11 = var10.getParameterTypes()[0];
               if (!this.registry.containsKey(var11)) {
                  this.registry.put(var11, new CopyOnWriteArrayList());
               }

               ((List)this.registry.get(var11)).add(new EventBus.Handler(var10, var6, ((EventTarget)var10.getDeclaredAnnotation(EventTarget.class)).c97602()));
               ((List)this.registry.get(var11)).sort(this.comparator);
            }

            ++var9;
         }

         ++var5;
      }

   }

   public void unregister(Object... var1) {
      Event.v();
      int var4 = var1.length;
      int var5 = 0;
      if (var5 < var4) {
         Object var6 = var1[var5];
         Iterator var7 = this.registry.values().iterator();
         if (var7.hasNext()) {
            List var8 = (List)var7.next();
            Iterator var9 = var8.iterator();
            if (var9.hasNext()) {
               EventBus.Handler var10 = (EventBus.Handler)var9.next();
               if (var10.parent != var6) {
                  ;
               }

               var8.remove(var10);
            }
         }

         ++var5;
      }

   }

   public <E extends Event> E call(E param1) {
      // $FF: Couldn't be decompiled
   }

   private static Throwable a(Throwable var0) {
      return var0;
   }

   private class Handler {
      private MethodHandle handler;
      private final Object parent;
      private final byte priority;

      public Handler(Method var2, Object var3, byte var4) {
         Event.v();
         super();
         if (!var2.isAccessible()) {
            var2.setAccessible(true);
         }

         MethodHandle var6 = null;
         EventBus var10000 = EventBus.this;

         try {
            var6 = var10000.lookup.unreflect(var2);
         } catch (IllegalAccessException var8) {
            var8.printStackTrace();
         }

         this.handler = var6.asType(var6.type().changeParameterType(0, Object.class).changeParameterType(1, Event.class));
         this.parent = var3;
         this.priority = var4;
         if (Module.c12876() == null) {
            Event.b(new Module[2]);
         }

      }

      // $FF: synthetic method
      static MethodHandle access$100(EventBus.Handler var0) {
         return var0.handler;
      }

      private static IllegalAccessException a(IllegalAccessException var0) {
         return var0;
      }
   }
}
