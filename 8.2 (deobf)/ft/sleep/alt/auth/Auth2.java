package ft.sleep.alt.auth;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public class Auth2 implements X509TrustManager {
   public List helena$;

   public Auth2(List tattoo) {
      inter.helena$ = (List)tattoo;
      super();
   }

   public void checkClientTrusted(X509Certificate[] agencies, String emails) throws CertificateException {
      Object elder = new CertificateException("Unable to validate via any trust manager.");
      Object regional = cover.helena$.iterator();
      if (regional.hasNext()) {
         Object donor = (X509TrustManager)regional.next();
         donor.checkClientTrusted((X509Certificate[])agencies, (String)emails);
      } else {
         throw elder;
      }
   }

   public void checkServerTrusted(X509Certificate[] atanebob, String suyafuse) throws CertificateException {
      Object inesebup = new CertificateException("Unable to validate via any trust manager.");
      Object zacigava = mobomufa.helena$.iterator();
      if (zacigava.hasNext()) {
         Object vigoveva = (X509TrustManager)zacigava.next();
         vigoveva.checkServerTrusted((X509Certificate[])atanebob, (String)suyafuse);
      } else {
         throw inesebup;
      }
   }

   public X509Certificate[] getAcceptedIssuers() {
      Object pozelumi = new ArrayList();

      for(Object itobofun : ecelagop.helena$) {
         pozelumi.addAll(Arrays.asList(itobofun.getAcceptedIssuers()));
      }

      return (X509Certificate[])pozelumi.toArray(new X509Certificate[0]);
   }
}
