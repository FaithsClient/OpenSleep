//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.api;

import ft.sleep.api.events.world.EventPostUpdate;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventTick;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
   private final ConcurrentHashMap registry = new ConcurrentHashMap();
   private final Comparator comparator = (h, h1) -> {
      return Byte.compare(h.priority, h1.priority);
   };
   private final Lookup lookup = MethodHandles.lookup();
   private static final EventBus instance = new EventBus();

   public static EventBus getInstance() {
      return instance;
   }

   public void register(Object... objs) {
      for(Object obj : objs) {
         for(Method m : obj.getClass().getDeclaredMethods()) {
            if (m.getParameterCount() == 1 && m.isAnnotationPresent(EventHandler.class)) {
               Class eventClass = m.getParameterTypes()[0];
               if (!this.registry.containsKey(eventClass)) {
                  this.registry.put(eventClass, new CopyOnWriteArrayList());
               }

               ((List)this.registry.get(eventClass)).add(new EventBus.Handler(m, obj, ((EventHandler)m.getDeclaredAnnotation(EventHandler.class)).priority()));
               ((List)this.registry.get(eventClass)).sort(this.comparator);
            }
         }
      }

   }

   public void unregister(Object... objs) {
      for(Object obj : objs) {
         for(List list : this.registry.values()) {
            for(EventBus.Handler data : list) {
               if (data.parent == obj) {
                  list.remove(data);
               }
            }
         }
      }

   }

   public Event call(Event event) {
      boolean whiteListedEvents = event instanceof EventTick || event instanceof EventPreUpdate || event instanceof EventPostUpdate;
      List list = (List)this.registry.get(event.getClass());
      if (list != null && !list.isEmpty()) {
         for(EventBus.Handler data : list) {
            try {
               if (list instanceof ) {
                  if ((()list).�?()) {
                     if (whiteListedEvents) {
                        �?.mc.mcProfiler.startSection((()list).getName());
                     }

                     if (whiteListedEvents) {
                        �?.mc.mcProfiler.endSection();
                     }
                  }
               } else {
                  if (whiteListedEvents) {
                     �?.mc.mcProfiler.startSection("non module");
                  }

                  if (whiteListedEvents) {
                     �?.mc.mcProfiler.endSection();
                  }
               }

               data.handler.invokeExact(data.parent, event);
            } catch (Throwable var7) {
               var7.printStackTrace();
            }
         }
      }

      return event;
   }

   private class Handler {
      private MethodHandle handler;
      private final Object parent;
      private final byte priority;

      public Handler(Method method, Object parent, byte priority) {
         if (!method.isAccessible()) {
            method.setAccessible(true);
         }

         MethodHandle m = null;

         try {
            m = EventBus.this.lookup.unreflect(method);
         } catch (IllegalAccessException var7) {
            var7.printStackTrace();
         }

         if (m != null) {
            this.handler = m.asType(m.type().changeParameterType(0, Object.class).changeParameterType(1, Event.class));
         }

         this.parent = parent;
         this.priority = priority;
      }
   }
}
