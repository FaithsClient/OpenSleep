package native0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Loader {
   public static String QWQ = "Protected by Yalan QQ: 3523990534";
   public static String OWO = "本混淆完全免费 加qq群340714894获取最新的调教Native混淆器!";
   public static String AWA = "Native-Obfuscator github: https://github.com/radioegor146/native-obfuscator";

   public static native void registerNativesForClass(int var0, Class var1);

   public static int getOS() {
      String SAO46 = System.getProperty("os.name").toLowerCase();
      if (SAO46.contains("windows")) {
         return 0;
      } else if (SAO46.contains("mac")) {
         return 1;
      } else {
         return SAO46.contains("linux") ? 2 : -1;
      }
   }

   public static void load(String SAO46) throws IOException {
      InputStream SAO46 = Loader.class.getResourceAsStream("/" + SAO46);
      if (SAO46 == null) {
         throw new RuntimeException("Lib not found " + SAO46);
      } else {
         File SAO46 = new File("NativeDepends/");
         SAO46.mkdir();
         File SAO46 = new File("NativeDepends/" + SAO46);
         FileOutputStream SAO46 = null;

         try {
            SAO46 = new FileOutputStream(SAO46);
            byte[] SAO46 = new byte[512];

            int SAO46;
            while((SAO46 = SAO46.read(SAO46)) != -1) {
               SAO46.write(SAO46, 0, SAO46);
            }
         } finally {
            try {
               SAO46.close();
            } catch (IOException var15) {
               ;
            }

            if (SAO46 != null) {
               try {
                  SAO46.close();
               } catch (IOException var14) {
                  ;
               }
            }

         }

         System.load(SAO46.getAbsolutePath());
      }
   }

   static {
      int SAO46 = getOS();
      String SAO46 = null;
      switch(SAO46) {
      case -1:
         (new RuntimeException("Unsupported os : " + System.getProperty("os.name"))).printStackTrace();
         break;
      case 0:
         SAO46 = "xieshenmeima.dll";
         break;
      case 1:
         SAO46 = "xieshenmeima.dylib";
         break;
      case 2:
         SAO46 = "xieshenmeima.so";
      }

      if (SAO46 != null) {
         try {
            load(SAO46);
         } catch (Throwable var3) {
            var3.printStackTrace();
         }
      }

   }
}
