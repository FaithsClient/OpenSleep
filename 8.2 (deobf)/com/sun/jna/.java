package com.sun.jna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class  {
   public long ;
   public String ;
   public String ;
   public Map  = new HashMap();
   public int ;
   public String ;
   public Map options;
   public static Map  = new HashMap();
   public static Map  = Collections.synchronizedMap(new HashMap());
   public static List  = new ArrayList();
   public static int  = -1;

   public static String _/* $FF was: */(String SAO46, int SAO46, String SAO46) {
      return SAO46 + "|" + SAO46 + "|" + SAO46;
   }

   public ___/* $FF was: */(String SAO46, String SAO46, long SAO46, Map SAO46) {
      SAO46. = SAO46.(SAO46);
      SAO46. = SAO46;
      SAO46. = SAO46;
      Object SAO46 = SAO46.get("calling-convention");
      int SAO46 = SAO46 instanceof Number ? ((Number)SAO46).intValue() : 0;
      SAO46. = SAO46;
      SAO46.options = SAO46;
      SAO46. = (String)SAO46.get("string-encoding");
      if (SAO46. == null) {
         SAO46. = Native.();
      }

      if (.() && "kernel32".equals(SAO46..toLowerCase())) {
         synchronized(SAO46.) {
            Function SAO46 = new Function(SAO46, SAO46, "GetLastError", 63, SAO46.) {
               public  ;

               public {
                  SAO46. = SAO46;
               }

               public Object _/* $FF was: */(Object[] SAO46xx, Class SAO46xxxx, boolean SAO46x, int SAO46xxx) {
                  return Native.getLastError();
               }

               public Object _/* $FF was: */(Method SAO46x, Class[] SAO46xx, Class SAO46xxx, Object[] SAO46xxxx, Map SAO46xxxxx) {
                  return Native.getLastError();
               }
            };
            SAO46..put(("GetLastError", SAO46., SAO46.), SAO46);
         }
      }

   }

   public static int _/* $FF was: */(Map SAO46) {
      Object SAO46 = SAO46.get("open-flags");
      return SAO46 instanceof Number ? ((Number)SAO46).intValue() : -1;
   }

   public static  _/* $FF was: */(String SAO46, Map SAO46) {
      if (Native.) {
         System.out.println("Looking for library '" + SAO46 + "'");
      }

      boolean SAO46 = (new File(SAO46)).isAbsolute();
      List SAO46 = new ArrayList();
      int SAO46 = (SAO46);
      String SAO46 = Native.(SAO46);
      if (SAO46 != null) {
         if (Native.) {
            System.out.println("Adding web start path " + SAO46);
         }

         SAO46.add(SAO46);
      }

      List SAO46 = (List).get(SAO46);
      if (SAO46 != null) {
         synchronized(SAO46) {
            SAO46.addAll(0, SAO46);
         }
      }

      if (Native.) {
         System.out.println("Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
      }

      SAO46.addAll(("jna.library.path"));
      String SAO46 = (SAO46, SAO46);
      long SAO46 = (long)1407892066 ^ 1407892066L;

      try {
         if (Native.) {
            System.out.println("Trying " + SAO46);
         }

         SAO46 = Native.open(SAO46, SAO46);
      } catch (UnsatisfiedLinkError var30) {
         if (Native.) {
            System.out.println("Adding system paths: " + );
         }

         SAO46.addAll();
      }

      try {
         if (SAO46 == ((long)-1444540419 ^ -1444540419L)) {
            SAO46 = (SAO46, SAO46);
            if (Native.) {
               System.out.println("Trying " + SAO46);
            }

            SAO46 = Native.open(SAO46, SAO46);
            if (SAO46 == ((long)-559776176 ^ -559776176L)) {
               throw new UnsatisfiedLinkError("Failed to load library '" + SAO46 + "'");
            }
         }
      } catch (UnsatisfiedLinkError var29) {
         UnsatisfiedLinkError SAO46 = var29;
         if (.()) {
            try {
               if (Native.) {
                  System.out.println("Preload (via System.loadLibrary) " + SAO46);
               }

               System.loadLibrary(SAO46);
               SAO46 = Native.open(SAO46, SAO46);
            } catch (UnsatisfiedLinkError var25) {
               SAO46 = var25;
            }
         } else if (!.() && !.()) {
            if (.() && !SAO46.endsWith(".dylib")) {
               if (Native.) {
                  System.out.println("Looking for matching frameworks");
               }

               SAO46 = (SAO46);
               if (SAO46 != null) {
                  try {
                     if (Native.) {
                        System.out.println("Trying " + SAO46);
                     }

                     SAO46 = Native.open(SAO46, SAO46);
                  } catch (UnsatisfiedLinkError var23) {
                     SAO46 = var23;
                  }
               }
            } else if (.() && !SAO46) {
               if (Native.) {
                  System.out.println("Looking for lib- prefix");
               }

               SAO46 = ("lib" + SAO46, SAO46);
               if (SAO46 != null) {
                  if (Native.) {
                     System.out.println("Trying " + SAO46);
                  }

                  try {
                     SAO46 = Native.open(SAO46, SAO46);
                  } catch (UnsatisfiedLinkError var22) {
                     SAO46 = var22;
                  }
               }
            }
         } else {
            if (Native.) {
               System.out.println("Looking for version variants");
            }

            SAO46 = (SAO46, SAO46);
            if (SAO46 != null) {
               if (Native.) {
                  System.out.println("Trying " + SAO46);
               }

               try {
                  SAO46 = Native.open(SAO46, SAO46);
               } catch (UnsatisfiedLinkError var24) {
                  SAO46 = var24;
               }
            }
         }

         if (SAO46 == ((long)-1308304220 ^ -1308304220L)) {
            try {
               File SAO46 = Native.(SAO46, (ClassLoader)SAO46.get("classloader"));

               try {
                  SAO46 = Native.open(SAO46.getAbsolutePath(), SAO46);
                  SAO46 = SAO46.getAbsolutePath();
               } finally {
                  if (Native.(SAO46)) {
                     Native.(SAO46);
                  }

               }
            } catch (IOException var28) {
               SAO46 = new UnsatisfiedLinkError(var28.getMessage());
            }
         }

         if (SAO46 == ((long)-2050931922 ^ -2050931922L)) {
            throw new UnsatisfiedLinkError("Unable to load library '" + SAO46 + "': " + SAO46.getMessage());
         }
      }

      if (Native.) {
         System.out.println("Found library '" + SAO46 + "' at " + SAO46);
      }

      return new (SAO46, SAO46, SAO46, SAO46);
   }

   public static String _/* $FF was: */(String SAO46) {
      File SAO46 = new File(SAO46);
      if (SAO46.isAbsolute()) {
         if (SAO46.indexOf(".framework") != -1 && SAO46.exists()) {
            return SAO46.getAbsolutePath();
         }

         SAO46 = new File(new File(SAO46.getParentFile(), SAO46.getName() + ".framework"), SAO46.getName());
         if (SAO46.exists()) {
            return SAO46.getAbsolutePath();
         }
      } else {
         String[] SAO46 = new String[]{System.getProperty("user.home"), "", "/System"};
         String SAO46 = SAO46.indexOf(".framework") == -1 ? SAO46 + ".framework/" + SAO46 : SAO46;

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            String SAO46 = SAO46[SAO46] + "/Library/Frameworks/" + SAO46;
            if ((new File(SAO46)).exists()) {
               return SAO46;
            }
         }
      }

      return null;
   }

   public String __/* $FF was: */(String SAO46) {
      String SAO46 = SAO46;
      String SAO46 = "---";
      String SAO46 = ("---");
      int SAO46 = SAO46.indexOf("---");
      if (SAO46 > 0 && SAO46.startsWith(SAO46.substring(0, SAO46))) {
         SAO46 = SAO46.substring(SAO46);
      }

      String SAO46 = SAO46.substring(SAO46 + "---".length());
      int SAO46 = SAO46.indexOf(SAO46);
      if (SAO46 != -1) {
         SAO46 = SAO46.substring(0, SAO46);
      }

      return SAO46;
   }

   public static  _/* $FF was: */(String SAO46) {
      return (SAO46, Collections.emptyMap());
   }

   public static  _/* $FF was: */(String SAO46, ClassLoader SAO46) {
      return (SAO46, Collections.singletonMap("classloader", SAO46));
   }

   public static  _/* $FF was: */(String SAO46, Map SAO46) {
      Map SAO46 = new HashMap(SAO46);
      if (SAO46.get("calling-convention") == null) {
         SAO46.put("calling-convention", Integer.valueOf(0));
      }

      if ((.() || .() || .()) && ..equals(SAO46)) {
         SAO46 = null;
      }

      synchronized() {
         Reference SAO46 = (Reference).get(SAO46 + SAO46);
          SAO46 = SAO46 != null ? ()SAO46.get() : null;
         if (SAO46 == null) {
            if (SAO46 == null) {
               SAO46 = new ("<process>", (String)null, Native.open((String)null, (SAO46)), SAO46);
            } else {
               SAO46 = (SAO46, SAO46);
            }

            Reference var9 = new WeakReference(SAO46);
            .put(SAO46.getName() + SAO46, var9);
            File SAO46 = SAO46.getFile();
            if (SAO46 != null) {
               .put(SAO46.getAbsolutePath() + SAO46, var9);
               .put(SAO46.getName() + SAO46, var9);
            }
         }

         return SAO46;
      }
   }

   public static synchronized  _/* $FF was: */() {
      return ((String)null);
   }

   public static synchronized  _/* $FF was: */(Map SAO46) {
      return ((String)null, SAO46);
   }

   public static void _/* $FF was: */(String SAO46, String SAO46) {
      synchronized() {
         List SAO46 = (List).get(SAO46);
         if (SAO46 == null) {
            SAO46 = Collections.synchronizedList(new ArrayList());
            .put(SAO46, SAO46);
         }

         SAO46.add(SAO46);
      }
   }

   public Function _/* $FF was: */(String SAO46) {
      return SAO46.(SAO46, SAO46.);
   }

   public Function _/* $FF was: */(String SAO46, Method SAO46) {
       SAO46 = ()SAO46.options.get("function-mapper");
      if (SAO46 != null) {
         SAO46 = SAO46.getFunctionName(SAO46, SAO46);
      }

      String SAO46 = System.getProperty("jna.profiler.prefix", "$$YJP$$");
      if (SAO46.startsWith(SAO46)) {
         SAO46 = SAO46.substring(SAO46.length());
      }

      int SAO46 = SAO46.;
      Class[] SAO46 = SAO46.getExceptionTypes();

      for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
         if (.class.isAssignableFrom(SAO46[SAO46])) {
            SAO46 |= 64;
         }
      }

      return SAO46.(SAO46, SAO46);
   }

   public Function _/* $FF was: */(String SAO46, int SAO46) {
      return SAO46.(SAO46, SAO46, SAO46.);
   }

   public Function _/* $FF was: */(String SAO46, int SAO46, String SAO46) {
      if (SAO46 == null) {
         throw new NullPointerException("Function name may not be null");
      } else {
         synchronized(SAO46.) {
            String SAO46 = (SAO46, SAO46, SAO46);
            Function SAO46 = (Function)SAO46..get(SAO46);
            if (SAO46 == null) {
               SAO46 = new Function(SAO46, SAO46, SAO46, SAO46);
               SAO46..put(SAO46, SAO46);
            }

            return SAO46;
         }
      }
   }

   public Map _/* $FF was: */() {
      return SAO46.options;
   }

   public Pointer _/* $FF was: */(String SAO46) {
      try {
         return new Pointer(SAO46.(SAO46));
      } catch (UnsatisfiedLinkError var3) {
         throw new UnsatisfiedLinkError("Error looking up '" + SAO46 + "': " + var3.getMessage());
      }
   }

   public long _/* $FF was: */(String SAO46) {
      if (SAO46. == ((long)333899159 ^ 333899159L)) {
         throw new UnsatisfiedLinkError("Library has been unloaded");
      } else {
         return Native.findSymbol(SAO46., SAO46);
      }
   }

   public String toString() {
      return "Native Library <" + SAO46. + "@" + SAO46. + ">";
   }

   public String getName() {
      return SAO46.;
   }

   public File getFile() {
      return SAO46. == null ? null : new File(SAO46.);
   }

   public void finalize() {
      SAO46.dispose();
   }

   public static void _/* $FF was: */() {
      Set SAO46;
      synchronized() {
         SAO46 = new LinkedHashSet(.values());
      }

      for(Reference SAO46 : SAO46) {
          SAO46 = ()SAO46.get();
         if (SAO46 != null) {
            SAO46.dispose();
         }
      }

   }

   public void dispose() {
      Set SAO46 = new HashSet();
      synchronized() {
         for(Entry SAO46 : .entrySet()) {
            Reference SAO46 = (Reference)SAO46.getValue();
            if (SAO46.get() == SAO46) {
               SAO46.add(SAO46.getKey());
            }
         }

         for(String SAO46 : SAO46) {
            .remove(SAO46);
         }
      }

      synchronized(SAO46) {
         if (SAO46. != ((long)1008733246 ^ 1008733246L)) {
            Native.close(SAO46.);
            SAO46. = (long)1615581171 ^ 1615581171L;
         }

      }
   }

   public static List _/* $FF was: */(String SAO46) {
      String SAO46 = System.getProperty(SAO46, "");
      if ("".equals(SAO46)) {
         return Collections.emptyList();
      } else {
         StringTokenizer SAO46 = new StringTokenizer(SAO46, File.pathSeparator);
         List SAO46 = new ArrayList();

         while(SAO46.hasMoreTokens()) {
            String SAO46 = SAO46.nextToken();
            if (!"".equals(SAO46)) {
               SAO46.add(SAO46);
            }
         }

         return SAO46;
      }
   }

   public static String _/* $FF was: */(String SAO46, List SAO46) {
      if ((new File(SAO46)).isAbsolute()) {
         return SAO46;
      } else {
         String SAO46 = (SAO46);

         for(String SAO46 : SAO46) {
            File SAO46 = new File(SAO46, SAO46);
            if (SAO46.exists()) {
               return SAO46.getAbsolutePath();
            }

            if (.() && SAO46.endsWith(".dylib")) {
               SAO46 = new File(SAO46, SAO46.substring(0, SAO46.lastIndexOf(".dylib")) + ".jnilib");
               if (SAO46.exists()) {
                  return SAO46.getAbsolutePath();
               }
            }
         }

         return SAO46;
      }
   }

   public static String __/* $FF was: */(String SAO46) {
      if (.()) {
         if (!SAO46.startsWith("lib") || !SAO46.endsWith(".dylib") && !SAO46.endsWith(".jnilib")) {
            String SAO46 = System.mapLibraryName(SAO46);
            return SAO46.endsWith(".jnilib") ? SAO46.substring(0, SAO46.lastIndexOf(".jnilib")) + ".dylib" : SAO46;
         } else {
            return SAO46;
         }
      } else {
         if (!.() && !.()) {
            if (.()) {
               if (SAO46.startsWith("lib")) {
                  return SAO46;
               }
            } else if (.() && (SAO46.endsWith(".drv") || SAO46.endsWith(".dll"))) {
               return SAO46;
            }
         } else if ((SAO46) || SAO46.endsWith(".so")) {
            return SAO46;
         }

         return System.mapLibraryName(SAO46);
      }
   }

   public static boolean _/* $FF was: */(String SAO46) {
      if (SAO46.startsWith("lib")) {
         int SAO46 = SAO46.lastIndexOf(".so.");
         if (SAO46 != -1 && SAO46 + 4 < SAO46.length()) {
            for(int SAO46 = SAO46 + 4; SAO46 < SAO46.length(); ++SAO46) {
               char SAO46 = SAO46.charAt(SAO46);
               if (!Character.isDigit(SAO46) && SAO46 != '.') {
                  return false;
               }
            }

            return true;
         }
      }

      return false;
   }

   public static String _/* $FF was: */(String SAO46, List SAO46) {
      File SAO46 = new File(SAO46);
      if (SAO46.isAbsolute()) {
         SAO46 = Arrays.asList(SAO46.getParent());
      }

      FilenameFilter SAO46 = new FilenameFilter(SAO46) {
         public String ;

         public {
            SAO46. = var1;
         }

         public boolean accept(File SAO46x, String SAO46xx) {
            return (SAO46.startsWith("lib" + SAO46. + ".so") || SAO46.startsWith(SAO46. + ".so") && SAO46..startsWith("lib")) && .(SAO46);
         }
      };
      Collection SAO46 = new LinkedList();

      for(String SAO46 : SAO46) {
         File[] SAO46 = (new File(SAO46)).listFiles(SAO46);
         if (SAO46 != null && SAO46.length > 0) {
            SAO46.addAll(Arrays.asList(SAO46));
         }
      }

      double SAO46 = -1.0D;
      String SAO46 = null;

      for(File SAO46 : SAO46) {
         String SAO46 = SAO46.getAbsolutePath();
         String SAO46 = SAO46.substring(SAO46.lastIndexOf(".so.") + 4);
         double SAO46 = (SAO46);
         if (SAO46 > SAO46) {
            SAO46 = SAO46;
            SAO46 = SAO46;
         }
      }

      return SAO46;
   }

   public static double _/* $FF was: */(String SAO46) {
      double SAO46 = Double.longBitsToDouble(0L);
      double SAO46 = 1.0D;

      for(int SAO46 = SAO46.indexOf("."); SAO46 != null; SAO46 *= 100.0D) {
         String SAO46;
         if (SAO46 != -1) {
            SAO46 = SAO46.substring(0, SAO46);
            SAO46 = SAO46.substring(SAO46 + 1);
            SAO46 = SAO46.indexOf(".");
         } else {
            SAO46 = SAO46;
            SAO46 = null;
         }

         try {
            SAO46 += (double)Integer.parseInt(SAO46) / SAO46;
         } catch (NumberFormatException var8) {
            return Double.longBitsToDouble(0L);
         }
      }

      return SAO46;
   }

   public static String __/* $FF was: */() {
      String SAO46 = .;
      String SAO46 = .() ? "-kfreebsd" : (.() ? "" : "-linux");
      String SAO46 = "-gnu";
      if (.()) {
         SAO46 = .() ? "x86_64" : "i386";
      } else if (.()) {
         SAO46 = .() ? "powerpc64" : "powerpc";
      } else if (.()) {
         SAO46 = "arm";
         SAO46 = "-gnueabi";
      } else if (..equals("mips64el")) {
         SAO46 = "-gnuabi64";
      }

      return SAO46 + SAO46 + SAO46;
   }

   public static ArrayList _/* $FF was: */() {
      ArrayList SAO46 = new ArrayList();

      try {
         Process SAO46 = Runtime.getRuntime().exec("/sbin/ldconfig -p");
         BufferedReader SAO46 = new BufferedReader(new InputStreamReader(SAO46.getInputStream()));
         String SAO46 = "";

         while((SAO46 = SAO46.readLine()) != null) {
            int SAO46 = SAO46.indexOf(" => ");
            int SAO46 = SAO46.lastIndexOf(47);
            if (SAO46 != -1 && SAO46 != -1 && SAO46 < SAO46) {
               String SAO46 = SAO46.substring(SAO46 + 4, SAO46);
               if (!SAO46.contains(SAO46)) {
                  SAO46.add(SAO46);
               }
            }
         }

         SAO46.close();
      } catch (Exception var7) {
         ;
      }

      return SAO46;
   }

   public static boolean _/* $FF was: */(String SAO46) {
      return (SAO46);
   }

   static {
      if (Native. == 0) {
         throw new Error("Native library not initialized");
      } else {
         String SAO46 = Native.("jnidispatch");
         if (SAO46 != null) {
            .add(SAO46);
         }

         if (System.getProperty("jna.platform.library.path") == null && !.()) {
            String SAO46 = "";
            String SAO46 = "";
            String SAO46 = "";
            if (.() || .() || .() || .()) {
               SAO46 = (.() ? "/" : "") + Pointer. * 8;
            }

            String[] SAO46 = new String[]{"/usr/lib" + SAO46, "/lib" + SAO46, "/usr/lib", "/lib"};
            if (.() || .() || .()) {
               String SAO46 = ();
               SAO46 = new String[]{"/usr/lib/" + SAO46, "/lib/" + SAO46, "/usr/lib" + SAO46, "/lib" + SAO46, "/usr/lib", "/lib"};
            }

            if (.()) {
               ArrayList SAO46 = ();

               for(int SAO46 = SAO46.length - 1; 0 <= SAO46; --SAO46) {
                  int SAO46 = SAO46.indexOf(SAO46[SAO46]);
                  if (SAO46 != -1) {
                     SAO46.remove(SAO46);
                  }

                  SAO46.add(0, SAO46[SAO46]);
               }

               SAO46 = (String[])SAO46.toArray(new String[SAO46.size()]);
            }

            for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
               File SAO46 = new File(SAO46[SAO46]);
               if (SAO46.exists() && SAO46.isDirectory()) {
                  SAO46 = SAO46 + SAO46 + SAO46[SAO46];
                  SAO46 = File.pathSeparator;
               }
            }

            if (!"".equals(SAO46)) {
               System.setProperty("jna.platform.library.path", SAO46);
            }
         }

         .addAll(("jna.platform.library.path"));
      }
   }
}
