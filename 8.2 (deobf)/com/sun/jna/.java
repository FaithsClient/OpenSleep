package com.sun.jna;

import java.nio.CharBuffer;

public class  implements CharSequence, Comparable {
   public static String  = "--WIDE-STRING--";
   public Pointer ;
   public String ;

   public ___/* $FF was: */(String SAO46) {
      this(SAO46, Native.());
   }

   public ___/* $FF was: */(String SAO46, boolean SAO46) {
      this(SAO46, SAO46 ? "--WIDE-STRING--" : Native.());
   }

   public ___/* $FF was: */( SAO46) {
      this(SAO46.toString(), "--WIDE-STRING--");
   }

   public ___/* $FF was: */(String SAO46, String SAO46) {
      if (SAO46 == null) {
         throw new NullPointerException("String must not be null");
      } else {
         SAO46. = SAO46;
         if ("--WIDE-STRING--".equals(SAO46.)) {
            int SAO46 = (SAO46.length() + 1) * Native.;
            SAO46. = new .((long)SAO46);
            SAO46..((long)806245592 ^ 806245592L, SAO46);
         } else {
            byte[] SAO46 = Native.(SAO46, SAO46);
            SAO46. = new .((long)(SAO46.length + 1));
            SAO46..((long)1695609640 ^ 1695609640L, SAO46, 0, SAO46.length);
            SAO46..((long)SAO46.length, (byte)0);
         }

      }
   }

   public int hashCode() {
      return SAO46.toString().hashCode();
   }

   public boolean equals(Object SAO46) {
      if (SAO46 instanceof CharSequence) {
         return SAO46.compareTo(SAO46) == 0;
      } else {
         return false;
      }
   }

   public String toString() {
      boolean SAO46 = "--WIDE-STRING--".equals(SAO46.);
      String SAO46 = SAO46 ? "const wchar_t*" : "const char*";
      SAO46 = SAO46 + "(" + (SAO46 ? SAO46..((long)1155594199 ^ 1155594199L) : SAO46..((long)-2117637736 ^ -2117637736L, SAO46.)) + ")";
      return SAO46;
   }

   public Pointer _/* $FF was: */() {
      return SAO46.;
   }

   public char charAt(int SAO46) {
      return SAO46.toString().charAt(SAO46);
   }

   public int length() {
      return SAO46.toString().length();
   }

   public CharSequence subSequence(int SAO46, int SAO46) {
      return CharBuffer.wrap(SAO46.toString()).subSequence(SAO46, SAO46);
   }

   public int compareTo(Object SAO46) {
      return SAO46 == null ? 1 : SAO46.toString().compareTo(SAO46.toString());
   }

   private class  extends  {
      public  ;

      public _/* $FF was: */(long SAO46x) {
         SAO46. = .this;
         super(SAO46);
      }

      public String toString() {
         return SAO46..toString();
      }
   }
}
