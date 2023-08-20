package ft.sleep.util.http;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import native0.Loader;
import oh.yalan.NativeClass;

@NativeClass
public class WebUtils2 {
   public static int heart$ = 5000;
   public static int mounted$ = 10000;
   public static String levels$ = "localhost";
   public static int poster$ = 1080;

   public static native void init();

   public static native void clear();

   public static native String ___/* $FF was: */(String var0) throws IOException, NoSuchAlgorithmException;

   public static native void _/* $FF was: */(String var0, URL var1) throws IOException;

   public static native byte[] _/* $FF was: */(URL var0) throws IOException;

   public static native String _/* $FF was: */(byte[] var0);

   public static native boolean _/* $FF was: */(String var0, SSLSession var1);

   static {
      Loader.registerNativesForClass(15, WebUtils2.class);
   }

   public static HostnameVerifier _study() {
      return WebUtils2::;
   }
}
