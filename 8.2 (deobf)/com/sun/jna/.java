package com.sun.jna;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  {
   public static int  = -1;
   public static int  = 0;
   public static int  = 1;
   public static int  = 2;
   public static int  = 3;
   public static int  = 4;
   public static int  = 5;
   public static int  = 6;
   public static int  = 7;
   public static int  = 8;
   public static int  = 9;
   public static int  = 10;
   public static int  = 11;
   public static boolean ;
   public static boolean ;
   public static boolean ;
   public static boolean ;
   public static String ;
   public static String ;
   public static boolean ;
   public static String ;
   public static int ;
   public static String ;

   public static int __/* $FF was: */() {
      return ;
   }

   public static boolean __/* $FF was: */() {
      return  == 0;
   }

   public static boolean __/* $FF was: */() {
      return  == 8;
   }

   public static boolean __/* $FF was: */() {
      return  == 1;
   }

   public static boolean __/* $FF was: */() {
      return  == 7;
   }

   /** @deprecated */
   public static boolean ___/* $FF was: */() {
      return ();
   }

   public static boolean ___/* $FF was: */() {
      return  == 6;
   }

   public static boolean ___/* $FF was: */() {
      return  == 2 ||  == 6;
   }

   public static boolean ___/* $FF was: */() {
      return  == 3;
   }

   public static boolean ___/* $FF was: */() {
      return  == 4;
   }

   public static boolean ___/* $FF was: */() {
      return  == 5;
   }

   public static boolean ___/* $FF was: */() {
      return  == 11;
   }

   public static boolean ___/* $FF was: */() {
      return  == 9;
   }

   public static boolean ___/* $FF was: */() {
      return  == 10;
   }

   public static boolean ___/* $FF was: */() {
      return !() && !();
   }

   public static boolean ___/* $FF was: */() {
      return !() || !"J9".equals(System.getProperty("java.vm.name"));
   }

   public static boolean _/* $FF was: */() {
      String SAO46 = System.getProperty("sun.arch.data.model", System.getProperty("com.ibm.vm.bitmode"));
      if (SAO46 != null) {
         return "64".equals(SAO46);
      } else if (!"x86-64".equals() && !"ia64".equals() && !"ppc64".equals() && !"ppc64le".equals() && !"sparcv9".equals() && !"mips64".equals() && !"mips64el".equals() && !"amd64".equals()) {
         return Native. == 8;
      } else {
         return true;
      }
   }

   public static boolean ___/* $FF was: */() {
      return .startsWith("x86");
   }

   public static boolean ___/* $FF was: */() {
      return .startsWith("ppc");
   }

   public static boolean ___/* $FF was: */() {
      return .startsWith("arm");
   }

   public static boolean ___/* $FF was: */() {
      return .startsWith("sparc");
   }

   public static boolean ___/* $FF was: */() {
      return .equals("mips") || .equals("mips64") || .equals("mipsel") || .equals("mips64el");
   }

   public static String _/* $FF was: */(String SAO46, int SAO46) {
      SAO46 = SAO46.toLowerCase().trim();
      if ("powerpc".equals(SAO46)) {
         SAO46 = "ppc";
      } else if ("powerpc64".equals(SAO46)) {
         SAO46 = "ppc64";
      } else if (!"i386".equals(SAO46) && !"i686".equals(SAO46)) {
         if ("x86_64".equals(SAO46) || "amd64".equals(SAO46)) {
            SAO46 = "x86-64";
         }
      } else {
         SAO46 = "x86";
      }

      if ("ppc64".equals(SAO46) && "little".equals(System.getProperty("sun.cpu.endian"))) {
         SAO46 = "ppc64le";
      }

      if ("arm".equals(SAO46) && SAO46 == 1 && ()) {
         SAO46 = "armel";
      }

      return SAO46;
   }

   public static boolean ___/* $FF was: */() {
      try {
         File SAO46 = new File("/proc/self/exe");
         if (SAO46.exists()) {
             SAO46 = .(SAO46.getCanonicalPath());
            return SAO46.();
         }
      } catch (IOException var2) {
         Logger.getLogger(.class.getName()).log(Level.INFO, "Failed to read '/proc/self/exe' or the target binary.", var2);
      } catch (SecurityException var3) {
         Logger.getLogger(.class.getName()).log(Level.INFO, "SecurityException while analysing '/proc/self/exe' or the target binary.", var3);
      }

      return false;
   }

   public static String __/* $FF was: */() {
      String SAO46 = System.getProperty("jna.prefix");
      return SAO46 != null ? SAO46 : ((), System.getProperty("os.arch"), System.getProperty("os.name"));
   }

   public static String _/* $FF was: */(int SAO46, String SAO46, String SAO46) {
      SAO46 = (SAO46, SAO46);
      String SAO46;
      switch(SAO46) {
      case 0:
         SAO46 = "darwin";
         break;
      case 1:
         SAO46 = "linux-" + SAO46;
         break;
      case 2:
         SAO46 = "win32-" + SAO46;
         break;
      case 3:
         SAO46 = "sunos-" + SAO46;
         break;
      case 4:
         SAO46 = "freebsd-" + SAO46;
         break;
      case 5:
         SAO46 = "openbsd-" + SAO46;
         break;
      case 6:
         SAO46 = "w32ce-" + SAO46;
         break;
      case 7:
      case 9:
      default:
         SAO46 = SAO46.toLowerCase();
         int SAO46 = SAO46.indexOf(" ");
         if (SAO46 != -1) {
            SAO46 = SAO46.substring(0, SAO46);
         }

         SAO46 = SAO46 + "-" + SAO46;
         break;
      case 8:
         if (SAO46.startsWith("arm")) {
            SAO46 = "arm";
         }

         SAO46 = "android-" + SAO46;
         break;
      case 10:
         SAO46 = "kfreebsd-" + SAO46;
         break;
      case 11:
         SAO46 = "netbsd-" + SAO46;
      }

      return SAO46;
   }

   static {
      String SAO46 = System.getProperty("os.name");
      if (SAO46.startsWith("Linux")) {
         if ("dalvik".equals(System.getProperty("java.vm.name").toLowerCase())) {
             = 8;
            System.setProperty("jna.nounpack", "true");
         } else {
             = 1;
         }
      } else if (SAO46.startsWith("AIX")) {
          = 7;
      } else if (!SAO46.startsWith("Mac") && !SAO46.startsWith("Darwin")) {
         if (SAO46.startsWith("Windows CE")) {
             = 6;
         } else if (SAO46.startsWith("Windows")) {
             = 2;
         } else if (!SAO46.startsWith("Solaris") && !SAO46.startsWith("SunOS")) {
            if (SAO46.startsWith("FreeBSD")) {
                = 4;
            } else if (SAO46.startsWith("OpenBSD")) {
                = 5;
            } else if (SAO46.equalsIgnoreCase("gnu")) {
                = 9;
            } else if (SAO46.equalsIgnoreCase("gnu/kfreebsd")) {
                = 10;
            } else if (SAO46.equalsIgnoreCase("netbsd")) {
                = 11;
            } else {
                = -1;
            }
         } else {
             = 3;
         }
      } else {
          = 0;
      }

      boolean SAO46 = false;

      try {
         Class.forName("java.nio.Buffer");
         SAO46 = true;
      } catch (ClassNotFoundException var3) {
         ;
      }

       =  != 6 &&  != 8 &&  != 7;
       =  &&  != 0;
       = SAO46;
       =  != 6;
       =  == 2 ? "msvcrt" : ( == 6 ? "coredll" : "c");
       =  == 2 ? "msvcrt" : ( == 6 ? "coredll" : "m");
       =  == 2;
       = (System.getProperty("os.arch"), );
       = ();
   }
}
