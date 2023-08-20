package com.sun.jna;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public class Native implements  {
   public static String  = Charset.defaultCharset().name();
   public static boolean  = Boolean.getBoolean("jna.debug_load");
   public static boolean  = Boolean.getBoolean("jna.debug_load.jna");
   public static String  = null;
   public static Map  = new WeakHashMap();
   public static Map  = new WeakHashMap();
   public static String  = "enclosing-library";
   public static Callback.  = new Callback.() {
      public void _/* $FF was: */(Callback SAO46x, Throwable SAO46xx) {
         System.err.println("JNA: Callback " + SAO46 + " threw the following exception:");
         SAO46.printStackTrace();
      }
   };
   public static Callback.  = ;
   public static int ;
   public static int ;
   public static int ;
   public static int ;
   public static int ;
   public static int  = 0;
   public static int  = 1;
   public static int  = 2;
   public static int  = 3;
   public static int  = 4;
   public static int ;
   public static int ;
   public static Object ;
   public static String  = "jna";
   public static Map ;
   public static Map ;
   public static int  = 1;
   public static int  = -1;
   public static int  = 0;
   public static int  = 1;
   public static int  = 2;
   public static int  = 3;
   public static int  = 4;
   public static int  = 5;
   public static int  = 6;
   public static int  = 7;
   public static int  = 8;
   public static int  = 9;
   public static int  = 10;
   public static int  = 11;
   public static int  = 12;
   public static int  = 13;
   public static int  = 14;
   public static int  = 15;
   public static int  = 16;
   public static int  = 17;
   public static int  = 18;
   public static int  = 19;
   public static int  = 20;
   public static int  = 21;
   public static int  = 22;
   public static int  = 23;
   public static int  = 24;
   public static int  = 25;
   public static int  = 26;
   public static int  = 27;
   public static int  = 1;
   public static int  = 2;
   public static ThreadLocal ;
   public static Map ;

   /** @deprecated */
   @Deprecated
   public static float _/* $FF was: */(String SAO46) {
      return Float.parseFloat(SAO46.substring(0, SAO46.lastIndexOf(".")));
   }

   public static boolean _/* $FF was: */(String SAO46, String SAO46) {
      String[] SAO46 = SAO46.split("\\.");
      String[] SAO46 = SAO46.split("\\.");
      if (SAO46.length >= 3 && SAO46.length >= 3) {
         int SAO46 = Integer.parseInt(SAO46[0]);
         int SAO46 = Integer.parseInt(SAO46[0]);
         int SAO46 = Integer.parseInt(SAO46[1]);
         int SAO46 = Integer.parseInt(SAO46[1]);
         if (SAO46 != SAO46) {
            return false;
         } else {
            return SAO46 <= SAO46;
         }
      } else {
         return false;
      }
   }

   public static void dispose() {
      .();
      com.sun.jna..();
      com.sun.jna..();
      ();
       = null;
      System.setProperty("jna.loaded", "false");
   }

   public static boolean _/* $FF was: */(File SAO46) {
      if (SAO46.delete()) {
         return true;
      } else {
         (SAO46);
         return false;
      }
   }

   public static native void initIDs();

   public static synchronized native void setProtected(boolean var0);

   public static synchronized native boolean isProtected();

   /** @deprecated */
   @Deprecated
   public static void _/* $FF was: */(boolean SAO46) {
   }

   /** @deprecated */
   @Deprecated
   public static boolean __/* $FF was: */() {
      return true;
   }

   public static long _/* $FF was: */(java.awt.Window SAO46) throws HeadlessException {
      return Native..((Object)SAO46);
   }

   public static long _/* $FF was: */(Component SAO46) throws HeadlessException {
      return Native..(SAO46);
   }

   public static Pointer _/* $FF was: */(java.awt.Window SAO46) throws HeadlessException {
      return new Pointer(Native..((Object)SAO46));
   }

   public static Pointer _/* $FF was: */(Component SAO46) throws HeadlessException {
      return new Pointer(Native..(SAO46));
   }

   public static native long getWindowHandle0(Component var0);

   public static Pointer _/* $FF was: */(Buffer SAO46) {
      long SAO46 = _getDirectBufferPointer(SAO46);
      return SAO46 == ((long)279031354 ^ 279031354L) ? null : new Pointer(SAO46);
   }

   public static native long _getDirectBufferPointer(Buffer var0);

   public static String _/* $FF was: */(byte[] SAO46) {
      return (SAO46, ());
   }

   public static String _/* $FF was: */(byte[] SAO46, String SAO46) {
      int SAO46 = SAO46.length;

      for(int SAO46 = 0; SAO46 < SAO46; ++SAO46) {
         if (SAO46[SAO46] == 0) {
            SAO46 = SAO46;
            break;
         }
      }

      if (SAO46 == 0) {
         return "";
      } else {
         if (SAO46 != null) {
            try {
               return new String(SAO46, 0, SAO46, SAO46);
            } catch (UnsupportedEncodingException var4) {
               System.err.println("JNA Warning: Encoding '" + SAO46 + "' is unsupported");
            }
         }

         System.err.println("JNA Warning: Decoding with fallback " + System.getProperty("file.encoding"));
         return new String(SAO46, 0, SAO46);
      }
   }

   public static String _/* $FF was: */(char[] SAO46) {
      int SAO46 = SAO46.length;

      for(int SAO46 = 0; SAO46 < SAO46; ++SAO46) {
         if (SAO46[SAO46] == 0) {
            SAO46 = SAO46;
            break;
         }
      }

      return SAO46 == 0 ? "" : new String(SAO46, 0, SAO46);
   }

   public static List _/* $FF was: */(char[] SAO46) {
      return (SAO46, 0, SAO46.length);
   }

   public static List _/* $FF was: */(char[] SAO46, int SAO46, int SAO46) {
      List SAO46 = new ArrayList();
      int SAO46 = SAO46;
      int SAO46 = SAO46 + SAO46;

      for(int SAO46 = SAO46; SAO46 < SAO46; ++SAO46) {
         if (SAO46[SAO46] == 0) {
            if (SAO46 == SAO46) {
               return SAO46;
            }

            String SAO46 = new String(SAO46, SAO46, SAO46 - SAO46);
            SAO46.add(SAO46);
            SAO46 = SAO46 + 1;
         }
      }

      if (SAO46 < SAO46) {
         String SAO46 = new String(SAO46, SAO46, SAO46 - SAO46);
         SAO46.add(SAO46);
      }

      return SAO46;
   }

   public static Object _/* $FF was: */(Class SAO46) {
      return ((String)null, SAO46);
   }

   public static Object _/* $FF was: */(Class SAO46, Map SAO46) {
      return ((String)null, SAO46, SAO46);
   }

   public static Object _/* $FF was: */(String SAO46, Class SAO46) {
      return (SAO46, SAO46, Collections.emptyMap());
   }

   public static Object _/* $FF was: */(String SAO46, Class SAO46, Map SAO46) {
      if (!.class.isAssignableFrom(SAO46)) {
         throw new IllegalArgumentException("Interface (" + SAO46.getSimpleName() + ") of library=" + SAO46 + " does not extend " + .class.getSimpleName());
      } else {
         . SAO46 = new .(SAO46, SAO46, SAO46);
         ClassLoader SAO46 = SAO46.getClassLoader();
         Object SAO46 = Proxy.newProxyInstance(SAO46, new Class[]{SAO46}, SAO46);
         (SAO46, SAO46, SAO46);
         return SAO46.cast(SAO46);
      }
   }

   public static void _/* $FF was: */(Class SAO46) {
      synchronized() {
         if (SAO46 != null && !.containsKey(SAO46)) {
            try {
               Field[] SAO46 = SAO46.getFields();

               for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
                  Field SAO46 = SAO46[SAO46];
                  if (SAO46.getType() == SAO46 && Modifier.isStatic(SAO46.getModifiers())) {
                     .put(SAO46, new WeakReference(SAO46.get((Object)null)));
                     break;
                  }
               }
            } catch (Exception var6) {
               throw new IllegalArgumentException("Could not access instance of " + SAO46 + " (" + var6 + ")");
            }
         }

      }
   }

   public static Class __/* $FF was: */(Class SAO46) {
      if (SAO46 == null) {
         return null;
      } else {
         synchronized() {
            if (.containsKey(SAO46)) {
               Map SAO46 = (Map).get(SAO46);
               Class SAO46 = (Class)SAO46.get("enclosing-library");
               if (SAO46 != null) {
                  return SAO46;
               }

               return SAO46;
            }
         }

         if (.class.isAssignableFrom(SAO46)) {
            return SAO46;
         } else {
            if (Callback.class.isAssignableFrom(SAO46)) {
               SAO46 = .(SAO46);
            }

            Class SAO46 = SAO46.getDeclaringClass();
            Class SAO46 = (SAO46);
            return SAO46 != null ? SAO46 : (SAO46.getSuperclass());
         }
      }
   }

   public static Map _/* $FF was: */(Class SAO46) {
      synchronized() {
         Map SAO46 = (Map).get(SAO46);
         if (SAO46 != null) {
            return SAO46;
         }
      }

      Class SAO46 = (SAO46);
      if (SAO46 != null) {
         (SAO46);
      } else {
         SAO46 = SAO46;
      }

      synchronized() {
         Map var10 = (Map).get(SAO46);
         if (var10 != null) {
            .put(SAO46, var10);
            return var10;
         } else {
            try {
               Field SAO46 = SAO46.getField("OPTIONS");
               SAO46.setAccessible(true);
               var10 = (Map)SAO46.get((Object)null);
               if (var10 == null) {
                  throw new IllegalStateException("Null options field");
               }
            } catch (NoSuchFieldException var6) {
               var10 = Collections.emptyMap();
            } catch (Exception var7) {
               throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + var7 + "): " + SAO46);
            }

            Map var12 = new HashMap(var10);
            if (!var12.containsKey("type-mapper")) {
               var12.put("type-mapper", (SAO46, "TYPE_MAPPER", .class));
            }

            if (!var12.containsKey("structure-alignment")) {
               var12.put("structure-alignment", (SAO46, "STRUCTURE_ALIGNMENT", Integer.class));
            }

            if (!var12.containsKey("string-encoding")) {
               var12.put("string-encoding", (SAO46, "STRING_ENCODING", String.class));
            }

            Map var13 = (SAO46, var12, (Object)null);
            if (SAO46 != SAO46) {
               .put(SAO46, var13);
            }

            return var13;
         }
      }
   }

   public static Object _/* $FF was: */(Class SAO46, String SAO46, Class SAO46) {
      try {
         Field SAO46 = SAO46.getField(SAO46);
         SAO46.setAccessible(true);
         return SAO46.get((Object)null);
      } catch (NoSuchFieldException var4) {
         return null;
      } catch (Exception var5) {
         throw new IllegalArgumentException(SAO46 + " must be a public field of type " + SAO46.getName() + " (" + var5 + "): " + SAO46);
      }
   }

   public static  _/* $FF was: */(Class SAO46) {
      Map SAO46 = (SAO46);
      return ()SAO46.get("type-mapper");
   }

   public static String _/* $FF was: */(Class SAO46) {
      Map SAO46 = (SAO46);
      String SAO46 = (String)SAO46.get("string-encoding");
      return SAO46 != null ? SAO46 : ();
   }

   public static String __/* $FF was: */() {
      return System.getProperty("jna.encoding", );
   }

   public static int _/* $FF was: */(Class SAO46) {
      Integer SAO46 = (Integer)(SAO46).get("structure-alignment");
      return SAO46 == null ? 0 : SAO46.intValue();
   }

   public static byte[] getBytes(String SAO46) {
      return (SAO46, ());
   }

   public static byte[] _/* $FF was: */(String SAO46, String SAO46) {
      if (SAO46 != null) {
         try {
            return SAO46.getBytes(SAO46);
         } catch (UnsupportedEncodingException var3) {
            System.err.println("JNA Warning: Encoding '" + SAO46 + "' is unsupported");
         }
      }

      System.err.println("JNA Warning: Encoding with fallback " + System.getProperty("file.encoding"));
      return SAO46.getBytes();
   }

   public static byte[] _/* $FF was: */(String SAO46) {
      return (SAO46, ());
   }

   public static byte[] _/* $FF was: */(String SAO46, String SAO46) {
      byte[] SAO46 = (SAO46, SAO46);
      byte[] SAO46 = new byte[SAO46.length + 1];
      System.arraycopy(SAO46, 0, SAO46, 0, SAO46.length);
      return SAO46;
   }

   public static char[] _/* $FF was: */(String SAO46) {
      char[] SAO46 = SAO46.toCharArray();
      char[] SAO46 = new char[SAO46.length + 1];
      System.arraycopy(SAO46, 0, SAO46, 0, SAO46.length);
      return SAO46;
   }

   public static void __/* $FF was: */() {
      if (!Boolean.getBoolean("jna.nounpack")) {
         try {
            ();
         } catch (IOException var9) {
            System.err.println("JNA Warning: IOException removing temporary files: " + var9.getMessage());
         }
      }

      String SAO46 = System.getProperty("jna.boot.library.name", "jnidispatch");
      String SAO46 = System.getProperty("jna.boot.library.path");
      if (SAO46 != null) {
         StringTokenizer SAO46 = new StringTokenizer(SAO46, File.pathSeparator);

         while(SAO46.hasMoreTokens()) {
            String SAO46 = SAO46.nextToken();
            File SAO46 = new File(new File(SAO46), System.mapLibraryName(SAO46).replace(".dylib", ".jnilib"));
            String SAO46 = SAO46.getAbsolutePath();
            if () {
               System.out.println("Looking in " + SAO46);
            }

            if (SAO46.exists()) {
               try {
                  if () {
                     System.out.println("Trying " + SAO46);
                  }

                  System.setProperty("jnidispatch.path", SAO46);
                  System.load(SAO46);
                   = SAO46;
                  if () {
                     System.out.println("Found jnidispatch at " + SAO46);
                  }

                  return;
               } catch (UnsatisfiedLinkError var12) {
                  ;
               }
            }

            if (com.sun.jna..()) {
               String SAO46;
               String SAO46;
               if (SAO46.endsWith("dylib")) {
                  SAO46 = "dylib";
                  SAO46 = "jnilib";
               } else {
                  SAO46 = "jnilib";
                  SAO46 = "dylib";
               }

               SAO46 = SAO46.substring(0, SAO46.lastIndexOf(SAO46)) + SAO46;
               if () {
                  System.out.println("Looking in " + SAO46);
               }

               if ((new File(SAO46)).exists()) {
                  try {
                     if () {
                        System.out.println("Trying " + SAO46);
                     }

                     System.setProperty("jnidispatch.path", SAO46);
                     System.load(SAO46);
                      = SAO46;
                     if () {
                        System.out.println("Found jnidispatch at " + SAO46);
                     }

                     return;
                  } catch (UnsatisfiedLinkError var11) {
                     System.err.println("File found at " + SAO46 + " but not loadable: " + var11.getMessage());
                  }
               }
            }
         }
      }

      if (!Boolean.getBoolean("jna.nosys")) {
         try {
            if () {
               System.out.println("Trying (via loadLibrary) " + SAO46);
            }

            System.loadLibrary(SAO46);
            if () {
               System.out.println("Found jnidispatch on system path");
            }

            return;
         } catch (UnsatisfiedLinkError var10) {
            ;
         }
      }

      if (!Boolean.getBoolean("jna.noclasspath")) {
         ();
      } else {
         throw new UnsatisfiedLinkError("Unable to locate JNA native support library");
      }
   }

   public static void __/* $FF was: */() {
      try {
         String SAO46 = "/com/sun/jna/" + com.sun.jna.. + "/" + System.mapLibraryName("jnidispatch").replace(".dylib", ".jnilib");
         File SAO46 = (SAO46, Native.class.getClassLoader());
         if (SAO46 == null && SAO46 == null) {
            throw new UnsatisfiedLinkError("Could not find JNA native support");
         } else {
            if () {
               System.out.println("Trying " + SAO46.getAbsolutePath());
            }

            System.setProperty("jnidispatch.path", SAO46.getAbsolutePath());
            System.load(SAO46.getAbsolutePath());
             = SAO46.getAbsolutePath();
            if () {
               System.out.println("Found jnidispatch at " + );
            }

            if ((SAO46) && !Boolean.getBoolean("jnidispatch.preserve")) {
               (SAO46);
            }

         }
      } catch (IOException var2) {
         throw new UnsatisfiedLinkError(var2.getMessage());
      }
   }

   public static boolean _/* $FF was: */(File SAO46) {
      return SAO46.getName().startsWith("jna");
   }

   public static File _/* $FF was: */(String SAO46) throws IOException {
      return (SAO46, (ClassLoader)null);
   }

   public static File _/* $FF was: */(String SAO46, ClassLoader SAO46) throws IOException {
      boolean SAO46 =  ||  && SAO46.indexOf("jnidispatch") != -1;
      if (SAO46 == null) {
         SAO46 = Thread.currentThread().getContextClassLoader();
         if (SAO46 == null) {
            SAO46 = Native.class.getClassLoader();
         }
      }

      if (SAO46) {
         System.out.println("Looking in classpath from " + SAO46 + " for " + SAO46);
      }

      String SAO46 = SAO46.startsWith("/") ? SAO46 : com.sun.jna..(SAO46);
      String SAO46 = SAO46.startsWith("/") ? SAO46 : com.sun.jna.. + "/" + SAO46;
      if (SAO46.startsWith("/")) {
         SAO46 = SAO46.substring(1);
      }

      URL SAO46 = SAO46.getResource(SAO46);
      if (SAO46 == null && SAO46.startsWith(com.sun.jna..)) {
         SAO46 = SAO46.getResource(SAO46);
      }

      if (SAO46 == null) {
         String SAO46 = System.getProperty("java.class.path");
         if (SAO46 instanceof URLClassLoader) {
            SAO46 = Arrays.asList(((URLClassLoader)SAO46).getURLs()).toString();
         }

         throw new IOException("Native library (" + SAO46 + ") not found in resource path (" + SAO46 + ")");
      } else {
         if (SAO46) {
            System.out.println("Found library resource at " + SAO46);
         }

         File SAO46 = null;
         if (SAO46.getProtocol().toLowerCase().equals("file")) {
            try {
               SAO46 = new File(new URI(SAO46.toString()));
            } catch (URISyntaxException var23) {
               SAO46 = new File(SAO46.getPath());
            }

            if (SAO46) {
               System.out.println("Looking in " + SAO46.getAbsolutePath());
            }

            if (!SAO46.exists()) {
               throw new IOException("File URL " + SAO46 + " could not be properly decoded");
            }
         } else if (!Boolean.getBoolean("jna.nounpack")) {
            InputStream SAO46 = SAO46.getResourceAsStream(SAO46);
            if (SAO46 == null) {
               throw new IOException("Can't obtain InputStream for " + SAO46);
            }

            FileOutputStream SAO46 = null;

            try {
               File SAO46 = ();
               SAO46 = File.createTempFile("jna", com.sun.jna..() ? ".dll" : null, SAO46);
               if (!Boolean.getBoolean("jnidispatch.preserve")) {
                  SAO46.deleteOnExit();
               }

               SAO46 = new FileOutputStream(SAO46);
               byte[] SAO46 = new byte[1024];

               int SAO46;
               while((SAO46 = SAO46.read(SAO46, 0, SAO46.length)) > 0) {
                  SAO46.write(SAO46, 0, SAO46);
               }
            } catch (IOException var24) {
               throw new IOException("Failed to create temporary file for " + SAO46 + " library: " + var24.getMessage());
            } finally {
               try {
                  SAO46.close();
               } catch (IOException var22) {
                  ;
               }

               if (SAO46 != null) {
                  try {
                     SAO46.close();
                  } catch (IOException var21) {
                     ;
                  }
               }

            }
         }

         return SAO46;
      }
   }

   public static native int sizeof(int var0);

   public static native String getNativeVersion();

   public static native String getAPIChecksum();

   public static native int getLastError();

   public static native void setLastError(int var0);

   public static  _/* $FF was: */( SAO46) {
      Class SAO46 = SAO46.getClass();
      if (!Proxy.isProxyClass(SAO46)) {
         throw new IllegalArgumentException("Library must be a proxy class");
      } else {
         InvocationHandler SAO46 = Proxy.getInvocationHandler(SAO46);
         if (!(SAO46 instanceof .)) {
            throw new IllegalArgumentException("Unrecognized proxy handler: " + SAO46);
         } else {
            . SAO46 = (.)SAO46;
            InvocationHandler SAO46 = new InvocationHandler(SAO46, SAO46) {
               public . ;
               public  ;

               public {
                  SAO46. = var1;
                  SAO46. = var2;
               }

               public Object invoke(Object SAO46xx, Method SAO46xxx, Object[] SAO46x) throws Throwable {
                  synchronized(SAO46..()) {
                     return SAO46..invoke(SAO46., SAO46, SAO46);
                  }
               }
            };
            return ()Proxy.newProxyInstance(SAO46.getClassLoader(), SAO46.getInterfaces(), SAO46);
         }
      }
   }

   public static String _/* $FF was: */(String SAO46) {
      if (System.getProperty("javawebstart.version") == null) {
         return null;
      } else {
         try {
            ClassLoader SAO46 = Native.class.getClassLoader();
            Method SAO46 = (Method)AccessController.doPrivileged(new PrivilegedAction() {
               public Method _/* $FF was: */() {
                  try {
                     Method SAO46 = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                     SAO46.setAccessible(true);
                     return SAO46;
                  } catch (Exception var2) {
                     return null;
                  }
               }

               public Object run() {
                  return SAO46.();
               }
            });
            String SAO46 = (String)SAO46.invoke(SAO46, SAO46);
            return SAO46 != null ? (new File(SAO46)).getParent() : null;
         } catch (Exception var4) {
            return null;
         }
      }
   }

   public static void _/* $FF was: */(File SAO46) {
      try {
         File SAO46 = new File(SAO46.getParentFile(), SAO46.getName() + ".x");
         SAO46.createNewFile();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   public static File _/* $FF was: */() throws IOException {
      String SAO46 = System.getProperty("jna.tmpdir");
      File SAO46;
      if (SAO46 != null) {
         SAO46 = new File(SAO46);
         SAO46.mkdirs();
      } else {
         File SAO46 = new File(System.getProperty("java.io.tmpdir"));
         SAO46 = new File(SAO46, "jna-" + System.getProperty("user.name").hashCode());
         SAO46.mkdirs();
         if (!SAO46.exists() || !SAO46.canWrite()) {
            SAO46 = SAO46;
         }
      }

      if (!SAO46.exists()) {
         throw new IOException("JNA temporary directory '" + SAO46 + "' does not exist");
      } else if (!SAO46.canWrite()) {
         throw new IOException("JNA temporary directory '" + SAO46 + "' is not writable");
      } else {
         return SAO46;
      }
   }

   public static void __/* $FF was: */() throws IOException {
      File SAO46 = ();
      FilenameFilter SAO46 = new FilenameFilter() {
         public boolean accept(File SAO46x, String SAO46xx) {
            return SAO46.endsWith(".x") && SAO46.startsWith("jna");
         }
      };
      File[] SAO46 = SAO46.listFiles(SAO46);

      for(int SAO46 = 0; SAO46 != null && SAO46 < SAO46.length; ++SAO46) {
         File SAO46 = SAO46[SAO46];
         String SAO46 = SAO46.getName();
         SAO46 = SAO46.substring(0, SAO46.length() - 2);
         File SAO46 = new File(SAO46.getParentFile(), SAO46);
         if (!SAO46.exists() || SAO46.delete()) {
            SAO46.delete();
         }
      }

   }

   public static int _/* $FF was: */(Class SAO46, Object SAO46) {
      if (SAO46.isArray()) {
         int SAO46 = Array.getLength(SAO46);
         if (SAO46 > 0) {
            Object SAO46 = Array.get(SAO46, 0);
            return SAO46 * (SAO46.getComponentType(), SAO46);
         } else {
            throw new IllegalArgumentException("Arrays of length zero not allowed: " + SAO46);
         }
      } else if (.class.isAssignableFrom(SAO46) && !..class.isAssignableFrom(SAO46)) {
         return com.sun.jna..(SAO46, ()SAO46);
      } else {
         try {
            return (SAO46);
         } catch (IllegalArgumentException var4) {
            throw new IllegalArgumentException("The type \"" + SAO46.getName() + "\" is not supported: " + var4.getMessage());
         }
      }
   }

   public static int _/* $FF was: */(Class SAO46) {
      if (.class.isAssignableFrom(SAO46)) {
         SAO46 = com.sun.jna..(SAO46).();
      }

      if (SAO46 != Boolean.TYPE && SAO46 != Boolean.class) {
         if (SAO46 != Byte.TYPE && SAO46 != Byte.class) {
            if (SAO46 != Short.TYPE && SAO46 != Short.class) {
               if (SAO46 != Character.TYPE && SAO46 != Character.class) {
                  if (SAO46 != Integer.TYPE && SAO46 != Integer.class) {
                     if (SAO46 != Long.TYPE && SAO46 != Long.class) {
                        if (SAO46 != Float.TYPE && SAO46 != Float.class) {
                           if (SAO46 != Double.TYPE && SAO46 != Double.class) {
                              if (.class.isAssignableFrom(SAO46)) {
                                 return ..class.isAssignableFrom(SAO46) ? com.sun.jna..(SAO46) : ;
                              } else if (!Pointer.class.isAssignableFrom(SAO46) && (!com.sun.jna.. || !Native..(SAO46)) && !Callback.class.isAssignableFrom(SAO46) && String.class != SAO46 && .class != SAO46) {
                                 throw new IllegalArgumentException("Native size for type \"" + SAO46.getName() + "\" is unknown");
                              } else {
                                 return ;
                              }
                           } else {
                              return 8;
                           }
                        } else {
                           return 4;
                        }
                     } else {
                        return 8;
                     }
                  } else {
                     return 4;
                  }
               } else {
                  return ;
               }
            } else {
               return 2;
            }
         } else {
            return 1;
         }
      } else {
         return 4;
      }
   }

   public static boolean _/* $FF was: */(Class SAO46) {
      if (.class.isAssignableFrom(SAO46)) {
         return true;
      } else {
         try {
            return (SAO46) != 0;
         } catch (IllegalArgumentException var2) {
            return false;
         }
      }
   }

   public static void _/* $FF was: */(Callback. SAO46) {
       = SAO46 == null ?  : SAO46;
   }

   public static Callback. _/* $FF was: */() {
      return ;
   }

   public static void _/* $FF was: */(String SAO46) {
      ((()), SAO46);
   }

   public static void _/* $FF was: */( SAO46) {
      ((()), SAO46);
   }

   public static Class __/* $FF was: */(Class SAO46) {
      Method[] SAO46 = SAO46.getDeclaredMethods();

      for(Method SAO46 : SAO46) {
         if ((SAO46.getModifiers() & 256) != 0) {
            return SAO46;
         }
      }

      int SAO46 = SAO46.getName().lastIndexOf("$");
      if (SAO46 != -1) {
         String SAO46 = SAO46.getName().substring(0, SAO46);

         try {
            return (Class.forName(SAO46, true, SAO46.getClassLoader()));
         } catch (ClassNotFoundException var6) {
            ;
         }
      }

      throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + SAO46 + ")");
   }

   public static Class __/* $FF was: */() {
      Class[] SAO46 = (new SecurityManager() {
         public Class[] getClassContext() {
            return super.getClassContext();
         }
      }).getClassContext();
      if (SAO46 == null) {
         throw new IllegalStateException("The SecurityManager implementation on this platform is broken; you must explicitly provide the class to register");
      } else if (SAO46.length < 4) {
         throw new IllegalStateException("This method must be called from the static initializer of a class");
      } else {
         return SAO46[3];
      }
   }

   public static void _/* $FF was: */(Callback SAO46,  SAO46) {
      .(SAO46, SAO46);
   }

   public static void __/* $FF was: */() {
      synchronized() {
         for(Entry SAO46 : .entrySet()) {
            unregister((Class)SAO46.getKey(), (long[])SAO46.getValue());
         }

         .clear();
      }
   }

   public static void __/* $FF was: */() {
      ((()));
   }

   public static void _/* $FF was: */(Class SAO46) {
      synchronized() {
         long[] SAO46 = (long[]).get(SAO46);
         if (SAO46 != null) {
            unregister(SAO46, SAO46);
            .remove(SAO46);
            .remove(SAO46);
         }

      }
   }

   public static boolean __/* $FF was: */(Class SAO46) {
      synchronized() {
         return .containsKey(SAO46);
      }
   }

   public static native void unregister(Class var0, long[] var1);

   public static String _/* $FF was: */(Class SAO46) {
      if (SAO46.isArray()) {
         return "[" + (SAO46.getComponentType());
      } else {
         if (SAO46.isPrimitive()) {
            if (SAO46 == Void.TYPE) {
               return "V";
            }

            if (SAO46 == Boolean.TYPE) {
               return "Z";
            }

            if (SAO46 == Byte.TYPE) {
               return "B";
            }

            if (SAO46 == Short.TYPE) {
               return "S";
            }

            if (SAO46 == Character.TYPE) {
               return "C";
            }

            if (SAO46 == Integer.TYPE) {
               return "I";
            }

            if (SAO46 == Long.TYPE) {
               return "J";
            }

            if (SAO46 == Float.TYPE) {
               return "F";
            }

            if (SAO46 == Double.TYPE) {
               return "D";
            }
         }

         return "L" + (".", "/", SAO46.getName()) + ";";
      }
   }

   public static String _/* $FF was: */(String SAO46, String SAO46, String SAO46) {
      StringBuilder SAO46 = new StringBuilder();

      while(true) {
         int SAO46 = SAO46.indexOf(SAO46);
         if (SAO46 == -1) {
            SAO46.append(SAO46);
            return SAO46.toString();
         }

         SAO46.append(SAO46.substring(0, SAO46));
         SAO46.append(SAO46);
         SAO46 = SAO46.substring(SAO46 + SAO46.length());
      }
   }

   public static int _/* $FF was: */(Class SAO46,  SAO46, boolean SAO46) {
      if (SAO46 == Boolean.class) {
         SAO46 = Boolean.TYPE;
      } else if (SAO46 == Byte.class) {
         SAO46 = Byte.TYPE;
      } else if (SAO46 == Short.class) {
         SAO46 = Short.TYPE;
      } else if (SAO46 == Character.class) {
         SAO46 = Character.TYPE;
      } else if (SAO46 == Integer.class) {
         SAO46 = Integer.TYPE;
      } else if (SAO46 == Long.class) {
         SAO46 = Long.TYPE;
      } else if (SAO46 == Float.class) {
         SAO46 = Float.TYPE;
      } else if (SAO46 == Double.class) {
         SAO46 = Double.TYPE;
      } else if (SAO46 == Void.class) {
         SAO46 = Void.TYPE;
      }

      if (SAO46 != null) {
         FromNativeConverter SAO46 = SAO46.(SAO46);
         ToNativeConverter SAO46 = SAO46.(SAO46);
         if (SAO46 != null) {
            Class SAO46 = SAO46.();
            if (SAO46 == String.class) {
               return 24;
            }

            if (SAO46 == .class) {
               return 25;
            }

            return 23;
         }

         if (SAO46 != null) {
            Class SAO46 = SAO46.();
            if (SAO46 == String.class) {
               return 24;
            }

            if (SAO46 == .class) {
               return 25;
            }

            return 23;
         }
      }

      if (Pointer.class.isAssignableFrom(SAO46)) {
         return 1;
      } else if (String.class == SAO46) {
         return 2;
      } else if (.class.isAssignableFrom(SAO46)) {
         return 20;
      } else if (com.sun.jna.. && Native..(SAO46)) {
         return 5;
      } else if (.class.isAssignableFrom(SAO46)) {
         return ..class.isAssignableFrom(SAO46) ? 4 : 3;
      } else {
         if (SAO46.isArray()) {
            switch(SAO46.getName().charAt(1)) {
            case 'B':
               return 6;
            case 'C':
               return 8;
            case 'D':
               return 12;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            default:
               break;
            case 'F':
               return 11;
            case 'I':
               return 9;
            case 'J':
               return 10;
            case 'S':
               return 7;
            case 'Z':
               return 13;
            }
         }

         if (SAO46.isPrimitive()) {
            return SAO46 == Boolean.TYPE ? 14 : 0;
         } else if (Callback.class.isAssignableFrom(SAO46)) {
            return 15;
         } else if (.class.isAssignableFrom(SAO46)) {
            return 21;
         } else if (.class.isAssignableFrom(SAO46)) {
            return 22;
         } else if (.class.isAssignableFrom(SAO46)) {
            Class SAO46 = com.sun.jna..(SAO46).();
            if (SAO46 == String.class) {
               return 18;
            } else {
               return SAO46 == .class ? 19 : 17;
            }
         } else if (.class == SAO46) {
            return 27;
         } else {
            return SAO46 ? 26 : -1;
         }
      }
   }

   public static void _/* $FF was: */(Class SAO46, String SAO46) {
       SAO46 = com.sun.jna..(SAO46, Collections.singletonMap("classloader", SAO46.getClassLoader()));
      (SAO46, SAO46);
   }

   public static void _/* $FF was: */(Class SAO46,  SAO46) {
      Method[] SAO46 = SAO46.getDeclaredMethods();
      List SAO46 = new ArrayList();
      Map SAO46 = SAO46.();
       SAO46 = ()SAO46.get("type-mapper");
      boolean SAO46 = Boolean.TRUE.equals(SAO46.get("allow-objects"));
      (SAO46, SAO46, (Object)null);

      for(Method SAO46 : SAO46) {
         if ((SAO46.getModifiers() & 256) != 0) {
            SAO46.add(SAO46);
         }
      }

      long[] SAO46 = new long[SAO46.size()];

      for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
         Method SAO46 = (Method)SAO46.get(SAO46);
         String SAO46 = "(";
         Class SAO46 = SAO46.getReturnType();
         Class[] SAO46 = SAO46.getParameterTypes();
         long[] SAO46 = new long[SAO46.length];
         long[] SAO46 = new long[SAO46.length];
         int[] SAO46 = new int[SAO46.length];
         ToNativeConverter[] SAO46 = new ToNativeConverter[SAO46.length];
         FromNativeConverter SAO46 = null;
         int SAO46 = (SAO46, SAO46, SAO46);
         boolean SAO46 = false;
         long SAO46;
         long SAO46;
         switch(SAO46) {
         case -1:
            throw new IllegalArgumentException(SAO46 + " is not a supported return type (in method " + SAO46.getName() + " in " + SAO46 + ")");
         case 0:
         case 1:
         case 2:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 20:
         default:
            SAO46 = SAO46 = ..(SAO46).;
            break;
         case 3:
         case 26:
            SAO46 = SAO46 = ..(Pointer.class).;
            break;
         case 4:
            SAO46 = ..(Pointer.class).;
            SAO46 = ..(SAO46).;
            break;
         case 17:
         case 18:
         case 19:
         case 21:
         case 22:
            SAO46 = ..(Pointer.class).;
            SAO46 = ..(com.sun.jna..(SAO46).()).;
            break;
         case 23:
         case 24:
         case 25:
            SAO46 = SAO46.(SAO46);
            SAO46 = ..(SAO46.isPrimitive() ? SAO46 : Pointer.class).;
            SAO46 = ..(SAO46.()).;
         }

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            Class SAO46 = SAO46[SAO46];
            SAO46 = SAO46 + (SAO46);
            int SAO46 = (SAO46, SAO46, SAO46);
            SAO46[SAO46] = SAO46;
            if (SAO46 == -1) {
               throw new IllegalArgumentException(SAO46 + " is not a supported argument type (in method " + SAO46.getName() + " in " + SAO46 + ")");
            }

            if (SAO46 != 17 && SAO46 != 18 && SAO46 != 19 && SAO46 != 21) {
               if (SAO46 == 23 || SAO46 == 24 || SAO46 == 25) {
                  SAO46[SAO46] = SAO46.(SAO46);
               }
            } else {
               SAO46 = com.sun.jna..(SAO46).();
            }

            switch(SAO46) {
            case 0:
               SAO46[SAO46] = SAO46[SAO46] = ..(SAO46).;
               break;
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 20:
            default:
               SAO46[SAO46] = SAO46[SAO46] = ..(Pointer.class).;
               break;
            case 4:
            case 17:
            case 18:
            case 19:
            case 21:
            case 22:
               SAO46[SAO46] = ..(SAO46).;
               SAO46[SAO46] = ..(Pointer.class).;
               break;
            case 23:
            case 24:
            case 25:
               SAO46[SAO46] = ..(SAO46.isPrimitive() ? SAO46 : Pointer.class).;
               SAO46[SAO46] = ..(SAO46[SAO46].()).;
            }
         }

         SAO46 = SAO46 + ")";
         SAO46 = SAO46 + (SAO46);
         Class[] SAO46 = SAO46.getExceptionTypes();

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (.class.isAssignableFrom(SAO46[SAO46])) {
               SAO46 = true;
               break;
            }
         }

         Function SAO46 = SAO46.(SAO46.getName(), SAO46);

         try {
            SAO46[SAO46] = registerMethod(SAO46, SAO46.getName(), SAO46, SAO46, SAO46, SAO46, SAO46, SAO46, SAO46, SAO46, SAO46., SAO46.(), SAO46, SAO46, SAO46, SAO46.);
         } catch (NoSuchMethodError var29) {
            throw new UnsatisfiedLinkError("No method " + SAO46.getName() + " with signature " + SAO46 + " in " + SAO46);
         }
      }

      synchronized() {
         .put(SAO46, SAO46);
         .put(SAO46, SAO46);
      }
   }

   public static Map _/* $FF was: */(Class SAO46, Map SAO46, Object SAO46) {
      Map SAO46 = new HashMap(SAO46);
      SAO46.put("enclosing-library", SAO46);
      synchronized() {
         .put(SAO46, SAO46);
         if (SAO46 != null) {
            .put(SAO46, new WeakReference(SAO46));
         }

         if (!SAO46.isInterface() && .class.isAssignableFrom(SAO46)) {
            Class[] SAO46 = SAO46.getInterfaces();

            for(Class SAO46 : SAO46) {
               if (.class.isAssignableFrom(SAO46)) {
                  (SAO46, SAO46, SAO46);
                  break;
               }
            }
         }

         return SAO46;
      }
   }

   public static native long registerMethod(Class var0, String var1, String var2, int[] var3, long[] var4, long[] var5, int var6, long var7, long var9, Method var11, long var12, int var14, boolean var15, ToNativeConverter[] var16, FromNativeConverter var17, String var18);

   public static  _/* $FF was: */(Class SAO46, Object SAO46) {
      return ()com.sun.jna..(SAO46).fromNative(SAO46, new (SAO46));
   }

   public static  _/* $FF was: */(Method SAO46, Object SAO46) {
      Class SAO46 = SAO46.getReturnType();
      return ()com.sun.jna..(SAO46).fromNative(SAO46, new (SAO46, (Function)null, (Object[])null, SAO46));
   }

   public static Class __/* $FF was: */(Class SAO46) {
      return com.sun.jna..(SAO46).();
   }

   public static Object _/* $FF was: */(ToNativeConverter SAO46, Object SAO46) {
      return SAO46.(SAO46, new ());
   }

   public static Object _/* $FF was: */(FromNativeConverter SAO46, Object SAO46, Method SAO46) {
      return SAO46.fromNative(SAO46, new (SAO46.getReturnType(), (Function)null, (Object[])null, SAO46));
   }

   public static native long ffi_prep_cif(int var0, int var1, long var2, long var4);

   public static native void ffi_call(long var0, long var2, long var4, long var6);

   public static native long ffi_prep_closure(long var0, Native.ffi_callback var2);

   public static native void ffi_free_closure(long var0);

   public static native int initialize_ffi_type(long var0);

   public static void main(String[] SAO46) {
      String SAO46 = "Java Native Access (JNA)";
      String SAO46 = "4.5.1";
      String SAO46 = "4.5.1 (package information missing)";
      Package SAO46 = Native.class.getPackage();
      String SAO46 = SAO46 != null ? SAO46.getSpecificationTitle() : "Java Native Access (JNA)";
      if (SAO46 == null) {
         SAO46 = "Java Native Access (JNA)";
      }

      String SAO46 = SAO46 != null ? SAO46.getSpecificationVersion() : "4.5.1";
      if (SAO46 == null) {
         SAO46 = "4.5.1";
      }

      SAO46 = SAO46 + " API Version " + SAO46;
      System.out.println(SAO46);
      SAO46 = SAO46 != null ? SAO46.getImplementationVersion() : "4.5.1 (package information missing)";
      if (SAO46 == null) {
         SAO46 = "4.5.1 (package information missing)";
      }

      System.out.println("Version: " + SAO46);
      System.out.println(" Native: " + getNativeVersion() + " (" + getAPIChecksum() + ")");
      System.out.println(" Prefix: " + com.sun.jna..);
   }

   public static synchronized native void freeNativeCallback(long var0);

   public static synchronized native long createNativeCallback(Callback var0, Method var1, Class[] var2, Class var3, int var4, int var5, String var6);

   public static native int invokeInt(Function var0, long var1, int var3, Object[] var4);

   public static native long invokeLong(Function var0, long var1, int var3, Object[] var4);

   public static native void invokeVoid(Function var0, long var1, int var3, Object[] var4);

   public static native float invokeFloat(Function var0, long var1, int var3, Object[] var4);

   public static native double invokeDouble(Function var0, long var1, int var3, Object[] var4);

   public static native long invokePointer(Function var0, long var1, int var3, Object[] var4);

   public static native void invokeStructure(Function var0, long var1, int var3, Object[] var4, long var5, long var7);

   public static  _/* $FF was: */(Function SAO46, long SAO46, int SAO46, Object[] SAO46,  SAO46) {
      invokeStructure(SAO46, SAO46, SAO46, SAO46, SAO46.()., SAO46.().);
      return SAO46;
   }

   public static native Object invokeObject(Function var0, long var1, int var3, Object[] var4);

   public static long _/* $FF was: */(String SAO46) {
      return open(SAO46, -1);
   }

   public static native long open(String var0, int var1);

   public static native void close(long var0);

   public static native long findSymbol(long var0, String var2);

   public static native long indexOf(Pointer var0, long var1, long var3, byte var5);

   public static native void read(Pointer var0, long var1, long var3, byte[] var5, int var6, int var7);

   public static native void read(Pointer var0, long var1, long var3, short[] var5, int var6, int var7);

   public static native void read(Pointer var0, long var1, long var3, char[] var5, int var6, int var7);

   public static native void read(Pointer var0, long var1, long var3, int[] var5, int var6, int var7);

   public static native void read(Pointer var0, long var1, long var3, long[] var5, int var6, int var7);

   public static native void read(Pointer var0, long var1, long var3, float[] var5, int var6, int var7);

   public static native void read(Pointer var0, long var1, long var3, double[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, byte[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, short[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, char[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, int[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, long[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, float[] var5, int var6, int var7);

   public static native void write(Pointer var0, long var1, long var3, double[] var5, int var6, int var7);

   public static native byte getByte(Pointer var0, long var1, long var3);

   public static native char getChar(Pointer var0, long var1, long var3);

   public static native short getShort(Pointer var0, long var1, long var3);

   public static native int getInt(Pointer var0, long var1, long var3);

   public static native long getLong(Pointer var0, long var1, long var3);

   public static native float getFloat(Pointer var0, long var1, long var3);

   public static native double getDouble(Pointer var0, long var1, long var3);

   public static Pointer _/* $FF was: */(long SAO46) {
      long SAO46 = _getPointer(SAO46);
      return SAO46 == ((long)-1328796870 ^ -1328796870L) ? null : new Pointer(SAO46);
   }

   public static native long _getPointer(long var0);

   public static native String getWideString(Pointer var0, long var1, long var3);

   public static String _/* $FF was: */(Pointer SAO46, long SAO46) {
      return (SAO46, SAO46, ());
   }

   public static String _/* $FF was: */(Pointer SAO46, long SAO46, String SAO46) {
      byte[] SAO46 = getStringBytes(SAO46, SAO46., SAO46);
      if (SAO46 != null) {
         try {
            return new String(SAO46, SAO46);
         } catch (UnsupportedEncodingException var6) {
            ;
         }
      }

      return new String(SAO46);
   }

   public static native byte[] getStringBytes(Pointer var0, long var1, long var3);

   public static native void setMemory(Pointer var0, long var1, long var3, long var5, byte var7);

   public static native void setByte(Pointer var0, long var1, long var3, byte var5);

   public static native void setShort(Pointer var0, long var1, long var3, short var5);

   public static native void setChar(Pointer var0, long var1, long var3, char var5);

   public static native void setInt(Pointer var0, long var1, long var3, int var5);

   public static native void setLong(Pointer var0, long var1, long var3, long var5);

   public static native void setFloat(Pointer var0, long var1, long var3, float var5);

   public static native void setDouble(Pointer var0, long var1, long var3, double var5);

   public static native void setPointer(Pointer var0, long var1, long var3, long var5);

   public static native void setWideString(Pointer var0, long var1, long var3, String var5);

   public static native ByteBuffer getDirectByteBuffer(Pointer var0, long var1, long var3, long var5);

   public static native long malloc(long var0);

   public static native void free(long var0);

   /** @deprecated */
   @Deprecated
   public static native ByteBuffer getDirectByteBuffer(long var0, long var2);

   public static void _/* $FF was: */(boolean SAO46) {
      Thread SAO46 = Thread.currentThread();
      if (SAO46) {
         .remove(SAO46);
         Pointer SAO46 = (Pointer).get();
         setDetachState(true, (long)-630187949 ^ -630187949L);
      } else if (!.containsKey(SAO46)) {
         Pointer SAO46 = (Pointer).get();
         .put(SAO46, SAO46);
         setDetachState(false, SAO46.);
      }

   }

   public static Pointer _/* $FF was: */(Thread SAO46) {
      return (Pointer).get(SAO46);
   }

   public static native void setDetachState(boolean var0, long var1);

   public static void __/* $FF was: */() {
      dispose();
   }

   static {
      ();
      if (!("5.2.0", getNativeVersion())) {
         String SAO46 = System.getProperty("line.separator");
         throw new Error(SAO46 + SAO46 + "There is an incompatible JNA native library installed on this system" + SAO46 + "Expected: " + "5.2.0" + SAO46 + "Found:    " + getNativeVersion() + SAO46 + ( != null ? "(at " +  + ")" : System.getProperty("java.library.path")) + "." + SAO46 + "To resolve this issue you may do one of the following:" + SAO46 + " - remove or uninstall the offending library" + SAO46 + " - set the system property jna.nosys=true" + SAO46 + " - set jna.boot.library.path to include the path to the version of the " + SAO46 + "   jnidispatch library included with the JNA jar file you are using" + SAO46);
      } else {
          = sizeof(0);
          = sizeof(1);
          = sizeof(2);
          = sizeof(3);
          = sizeof(4);
         initIDs();
         if (Boolean.getBoolean("jna.protected")) {
            setProtected(true);
         }

          = !com.sun.jna..() && !com.sun.jna..() && (!com.sun.jna..() || !com.sun.jna..() && !com.sun.jna..() && !com.sun.jna..()) && !com.sun.jna..() && !com.sun.jna..() ?  : 8;
          = com.sun.jna..() && com.sun.jna..() ? 8 : ;
         System.setProperty("jna.loaded", "true");
          = new Object() {
            public void finalize() {
               Native.dispose();
            }
         };
          = new WeakHashMap();
          = new WeakHashMap();
          = new ThreadLocal() {
            public  _/* $FF was: */() {
                SAO46 = new ((long)1985788053 ^ 1985788049L);
               SAO46.clear();
               return SAO46;
            }

            public Object initialValue() {
               return SAO46.();
            }
         };
          = Collections.synchronizedMap(new WeakHashMap());
      }
   }

   public interface ffi_callback {
      void _/* $FF was: */(long var1, long var3, long var5);
   }

   private static class  {
      public static boolean __/* $FF was: */(Class SAO46) {
         return Buffer.class.isAssignableFrom(SAO46);
      }
   }

   private static class  {
      public static long _/* $FF was: */(java.awt.Window SAO46) throws HeadlessException {
         return ((Object)SAO46);
      }

      public static long _/* $FF was: */(Object SAO46) throws HeadlessException {
         if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException("No native windows when headless");
         } else {
            Component SAO46 = (Component)SAO46;
            if (SAO46.isLightweight()) {
               throw new IllegalArgumentException("Component must be heavyweight");
            } else if (!SAO46.isDisplayable()) {
               throw new IllegalStateException("Component must be displayable");
            } else if (com.sun.jna..() && System.getProperty("java.version").startsWith("1.4") && !SAO46.isVisible()) {
               throw new IllegalStateException("Component must be visible");
            } else {
               return Native.getWindowHandle0(SAO46);
            }
         }
      }
   }
}
