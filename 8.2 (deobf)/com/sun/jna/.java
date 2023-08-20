package com.sun.jna;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class  extends  {
   public . ;

   public ___/* $FF was: */() {
   }

   public ___/* $FF was: */(Pointer SAO46) {
      super(SAO46);
   }

   public ___/* $FF was: */(Pointer SAO46, int SAO46) {
      super(SAO46, SAO46);
   }

   public ___/* $FF was: */( SAO46) {
      super(SAO46);
   }

   public ___/* $FF was: */(Pointer SAO46, int SAO46,  SAO46) {
      super(SAO46, SAO46, SAO46);
   }

   public List _/* $FF was: */() {
      List SAO46 = SAO46.();
      List SAO46 = new ArrayList(SAO46.size());

      for(Field SAO46 : SAO46) {
         SAO46.add(SAO46.getName());
      }

      return SAO46;
   }

   public void __/* $FF was: */(Class SAO46) {
      SAO46.();

      for(. SAO46 : SAO46.().values()) {
         if (SAO46. == SAO46) {
            SAO46. = SAO46;
            return;
         }
      }

      throw new IllegalArgumentException("No field of type " + SAO46 + " in " + SAO46);
   }

   public void __/* $FF was: */(String SAO46) {
      SAO46.();
      . SAO46 = (.)SAO46.().get(SAO46);
      if (SAO46 != null) {
         SAO46. = SAO46;
      } else {
         throw new IllegalArgumentException("No field named " + SAO46 + " in " + SAO46);
      }
   }

   public Object _/* $FF was: */(String SAO46) {
      SAO46.();
      SAO46.(SAO46);
      return super.(SAO46);
   }

   public void _/* $FF was: */(String SAO46) {
      SAO46.();
      SAO46.(SAO46);
      super.(SAO46);
   }

   public void _/* $FF was: */(String SAO46, Object SAO46) {
      SAO46.();
      SAO46.(SAO46);
      super.(SAO46, SAO46);
   }

   public Object _/* $FF was: */(Class SAO46) {
      SAO46.();

      for(. SAO46 : SAO46.().values()) {
         if (SAO46. == SAO46) {
            SAO46. = SAO46;
            SAO46.read();
            return SAO46.(SAO46..);
         }
      }

      throw new IllegalArgumentException("No field of type " + SAO46 + " in " + SAO46);
   }

   public Object _/* $FF was: */(Object SAO46) {
      . SAO46 = SAO46.(SAO46.getClass());
      if (SAO46 != null) {
         SAO46. = SAO46;
         SAO46.(SAO46., SAO46);
         return SAO46;
      } else {
         throw new IllegalArgumentException("No field of type " + SAO46.getClass() + " in " + SAO46);
      }
   }

   public . _/* $FF was: */(Class SAO46) {
      SAO46.();

      for(. SAO46 : SAO46.().values()) {
         if (SAO46..isAssignableFrom(SAO46)) {
            return SAO46;
         }
      }

      return null;
   }

   public void _/* $FF was: */(. SAO46) {
      if (SAO46 == SAO46.) {
         super.(SAO46);
      }

   }

   public Object _/* $FF was: */(. SAO46) {
      return SAO46 != SAO46. && (.class.isAssignableFrom(SAO46.) || String.class.isAssignableFrom(SAO46.) || .class.isAssignableFrom(SAO46.)) ? null : super.(SAO46);
   }

   public int _/* $FF was: */(Class SAO46, Object SAO46, boolean SAO46) {
      return super.(SAO46, SAO46, true);
   }
}
