package com.sun.jna;

import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class  extends Pointer {
   public static Map  = Collections.synchronizedMap(new WeakHashMap());
   public static   = new ();
   public long ;

   public static void _/* $FF was: */() {
      .();
   }

   public static void _/* $FF was: */() {
      for( SAO46 : new LinkedList(.keySet())) {
         SAO46.dispose();
      }

   }

   public ___/* $FF was: */(long SAO46) {
      SAO46. = SAO46;
      if (SAO46 <= ((long)-360008713 ^ -360008713L)) {
         throw new IllegalArgumentException("Allocation size must be greater than zero");
      } else {
         SAO46. = malloc(SAO46);
         if (SAO46. == ((long)-444454176 ^ -444454176L)) {
            throw new OutOfMemoryError("Cannot allocate " + SAO46 + " bytes");
         } else {
            .put(SAO46, new WeakReference(SAO46));
         }
      }
   }

   public ___/* $FF was: */() {
   }

   public Pointer _/* $FF was: */(long SAO46) {
      return SAO46.(SAO46, SAO46.() - SAO46);
   }

   public Pointer _/* $FF was: */(long SAO46, long SAO46) {
      SAO46.(SAO46, SAO46);
      return new .(SAO46, SAO46);
   }

   public  _/* $FF was: */(int SAO46) {
      if (SAO46 <= 0) {
         throw new IllegalArgumentException("Byte boundary must be positive: " + SAO46);
      } else {
         for(int SAO46 = 0; SAO46 < 32; ++SAO46) {
            if (SAO46 == 1 << SAO46) {
               long SAO46 = (long)SAO46 - ((long)-1763605308 ^ -1763605307L) ^ (long)-223730898 ^ 223730897L;
               if ((SAO46. & SAO46) != SAO46.) {
                  long SAO46 = SAO46. + (long)SAO46 - ((long)-647027082 ^ -647027081L) & SAO46;
                  long SAO46 = SAO46. + SAO46. - SAO46;
                  if (SAO46 <= ((long)483796718 ^ 483796718L)) {
                     throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
                  }

                  return ()SAO46.(SAO46 - SAO46., SAO46);
               }

               return SAO46;
            }
         }

         throw new IllegalArgumentException("Byte boundary must be a power of two");
      }
   }

   public void finalize() {
      SAO46.dispose();
   }

   public synchronized void dispose() {
      boolean var3 = false;

      try {
         var3 = true;
         free(SAO46.);
         var3 = false;
      } finally {
         if (var3) {
            .remove(SAO46);
            SAO46. = (long)1678553534 ^ 1678553534L;
         }
      }

      .remove(SAO46);
      SAO46. = (long)-1893703884 ^ -1893703884L;
   }

   public void clear() {
      SAO46.(SAO46.);
   }

   public boolean __/* $FF was: */() {
      return SAO46. != ((long)132500390 ^ 132500390L);
   }

   public long _/* $FF was: */() {
      return SAO46.;
   }

   public void _/* $FF was: */(long SAO46, long SAO46) {
      if (SAO46 < ((long)1839911357 ^ 1839911357L)) {
         throw new IndexOutOfBoundsException("Invalid offset: " + SAO46);
      } else if (SAO46 + SAO46 > SAO46.) {
         String SAO46 = "Bounds exceeds available space : size=" + SAO46. + ", offset=" + (SAO46 + SAO46);
         throw new IndexOutOfBoundsException(SAO46);
      }
   }

   public void _/* $FF was: */(long SAO46, byte[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)1878476756 ^ 1878476757L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, short[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-885160288 ^ -885160286L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, char[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-543857735 ^ -543857733L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, int[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)1010594192 ^ 1010594196L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, long[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)1750561321 ^ 1750561313L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, float[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)163628959 ^ 163628955L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, double[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)1113468021 ^ 1113468029L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, byte[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-454018066 ^ -454018065L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, short[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-278209451 ^ -278209449L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, char[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)1394168007 ^ 1394168005L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, int[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-1191146210 ^ -1191146214L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, long[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-83826859 ^ -83826851L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, float[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)-467711246 ^ -467711242L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, double[] SAO46, int SAO46, int SAO46) {
      SAO46.(SAO46, (long)SAO46 * ((long)1461794034 ^ 1461794042L));
      super.(SAO46, SAO46, SAO46, SAO46);
   }

   public byte _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)459324348 ^ 459324349L);
      return super.(SAO46);
   }

   public char _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)-305292855 ^ -305292856L);
      return super.(SAO46);
   }

   public short _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)336592012 ^ 336592014L);
      return super.(SAO46);
   }

   public int _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)2076962328 ^ 2076962332L);
      return super.(SAO46);
   }

   public long _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)1764489740 ^ 1764489732L);
      return super.(SAO46);
   }

   public float _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)-486583569 ^ -486583573L);
      return super.(SAO46);
   }

   public double _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)-232568431 ^ -232568423L);
      return super.(SAO46);
   }

   public Pointer _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)Pointer.);
      return super.(SAO46);
   }

   public ByteBuffer _/* $FF was: */(long SAO46, long SAO46) {
      SAO46.(SAO46, SAO46);
      ByteBuffer SAO46 = super.(SAO46, SAO46);
      .(SAO46, SAO46);
      return SAO46;
   }

   public String _/* $FF was: */(long SAO46, String SAO46) {
      SAO46.(SAO46, (long)1008952073 ^ 1008952073L);
      return super.(SAO46, SAO46);
   }

   public String _/* $FF was: */(long SAO46) {
      SAO46.(SAO46, (long)-1148701596 ^ -1148701596L);
      return super.(SAO46);
   }

   public void _/* $FF was: */(long SAO46, byte SAO46) {
      SAO46.(SAO46, (long)1421665655 ^ 1421665654L);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, char SAO46) {
      SAO46.(SAO46, (long)Native.);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, short SAO46) {
      SAO46.(SAO46, (long)-221977205 ^ -221977207L);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, int SAO46) {
      SAO46.(SAO46, (long)-1046748791 ^ -1046748787L);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, long SAO46) {
      SAO46.(SAO46, (long)1466412083 ^ 1466412091L);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, float SAO46) {
      SAO46.(SAO46, (long)2011278096 ^ 2011278100L);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, double SAO46) {
      SAO46.(SAO46, (long)-923088693 ^ -923088701L);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, Pointer SAO46) {
      SAO46.(SAO46, (long)Pointer.);
      super.(SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, String SAO46, String SAO46) {
      SAO46.(SAO46, (long)Native.(SAO46, SAO46).length + ((long)-1782749633 ^ -1782749634L));
      super.(SAO46, SAO46, SAO46);
   }

   public void _/* $FF was: */(long SAO46, String SAO46) {
      SAO46.(SAO46, ((long)SAO46.length() + ((long)-1296870031 ^ -1296870032L)) * (long)Native.);
      super.(SAO46, SAO46);
   }

   public String toString() {
      return "allocated@0x" + Long.toHexString(SAO46.) + " (" + SAO46. + " bytes)";
   }

   public static void free(long SAO46) {
      if (SAO46 != ((long)305915377 ^ 305915377L)) {
         Native.free(SAO46);
      }

   }

   public static long malloc(long SAO46) {
      return Native.malloc(SAO46);
   }

   public String _/* $FF was: */() {
      return SAO46.((long)613209887 ^ 613209887L, (int)SAO46.());
   }

   private class  extends  {
      public  ;

      public _/* $FF was: */(long SAO46xx, long SAO46x) {
         SAO46. = .this;
         super();
         SAO46. = SAO46;
         SAO46. = .this. + SAO46;
      }

      public void dispose() {
         SAO46. = (long)1167778608 ^ 1167778608L;
      }

      public void _/* $FF was: */(long SAO46xx, long SAO46x) {
         SAO46..(SAO46. - SAO46.. + SAO46, SAO46);
      }

      public String toString() {
         return super.toString() + " (shared from " + SAO46..toString() + ")";
      }
   }
}
