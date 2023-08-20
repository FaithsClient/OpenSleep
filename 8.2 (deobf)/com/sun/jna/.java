package com.sun.jna;

import java.lang.reflect.Method;

public abstract class  {
   public ___/* $FF was: */() {
   }

   public static  _/* $FF was: */() {
      try {
         Method SAO46 = Method.class.getMethod("isVarArgs");
         return ()(SAO46 != null ? new .() : new .());
      } catch (NoSuchMethodException var1) {
         return new .();
      } catch (SecurityException var2) {
         return new .();
      }
   }

   public abstract boolean _/* $FF was: */(Method var1);

   public abstract int _/* $FF was: */(Method var1);

   public ___/* $FF was: */(Object SAO46) {
      this();
   }

   private static final class  extends  {
      public _/* $FF was: */() {
      }

      public boolean _/* $FF was: */(Method SAO46) {
         return SAO46.isVarArgs();
      }

      public int _/* $FF was: */(Method SAO46) {
         return SAO46.isVarArgs() ? SAO46.getParameterTypes().length - 1 : 0;
      }

      public _/* $FF was: */(Object SAO46) {
         this();
      }
   }

   private static final class  extends  {
      public _/* $FF was: */() {
      }

      public boolean _/* $FF was: */(Method SAO46) {
         return false;
      }

      public int _/* $FF was: */(Method SAO46) {
         return 0;
      }

      public _/* $FF was: */(Object SAO46) {
         this();
      }
   }
}
