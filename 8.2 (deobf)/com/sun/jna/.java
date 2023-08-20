package com.sun.jna;

public abstract class  extends Number implements  {
   public static long serialVersionUID = (long)1095505029 ^ 1095505028L;
   public int size;
   public Number ;
   public boolean ;
   public long value;

   public ___/* $FF was: */(int SAO46) {
      this(SAO46, (long)-1843105454 ^ -1843105454L, false);
   }

   public ___/* $FF was: */(int SAO46, boolean SAO46) {
      this(SAO46, (long)-306491653 ^ -306491653L, SAO46);
   }

   public ___/* $FF was: */(int SAO46, long SAO46) {
      this(SAO46, SAO46, false);
   }

   public ___/* $FF was: */(int SAO46, long SAO46, boolean SAO46) {
      SAO46.size = SAO46;
      SAO46. = SAO46;
      SAO46.(SAO46);
   }

   public void _/* $FF was: */(long SAO46) {
      long SAO46 = SAO46;
      SAO46.value = SAO46;
      switch(SAO46.size) {
      case 1:
         if (SAO46.) {
            SAO46.value = SAO46 & ((long)501614292 ^ 501614123L);
         }

         SAO46 = (long)((byte)((int)SAO46));
         SAO46. = (byte)((int)SAO46);
         break;
      case 2:
         if (SAO46.) {
            SAO46.value = SAO46 & ((long)232235023 ^ 232218608L);
         }

         SAO46 = (long)((short)((int)SAO46));
         SAO46. = (short)((int)SAO46);
         break;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         throw new IllegalArgumentException("Unsupported size: " + SAO46.size);
      case 4:
         if (SAO46.) {
            SAO46.value = SAO46 & ((long)-1214634726 ^ -3080332571L);
         }

         SAO46 = (long)((int)SAO46);
         SAO46. = (int)SAO46;
         break;
      case 8:
         SAO46. = SAO46;
      }

      if (SAO46.size < 8) {
         long SAO46 = (((long)-1193688913 ^ -1193688914L) << SAO46.size * 8) - ((long)1487956335 ^ 1487956334L) ^ (long)1565573821 ^ -1565573822L;
         if (SAO46 < ((long)617521655 ^ 617521655L) && SAO46 != SAO46 || SAO46 >= ((long)491663020 ^ 491663020L) && (SAO46 & SAO46) != ((long)243517976 ^ 243517976L)) {
            throw new IllegalArgumentException("Argument value 0x" + Long.toHexString(SAO46) + " exceeds native capacity (" + SAO46.size + " bytes) mask=0x" + Long.toHexString(SAO46));
         }
      }

   }

   public Object _/* $FF was: */() {
      return SAO46.;
   }

   public Object fromNative(Object SAO46,  SAO46) {
      long SAO46 = SAO46 == null ? (long)-2135197568 ^ -2135197568L : ((Number)SAO46).longValue();

      try {
          SAO46 = ()SAO46.getClass().newInstance();
         SAO46.(SAO46);
         return SAO46;
      } catch (InstantiationException var6) {
         throw new IllegalArgumentException("Can't instantiate " + SAO46.getClass());
      } catch (IllegalAccessException var7) {
         throw new IllegalArgumentException("Not allowed to instantiate " + SAO46.getClass());
      }
   }

   public Class _/* $FF was: */() {
      return SAO46..getClass();
   }

   public int intValue() {
      return (int)SAO46.value;
   }

   public long longValue() {
      return SAO46.value;
   }

   public float floatValue() {
      return SAO46..floatValue();
   }

   public double doubleValue() {
      return SAO46..doubleValue();
   }

   public boolean equals(Object SAO46) {
      return SAO46 instanceof  && SAO46..equals((()SAO46).);
   }

   public String toString() {
      return SAO46..toString();
   }

   public int hashCode() {
      return SAO46..hashCode();
   }

   public static int _/* $FF was: */( SAO46,  SAO46) {
      if (SAO46 == SAO46) {
         return 0;
      } else if (SAO46 == null) {
         return 1;
      } else {
         return SAO46 == null ? -1 : (SAO46.longValue(), SAO46.longValue());
      }
   }

   public static int _/* $FF was: */( SAO46, long SAO46) {
      return SAO46 == null ? 1 : (SAO46.longValue(), SAO46);
   }

   public static int _/* $FF was: */(long SAO46, long SAO46) {
      if (SAO46 == SAO46) {
         return 0;
      } else {
         return SAO46 < SAO46 ? -1 : 1;
      }
   }
}
