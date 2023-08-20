package com.sun.jna;

public abstract class  implements  {
   public Pointer ;

   public ___/* $FF was: */() {
      SAO46. = Pointer.;
   }

   public ___/* $FF was: */(Pointer SAO46) {
      SAO46. = SAO46;
   }

   public Class _/* $FF was: */() {
      return Pointer.class;
   }

   public Object _/* $FF was: */() {
      return SAO46.();
   }

   public Pointer _/* $FF was: */() {
      return SAO46.;
   }

   public void setPointer(Pointer SAO46) {
      SAO46. = SAO46;
   }

   public Object fromNative(Object SAO46,  SAO46) {
      if (SAO46 == null) {
         return null;
      } else {
         try {
             SAO46 = ()SAO46.getClass().newInstance();
            SAO46. = (Pointer)SAO46;
            return SAO46;
         } catch (InstantiationException var4) {
            throw new IllegalArgumentException("Can't instantiate " + SAO46.getClass());
         } catch (IllegalAccessException var5) {
            throw new IllegalArgumentException("Not allowed to instantiate " + SAO46.getClass());
         }
      }
   }

   public int hashCode() {
      return SAO46. != null ? SAO46..hashCode() : 0;
   }

   public boolean equals(Object SAO46) {
      if (SAO46 == SAO46) {
         return true;
      } else if (SAO46 instanceof ) {
         Pointer SAO46 = (()SAO46).();
         if (SAO46. == null) {
            return SAO46 == null;
         } else {
            return SAO46..equals(SAO46);
         }
      } else {
         return false;
      }
   }

   public String toString() {
      return SAO46. == null ? "NULL" : SAO46..toString() + " (" + super.toString() + ")";
   }
}
