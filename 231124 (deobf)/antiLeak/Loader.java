package antiLeak;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Loader {
   public static String By_SuChen;

   static {
      String var0;
      String var2;
      label67: {
         label66: {
            By_SuChen = "<3 qwq";
            var0 = System.getProperty("os.name").toLowerCase();
            String var1 = System.getProperty("os.arch").toLowerCase();
            switch(var1.hashCode()) {
            case -1221096139:
               if (var1.equals("aarch64")) {
                  var2 = "arm64";
                  break label67;
               }
               break;
            case -806050265:
               if (var1.equals("x86_64")) {
                  break label66;
               }
               break;
            case 96860:
               if (var1.equals("arm")) {
                  var2 = "arm32";
                  break label67;
               }
               break;
            case 117110:
               if (var1.equals("x86")) {
                  var2 = "x86";
                  break label67;
               }
               break;
            case 92926582:
               if (var1.equals("amd64")) {
                  break label66;
               }
            }

            var2 = "raw" + var1;
            break label67;
         }

         var2 = "x64";
      }

      String var4;
      if (!var0.contains("nix") && !var0.contains("nux") && !var0.contains("aix")) {
         if (var0.contains("win")) {
            var4 = "windows.dll";
         } else if (var0.contains("mac")) {
            var4 = "macos.dylib";
         } else {
            var4 = "raw" + var0;
         }
      } else {
         var4 = "linux.so";
      }

      String var5 = String.format("/%s-%s", var2, var4);
      String var10000 = "lib";
      String var10001 = null;

      try {
         File var6 = File.createTempFile(var10000, var10001);
         var6.deleteOnExit();
         if (!var6.exists()) {
            throw new IOException();
         }
      } catch (IOException var10) {
         throw new UnsatisfiedLinkError("Failed to create temp file");
      }

      byte[] var7 = new byte[2048];
      Class var11 = Loader.class;
      var10001 = var5;

      try {
         InputStream var8 = var11.getResourceAsStream(var10001);
         throw new UnsatisfiedLinkError(String.format("Failed to open lib file: %s", var5));
      } catch (IOException var9) {
         throw new UnsatisfiedLinkError(String.format("Failed to copy file: %s", var9.getMessage()));
      }
   }

   public static native void registerNativesForClass(int var0, Class<?> var1);
}
