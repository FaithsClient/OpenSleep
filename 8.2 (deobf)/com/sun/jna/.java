package com.sun.jna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public interface  {
   String  = "type-mapper";
   String  = "function-mapper";
   String  = "invocation-mapper";
   String  = "structure-alignment";
   String  = "string-encoding";
   String  = "allow-objects";
   String  = "calling-convention";
   String  = "open-flags";
   String  = "classloader";

   public static class  implements InvocationHandler {
      public static Method ;
      public static Method ;
      public static Method ;
      public  ;
      public Class ;
      public Map options;
      public  ;
      public Map  = new WeakHashMap();

      public _/* $FF was: */(String SAO46, Class SAO46, Map SAO46) {
         if (SAO46 != null && "".equals(SAO46.trim())) {
            throw new IllegalArgumentException("Invalid library name \"" + SAO46 + "\"");
         } else if (!SAO46.isInterface()) {
            throw new IllegalArgumentException(SAO46 + " does not implement an interface: " + SAO46.getName());
         } else {
            SAO46. = SAO46;
            SAO46.options = new HashMap(SAO46);
            int SAO46 = .class.isAssignableFrom(SAO46) ? 63 : 0;
            if (SAO46.options.get("calling-convention") == null) {
               SAO46.options.put("calling-convention", Integer.valueOf(SAO46));
            }

            if (SAO46.options.get("classloader") == null) {
               SAO46.options.put("classloader", SAO46.getClassLoader());
            }

            SAO46. = .(SAO46, SAO46.options);
            SAO46. = ()SAO46.options.get("invocation-mapper");
         }
      }

      public  _/* $FF was: */() {
         return SAO46.;
      }

      public String _/* $FF was: */() {
         return SAO46..getName();
      }

      public Class __/* $FF was: */() {
         return SAO46.;
      }

      public Object invoke(Object SAO46, Method SAO46, Object[] SAO46) throws Throwable {
         if (.equals(SAO46)) {
            return "Proxy interface to " + SAO46.;
         } else if (.equals(SAO46)) {
            return SAO46.hashCode();
         } else if (.equals(SAO46)) {
            Object SAO46 = SAO46[0];
            return SAO46 != null && Proxy.isProxyClass(SAO46.getClass()) ? Function.(Proxy.getInvocationHandler(SAO46) == SAO46) : Boolean.FALSE;
         } else {
            .. SAO46 = (..)SAO46..get(SAO46);
            if (SAO46 == null) {
               synchronized(SAO46.) {
                  SAO46 = (..)SAO46..get(SAO46);
                  if (SAO46 == null) {
                     boolean SAO46 = Function.(SAO46);
                     InvocationHandler SAO46 = null;
                     if (SAO46. != null) {
                        SAO46 = SAO46..(SAO46., SAO46);
                     }

                     Function SAO46 = null;
                     Class[] SAO46 = null;
                     Map SAO46 = null;
                     if (SAO46 == null) {
                        SAO46 = SAO46..(SAO46.getName(), SAO46);
                        SAO46 = SAO46.getParameterTypes();
                        SAO46 = new HashMap(SAO46.options);
                        SAO46.put("invoking-method", SAO46);
                     }

                     SAO46 = new ..(SAO46, SAO46, SAO46, SAO46, SAO46);
                     SAO46..put(SAO46, SAO46);
                  }
               }
            }

            if (SAO46.) {
               SAO46 = Function.(SAO46);
            }

            return SAO46. != null ? SAO46..invoke(SAO46, SAO46, SAO46) : SAO46..(SAO46, SAO46., SAO46.getReturnType(), SAO46, SAO46.options);
         }
      }

      static {
         try {
             = Object.class.getMethod("toString");
             = Object.class.getMethod("hashCode");
             = Object.class.getMethod("equals", Object.class);
         } catch (Exception var1) {
            throw new Error("Error retrieving Object.toString() method");
         }
      }

      private static final class  {
         public InvocationHandler ;
         public Function ;
         public boolean ;
         public Map options;
         public Class[] ;

         public _/* $FF was: */(InvocationHandler SAO46, Function SAO46, Class[] SAO46, boolean SAO46, Map SAO46) {
            SAO46. = SAO46;
            SAO46. = SAO46;
            SAO46. = SAO46;
            SAO46.options = SAO46;
            SAO46. = SAO46;
         }
      }
   }
}
