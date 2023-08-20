package com.sun.jna;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class  {
   public static byte[]  = new byte[]{127, 69, 76, 70};
   public static int  = 1024;
   public static int  = 512;
   public static int  = 2;
   public static int  = 40;
   public static int  = 2;
   public String ;
   public boolean  = false;
   public boolean  = false;
   public boolean  = false;
   public boolean  = false;
   public boolean  = false;
   public boolean  = false;

   public static  _/* $FF was: */(String SAO46) throws IOException {
       SAO46 = new (SAO46);
      SAO46.();
      return SAO46;
   }

   public boolean _/* $FF was: */() {
      return SAO46.;
   }

   public boolean _/* $FF was: */() {
      return SAO46.;
   }

   public boolean _/* $FF was: */() {
      return SAO46.;
   }

   public String _/* $FF was: */() {
      return SAO46.;
   }

   public boolean __/* $FF was: */() {
      return SAO46.;
   }

   public boolean __/* $FF was: */() {
      return SAO46.;
   }

   public boolean __/* $FF was: */() {
      return SAO46.;
   }

   public __/* $FF was: */(String SAO46) {
      SAO46. = SAO46;
   }

   public void _/* $FF was: */() throws IOException {
      RandomAccessFile SAO46 = new RandomAccessFile(SAO46., "r");

      try {
         if (SAO46.length() > ((long)-1768068339 ^ -1768068343L)) {
            byte[] SAO46 = new byte[4];
            SAO46.seek((long)1193851157 ^ 1193851157L);
            SAO46.read(SAO46);
            if (Arrays.equals(SAO46, )) {
               SAO46. = true;
            }
         }

         if (SAO46.) {
            SAO46.seek((long)-150291209 ^ -150291213L);
            byte SAO46 = SAO46.readByte();
            SAO46. = SAO46 == 2;
            SAO46.seek((long)260529878 ^ 260529878L);
            ByteBuffer SAO46 = ByteBuffer.allocate(SAO46. ? 64 : 52);
            SAO46.getChannel().read(SAO46, (long)843832448 ^ 843832448L);
            SAO46. = SAO46.get(5) == 2;
            SAO46.order(SAO46. ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            SAO46. = SAO46.get(18) == 40;
            if (SAO46.) {
               int SAO46 = SAO46.getInt(SAO46. ? 48 : 36);
               SAO46. = (SAO46 & 1024) == 1024;
               SAO46. = !SAO46.;
            }

            return;
         }
      } finally {
         try {
            SAO46.close();
         } catch (IOException var11) {
            ;
         }

      }

   }
}
