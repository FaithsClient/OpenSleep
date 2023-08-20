package com.sun.jna;

public class  extends RuntimeException {
   public static long serialVersionUID = (long)-592353644 ^ -592353643L;
   public int ;

   public static String _/* $FF was: */(int SAO46) {
      return .() ? "GetLastError() returned " + SAO46 : "errno was " + SAO46;
   }

   public static String _/* $FF was: */(String SAO46) {
      try {
         return (Integer.parseInt(SAO46));
      } catch (NumberFormatException var2) {
         return SAO46;
      }
   }

   public int _/* $FF was: */() {
      return SAO46.;
   }

   public ___/* $FF was: */(String SAO46) {
      super((SAO46.trim()));

      try {
         if (SAO46.startsWith("[")) {
            SAO46 = SAO46.substring(1, SAO46.indexOf("]"));
         }

         SAO46. = Integer.parseInt(SAO46);
      } catch (NumberFormatException var3) {
         SAO46. = -1;
      }

   }

   public ___/* $FF was: */(int SAO46) {
      this(SAO46, (SAO46));
   }

   public ___/* $FF was: */(int SAO46, String SAO46) {
      super(SAO46);
      SAO46. = SAO46;
   }
}
