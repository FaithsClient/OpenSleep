package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

public class  implements  {
   public static Map  = new WeakHashMap();
   public Class ;
   public Class ;
   public  ;

   public static  _/* $FF was: */(Class SAO46) {
      synchronized() {
         Reference SAO46 = (Reference).get(SAO46);
          SAO46 = SAO46 != null ? ()SAO46.get() : null;
         if (SAO46 == null) {
            SAO46 = new (SAO46);
            .put(SAO46, new SoftReference(SAO46));
         }

         return SAO46;
      }
   }

   public ___/* $FF was: */(Class SAO46) {
      if (!.class.isAssignableFrom(SAO46)) {
         throw new IllegalArgumentException("Type must derive from " + .class);
      } else {
         SAO46. = SAO46;
         SAO46. = SAO46.();
         SAO46. = SAO46..();
      }
   }

   public  _/* $FF was: */() {
      try {
         return ()SAO46..newInstance();
      } catch (InstantiationException var3) {
         String SAO46 = "Can't create an instance of " + SAO46. + ", requires a no-arg constructor: " + var3;
         throw new IllegalArgumentException(SAO46);
      } catch (IllegalAccessException var4) {
         String SAO46 = "Not allowed to create an instance of " + SAO46. + ", requires a public, no-arg constructor: " + var4;
         throw new IllegalArgumentException(SAO46);
      }
   }

   public Object fromNative(Object SAO46,  SAO46) {
      return SAO46..fromNative(SAO46, SAO46);
   }

   public Class _/* $FF was: */() {
      return SAO46.;
   }

   public Object _/* $FF was: */(Object SAO46,  SAO46) {
      if (SAO46 == null) {
         if (Pointer.class.isAssignableFrom(SAO46.)) {
            return null;
         }

         SAO46 = SAO46.();
      }

      return (()SAO46).();
   }
}
