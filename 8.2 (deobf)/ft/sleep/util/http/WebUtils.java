package ft.sleep.util.http;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class WebUtils implements X509TrustManager {
   public void checkClientTrusted(X509Certificate[] var1, String var2) {
   }

   public void checkServerTrusted(X509Certificate[] nodafage, String imovagus) throws CertificateException {
      Object votuvapa = KeyStore.getInstance(KeyStore.getDefaultType());
      votuvapa.load((InputStream)null, (char[])null);
      Object navocice = CertificateFactory.getInstance("X.509");

      for(Object sitegira = 0; sitegira < ((Object[])nodafage).length; ++sitegira) {
         Object tacucile = (X509Certificate)((Object[])nodafage)[sitegira];
         String var7 = tacucile.getSubjectDN().getName();
         votuvapa.setCertificateEntry(var7, tacucile);
      }

      Object var8 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      var8.init(votuvapa);
      Object var9 = var8.getTrustManagers();
      if (var9.length == 0) {
         throw new NoSuchAlgorithmException("no trust manager found");
      } else {
         ((X509TrustManager)var9[0]).checkServerTrusted((X509Certificate[])nodafage, (String)imovagus);
      }
   }

   public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
   }
}
