package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class  extends WeakReference {
   public static Map  = new WeakHashMap();
   public static Map  = new WeakHashMap();
   public static Map  = new WeakHashMap();
   public static Map  = new WeakHashMap();
   public static Map  = Collections.synchronizedMap(new WeakHashMap());
   public static Method ;
   public static Map ;
   public Pointer ;
   public Pointer ;
   public  ;
   public Method ;
   public int ;

   public static  _/* $FF was: */(Callback SAO46,  SAO46) {
      synchronized() {
         return SAO46 != null ? ().put(SAO46, SAO46) : ().remove(SAO46);
      }
   }

   public static ThreadGroup _/* $FF was: */(Callback SAO46, . SAO46) {
       SAO46 = null;
      if (SAO46 instanceof .) {
         SAO46 = ((.)SAO46).();
      }

      synchronized() {
         SAO46 = ().get(SAO46);
      }

      ThreadGroup SAO46 = null;
      if (SAO46 != null) {
         SAO46 = SAO46.(SAO46);
         SAO46.name = SAO46.(SAO46);
         SAO46. = SAO46.(SAO46);
         SAO46. = SAO46.(SAO46);
         SAO46.write();
      }

      return SAO46;
   }

   public static Callback _/* $FF was: */(Class SAO46, Pointer SAO46) {
      return (SAO46, SAO46, false);
   }

   public static Callback _/* $FF was: */(Class SAO46, Pointer SAO46, boolean SAO46) {
      if (SAO46 == null) {
         return null;
      } else if (!SAO46.isInterface()) {
         throw new IllegalArgumentException("Callback type must be an interface");
      } else {
         Map SAO46 = SAO46 ?  : ;
         synchronized() {
            Callback SAO46 = null;
            Reference SAO46 = (Reference).get(SAO46);
            if (SAO46 != null) {
               SAO46 = (Callback)SAO46.get();
               if (SAO46 != null && !SAO46.isAssignableFrom(SAO46.getClass())) {
                  throw new IllegalStateException("Pointer " + SAO46 + " already mapped to " + SAO46 + ".\nNative code may be re-using a default function pointer, in which case you may need to use a common Callback class wherever the function pointer is reused.");
               } else {
                  return SAO46;
               }
            } else {
               int SAO46 = .class.isAssignableFrom(SAO46) ? 63 : 0;
               Map SAO46 = new HashMap(Native.(SAO46));
               SAO46.put("invoking-method", (SAO46));
               . SAO46 = new .(SAO46, SAO46, SAO46);
               SAO46 = (Callback)Proxy.newProxyInstance(SAO46.getClassLoader(), new Class[]{SAO46}, SAO46);
               SAO46.remove(SAO46);
               .put(SAO46, new WeakReference(SAO46));
               return SAO46;
            }
         }
      }
   }

   public __/* $FF was: */(Callback SAO46, int SAO46, boolean SAO46) {
      super(SAO46);
       SAO46 = Native.(SAO46.getClass());
      SAO46. = SAO46;
      boolean SAO46 = .();
      if (SAO46) {
         Method SAO46 = (SAO46);
         Class[] SAO46 = SAO46.getParameterTypes();

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46 && (SAO46[SAO46] == Float.TYPE || SAO46[SAO46] == Double.TYPE)) {
               SAO46 = false;
               break;
            }

            if (SAO46 != null && SAO46.(SAO46[SAO46]) != null) {
               SAO46 = false;
               break;
            }
         }

         if (SAO46 != null && SAO46.(SAO46.getReturnType()) != null) {
            SAO46 = false;
         }
      }

      String SAO46 = Native.(SAO46.getClass());
      long SAO46 = (long)481361665 ^ 481361665L;
      if (SAO46) {
         SAO46. = (SAO46);
         Class[] SAO46 = SAO46..getParameterTypes();
         Class SAO46 = SAO46..getReturnType();
         int SAO46 = 1;
         if (SAO46 instanceof ) {
            SAO46 |= 2;
         }

         SAO46 = Native.createNativeCallback(SAO46, SAO46., SAO46, SAO46, SAO46, SAO46, SAO46);
      } else {
         if (SAO46 instanceof ) {
            SAO46. = ()SAO46;
         } else {
            SAO46. = new .((SAO46), SAO46, SAO46);
         }

         Class[] SAO46 = SAO46..();
         Class SAO46 = SAO46..();
         if (SAO46 != null) {
            for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
               FromNativeConverter SAO46 = SAO46.(SAO46[SAO46]);
               if (SAO46 != null) {
                  SAO46[SAO46] = SAO46.();
               }
            }

            ToNativeConverter SAO46 = SAO46.(SAO46);
            if (SAO46 != null) {
               SAO46 = SAO46.();
            }
         }

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            SAO46[SAO46] = SAO46.(SAO46[SAO46]);
            if (!(SAO46[SAO46])) {
               String SAO46 = "Callback argument " + SAO46[SAO46] + " requires custom type conversion";
               throw new IllegalArgumentException(SAO46);
            }
         }

         SAO46 = SAO46.(SAO46);
         if (!(SAO46)) {
            String SAO46 = "Callback return type " + SAO46 + " requires custom type conversion";
            throw new IllegalArgumentException(SAO46);
         }

         int SAO46 = SAO46 instanceof  ? 2 : 0;
         SAO46 = Native.createNativeCallback(SAO46., , SAO46, SAO46, SAO46, SAO46, SAO46);
      }

      SAO46. = SAO46 != ((long)2088191106 ^ 2088191106L) ? new Pointer(SAO46) : null;
      .put(SAO46, new WeakReference(SAO46));
   }

   public Class _/* $FF was: */(Class SAO46) {
      if (.class.isAssignableFrom(SAO46)) {
         .(SAO46);
         if (!..class.isAssignableFrom(SAO46)) {
            return Pointer.class;
         }
      } else {
         if (.class.isAssignableFrom(SAO46)) {
            return .(SAO46).();
         }

         if (SAO46 == String.class || SAO46 == .class || SAO46 == String[].class || SAO46 == [].class || Callback.class.isAssignableFrom(SAO46)) {
            return Pointer.class;
         }
      }

      return SAO46;
   }

   public static Method _/* $FF was: */(Method SAO46) {
      if (SAO46.getParameterTypes().length > 256) {
         String SAO46 = "Method signature exceeds the maximum parameter count: " + SAO46;
         throw new UnsupportedOperationException(SAO46);
      } else {
         return SAO46;
      }
   }

   public static Class _/* $FF was: */(Class SAO46) {
      if (!Callback.class.isAssignableFrom(SAO46)) {
         throw new IllegalArgumentException(SAO46.getName() + " is not derived from com.sun.jna.Callback");
      } else if (SAO46.isInterface()) {
         return SAO46;
      } else {
         Class[] SAO46 = SAO46.getInterfaces();
         int SAO46 = 0;

         while(true) {
            if (SAO46 < SAO46.length) {
               if (!Callback.class.isAssignableFrom(SAO46[SAO46])) {
                  ++SAO46;
                  continue;
               }

               try {
                  (SAO46[SAO46]);
                  return SAO46[SAO46];
               } catch (IllegalArgumentException var4) {
                  ;
               }
            }

            if (Callback.class.isAssignableFrom(SAO46.getSuperclass())) {
               return (SAO46.getSuperclass());
            }

            return SAO46;
         }
      }
   }

   public static Method _/* $FF was: */(Callback SAO46) {
      return ((SAO46.getClass()));
   }

   public static Method _/* $FF was: */(Class SAO46) {
      Method[] SAO46 = SAO46.getDeclaredMethods();
      Method[] SAO46 = SAO46.getMethods();
      Set SAO46 = new HashSet(Arrays.asList(SAO46));
      SAO46.retainAll(Arrays.asList(SAO46));
      Iterator SAO46 = SAO46.iterator();

      while(SAO46.hasNext()) {
         Method SAO46 = (Method)SAO46.next();
         if (Callback..contains(SAO46.getName())) {
            SAO46.remove();
         }
      }

      Method[] SAO46 = (Method[])SAO46.toArray(new Method[SAO46.size()]);
      if (SAO46.length == 1) {
         return (SAO46[0]);
      } else {
         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            Method SAO46 = SAO46[SAO46];
            if ("callback".equals(SAO46.getName())) {
               return (SAO46);
            }
         }

         String SAO46 = "Callback must implement a single public method, or one public method named 'callback'";
         throw new IllegalArgumentException(SAO46);
      }
   }

   public void _/* $FF was: */(int SAO46) {
      SAO46..((long)Pointer., SAO46);
   }

   public Pointer _/* $FF was: */() {
      if (SAO46. == null) {
         SAO46. = SAO46..((long)50091899 ^ 50091899L);
      }

      return SAO46.;
   }

   public void finalize() {
      SAO46.dispose();
   }

   public synchronized void dispose() {
      if (SAO46. != null) {
         boolean var3 = false;

         try {
            var3 = true;
            Native.freeNativeCallback(SAO46..);
            var3 = false;
         } finally {
            if (var3) {
               SAO46.. = (long)26221440 ^ 26221440L;
               SAO46. = null;
               .remove(SAO46);
            }
         }

         SAO46.. = (long)314311944 ^ 314311944L;
         SAO46. = null;
         .remove(SAO46);
      }

   }

   public static void _/* $FF was: */() {
      for( SAO46 : new LinkedList(.keySet())) {
         SAO46.dispose();
      }

   }

   public Callback _/* $FF was: */() {
      return (Callback)SAO46.get();
   }

   public static Pointer _/* $FF was: */(Callback SAO46) {
      if (Proxy.isProxyClass(SAO46.getClass())) {
         Object SAO46 = Proxy.getInvocationHandler(SAO46);
         if (SAO46 instanceof .) {
            return ((.)SAO46).();
         }
      }

      return null;
   }

   public static Pointer _/* $FF was: */(Callback SAO46) {
      return (SAO46, false);
   }

   public static Pointer _/* $FF was: */(Callback SAO46, boolean SAO46) {
      Pointer SAO46 = null;
      if (SAO46 == null) {
         return null;
      } else if ((SAO46 = (SAO46)) != null) {
         return SAO46;
      } else {
         Map SAO46 = Native.(SAO46.getClass());
         int SAO46 = SAO46 instanceof  ? 63 : (SAO46 != null && SAO46.containsKey("calling-convention") ? ((Integer)SAO46.get("calling-convention")).intValue() : 0);
         Map SAO46 = SAO46 ?  : ;
         synchronized() {
             SAO46 = ()SAO46.get(SAO46);
            if (SAO46 == null) {
               SAO46 = new (SAO46, SAO46, SAO46);
               SAO46.put(SAO46, SAO46);
               .put(SAO46.(), new WeakReference(SAO46));
               if (.containsKey(SAO46)) {
                  SAO46.(1);
               }
            }

            return SAO46.();
         }
      }
   }

   public static boolean _/* $FF was: */(Class SAO46) {
      return SAO46 == Void.TYPE || SAO46 == Void.class || SAO46 == Boolean.TYPE || SAO46 == Boolean.class || SAO46 == Byte.TYPE || SAO46 == Byte.class || SAO46 == Short.TYPE || SAO46 == Short.class || SAO46 == Character.TYPE || SAO46 == Character.class || SAO46 == Integer.TYPE || SAO46 == Integer.class || SAO46 == Long.TYPE || SAO46 == Long.class || SAO46 == Float.TYPE || SAO46 == Float.class || SAO46 == Double.TYPE || SAO46 == Double.class || ..class.isAssignableFrom(SAO46) && .class.isAssignableFrom(SAO46) || Pointer.class.isAssignableFrom(SAO46);
   }

   public static Pointer _/* $FF was: */(Object SAO46, boolean SAO46) {
      if (SAO46 != null) {
          SAO46 = new (SAO46.toString(), SAO46);
         .put(SAO46, SAO46);
         return SAO46.();
      } else {
         return null;
      }
   }

   public static Callback _/* $FF was: */( SAO46) {
      return SAO46.();
   }

   public static Pointer _/* $FF was: */(Object SAO46, boolean SAO46) {
      return (SAO46, SAO46);
   }

   static {
      try {
          = .class.getMethod("\ue814", Object[].class);
      } catch (Exception var1) {
         throw new Error("Error looking up CallbackProxy.callback() method");
      }

       = new WeakHashMap();
   }

   private class  implements  {
      public Method ;
      public ToNativeConverter ;
      public FromNativeConverter[] ;
      public String ;
      public  ;

      public _/* $FF was: */(Method SAO46xxx,  SAO46xxxx, String SAO46xxxxx) {
         SAO46. = .this;
         super();
         SAO46. = SAO46;
         SAO46. = SAO46;
         Class[] SAO46 = SAO46.getParameterTypes();
         Class SAO46 = SAO46.getReturnType();
         SAO46. = new FromNativeConverter[SAO46.length];
         if (.class.isAssignableFrom(SAO46)) {
            SAO46. = .(SAO46);
         } else if (SAO46 != null) {
            SAO46. = SAO46.(SAO46);
         }

         for(int SAO46 = 0; SAO46 < SAO46..length; ++SAO46) {
            if (.class.isAssignableFrom(SAO46[SAO46])) {
               SAO46.[SAO46] = new (SAO46[SAO46]);
            } else if (SAO46 != null) {
               SAO46.[SAO46] = SAO46.(SAO46[SAO46]);
            }
         }

         if (!SAO46.isAccessible()) {
            try {
               SAO46.setAccessible(true);
            } catch (SecurityException var8) {
               throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + SAO46);
            }
         }

      }

      public Callback _/* $FF was: */() {
         return SAO46..();
      }

      public Object _/* $FF was: */(Object[] SAO46x) {
         Class[] SAO46 = SAO46..getParameterTypes();
         Object[] SAO46 = new Object[SAO46.length];

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            Class SAO46 = SAO46[SAO46];
            Object SAO46 = SAO46[SAO46];
            if (SAO46.[SAO46] != null) {
                SAO46 = new (SAO46, SAO46., SAO46, SAO46);
               SAO46[SAO46] = SAO46.[SAO46].fromNative(SAO46, SAO46);
            } else {
               SAO46[SAO46] = SAO46.(SAO46, SAO46);
            }
         }

         Object SAO46 = null;
         Callback SAO46 = SAO46.();
         if (SAO46 != null) {
            try {
               SAO46 = SAO46.(SAO46..invoke(SAO46, SAO46));
            } catch (IllegalArgumentException var8) {
               Native.().(SAO46, var8);
            } catch (IllegalAccessException var9) {
               Native.().(SAO46, var9);
            } catch (InvocationTargetException var10) {
               Native.().(SAO46, var10.getTargetException());
            }
         }

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46[SAO46] instanceof  && !(SAO46[SAO46] instanceof .)) {
               (()SAO46[SAO46]).();
            }
         }

         return SAO46;
      }

      public Object _/* $FF was: */(Object[] SAO46x) {
         try {
            return SAO46.(SAO46);
         } catch (Throwable var3) {
            Native.().(SAO46.(), var3);
            return null;
         }
      }

      public Object _/* $FF was: */(Object SAO46x, Class SAO46xx) {
         if (SAO46 instanceof Pointer) {
            if (SAO46 == String.class) {
               SAO46 = ((Pointer)SAO46).((long)1668648583 ^ 1668648583L, SAO46.);
            } else if (SAO46 == .class) {
               SAO46 = new (((Pointer)SAO46).((long)-1878362993 ^ -1878362993L));
            } else if (SAO46 == String[].class) {
               SAO46 = ((Pointer)SAO46).((long)-455584271 ^ -455584271L, SAO46.);
            } else if (SAO46 == [].class) {
               SAO46 = ((Pointer)SAO46).((long)-1342290650 ^ -1342290650L);
            } else if (Callback.class.isAssignableFrom(SAO46)) {
               SAO46 = com.sun.jna..(SAO46, (Pointer)SAO46);
            } else if (.class.isAssignableFrom(SAO46)) {
               if (..class.isAssignableFrom(SAO46)) {
                   SAO46 = .(SAO46);
                  byte[] SAO46 = new byte[SAO46.size()];
                  ((Pointer)SAO46).((long)-1409469808 ^ -1409469808L, SAO46, 0, SAO46.length);
                  SAO46.().((long)1975621715 ^ 1975621715L, SAO46, 0, SAO46.length);
                  SAO46.read();
                  SAO46 = SAO46;
               } else {
                   SAO46 = .(SAO46, (Pointer)SAO46);
                  SAO46.();
                  SAO46 = SAO46;
               }
            }
         } else if ((Boolean.TYPE == SAO46 || Boolean.class == SAO46) && SAO46 instanceof Number) {
            SAO46 = Function.(((Number)SAO46).intValue() != 0);
         }

         return SAO46;
      }

      public Object _/* $FF was: */(Object SAO46xx) {
         if (SAO46. != null) {
            SAO46 = SAO46..(SAO46, new (SAO46.));
         }

         if (SAO46 == null) {
            return null;
         } else {
            Class SAO46 = SAO46.getClass();
            if (.class.isAssignableFrom(SAO46)) {
               return ..class.isAssignableFrom(SAO46) ? SAO46 : (()SAO46).();
            } else if (SAO46 != Boolean.TYPE && SAO46 != Boolean.class) {
               if (SAO46 != String.class && SAO46 != .class) {
                  if (SAO46 != String[].class && SAO46 != .class) {
                     return Callback.class.isAssignableFrom(SAO46) ? com.sun.jna..((Callback)SAO46) : SAO46;
                  } else {
                      SAO46 = SAO46 == String[].class ? new ((String[])SAO46, SAO46.) : new (([])SAO46);
                     com.sun.jna...put(SAO46, SAO46);
                     return SAO46;
                  }
               } else {
                  return com.sun.jna..(SAO46, SAO46 == .class);
               }
            } else {
               return Boolean.TRUE.equals(SAO46) ? Function. : Function.;
            }
         }
      }

      public Class[] _/* $FF was: */() {
         return SAO46..getParameterTypes();
      }

      public Class _/* $FF was: */() {
         return SAO46..getReturnType();
      }
   }

   private static class  implements InvocationHandler {
      public Function ;
      public Map options;

      public _/* $FF was: */(Pointer SAO46, int SAO46, Map SAO46) {
         SAO46.options = SAO46;
         SAO46. = new Function(SAO46, SAO46, (String)SAO46.get("string-encoding"));
      }

      public Object invoke(Object SAO46, Method SAO46, Object[] SAO46) throws Throwable {
         if (...equals(SAO46)) {
            String SAO46 = "Proxy interface to " + SAO46.;
            Method SAO46 = (Method)SAO46.options.get("invoking-method");
            Class SAO46 = com.sun.jna..(SAO46.getDeclaringClass());
            SAO46 = SAO46 + " (" + SAO46.getName() + ")";
            return SAO46;
         } else if (...equals(SAO46)) {
            return SAO46.hashCode();
         } else if (...equals(SAO46)) {
            Object SAO46 = SAO46[0];
            return SAO46 != null && Proxy.isProxyClass(SAO46.getClass()) ? Function.(Proxy.getInvocationHandler(SAO46) == SAO46) : Boolean.FALSE;
         } else {
            if (Function.(SAO46)) {
               SAO46 = Function.(SAO46);
            }

            return SAO46..(SAO46.getReturnType(), SAO46, SAO46.options);
         }
      }

      public Pointer _/* $FF was: */() {
         return SAO46.;
      }
   }

   static class  extends  {
      public static List  = (new String[]{"daemon", "detach", "name"});
      public boolean ;
      public boolean ;
      public String name;

      public _/* $FF was: */() {
         SAO46.("utf8");
      }

      public List _/* $FF was: */() {
         return ;
      }
   }
}
