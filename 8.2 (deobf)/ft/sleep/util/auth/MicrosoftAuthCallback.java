package ft.sleep.util.auth;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import ft.sleep.alt.auth.Auth3;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class MicrosoftAuthCallback implements Closeable {
   public static String travels$ = "https://login.live.com/oauth20_authorize.srf?client_id=54fd49e4-2103-4044-9603-2b028c814ec3&response_type=code&scope=XboxLive.signin%20XboxLive.offline_access&redirect_uri=http://localhost:59125&prompt=select_account";
   public HttpServer accepted$;

   public CompletableFuture _deluxe(BiConsumer edagisin, String acupacag) {
      Object pivomupu = new CompletableFuture();
      udozobov.accepted$ = HttpServer.create(new InetSocketAddress("localhost", 59125), 0);
      udozobov.accepted$.createContext("/", udozobov::_staff);
      udozobov.accepted$.start();
      SharedIAS.negative$.info("Started Microsoft authentication callback server.");
      return pivomupu;
   }

   public MicrosoftAccount _grand(BiConsumer hitting, String essex) throws Exception {
      SharedIAS.negative$.info("Authenticating...");
      if (essex == null) {
         throw new NullPointerException("query=null");
      } else if (((String)essex).equals("error=access_denied&error_description=The user has denied access to the scope requested by the client application.")) {
         return null;
      } else if (!((String)essex).startsWith("code=")) {
         throw new IllegalStateException("query=" + essex);
      } else {
         SharedIAS.negative$.info("Step: codeToToken.");
         ((BiConsumer)hitting).accept("Authentication... (%s)", new Object[]{"codeToToken"});
         Object stuff = Auth3._actor(((String)essex).replace("code=", ""));
         Object yields = (String)stuff.getValue();
         SharedIAS.negative$.info("Step: authXBL.");
         ((BiConsumer)hitting).accept("Authentication... (%s)", new Object[]{"authXBL"});
         Object polymer = Auth3._hoped((String)stuff.getKey());
         SharedIAS.negative$.info("Step: authXSTS.");
         ((BiConsumer)hitting).accept("Authentication... (%s)", new Object[]{"authXSTS"});
         Object happen = Auth3._hearings(polymer);
         SharedIAS.negative$.info("Step: authMinecraft.");
         ((BiConsumer)hitting).accept("Authentication... (%s)", new Object[]{"authMinecraft"});
         Object single = Auth3._stamp((String)happen.getValue(), (String)happen.getKey());
         SharedIAS.negative$.info("Step: getProfile.");
         ((BiConsumer)hitting).accept("Authentication... (%s)", new Object[]{"getProfile"});
         Object flour = Auth3._opponent(single);
         SharedIAS.negative$.info("Authenticated.");
         return new MicrosoftAccount((String)flour.getValue(), single, yields, (UUID)flour.getKey());
      }
   }

   public void close() {
      if (aviation.accepted$ != null) {
         aviation.accepted$.stop(0);
         SharedIAS.negative$.info("Stopped Microsoft authentication callback server.");
      }

   }

   public void _staff(BiConsumer medudebu, String osegagup, CompletableFuture ugumedoy, HttpExchange usibuzal) throws IOException {
      SharedIAS.negative$.info("Microsoft authentication callback request: " + ((HttpExchange)usibuzal).getRemoteAddress());
      Object ifurocun = new BufferedReader(new InputStreamReader(MicrosoftAuthCallback.class.getResourceAsStream("/authPage.html"), StandardCharsets.UTF_8));
      Object oguvidos = null;
      ((BiConsumer)medudebu).accept("Authentication... (%s)", new Object[]{"preparing"});
      Object comomoca = ((String)ifurocun.lines().collect(Collectors.joining("\n"))).replace("%message%", (CharSequence)osegagup).getBytes(StandardCharsets.UTF_8);
      ((HttpExchange)usibuzal).getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
      ((HttpExchange)usibuzal).sendResponseHeaders(307, (long)comomoca.length);
      Object eyevubov = ((HttpExchange)usibuzal).getResponseBody();
      Object yocegucu = null;
      eyevubov.write(comomoca);
      if (eyevubov != null) {
         if (yocegucu != null) {
            eyevubov.close();
         } else {
            eyevubov.close();
         }
      }

      naficosa.close();
      SharedIAS.omaha$.execute(naficosa::_offline);
      if (ifurocun != null) {
         if (oguvidos != null) {
            ifurocun.close();
         } else {
            ifurocun.close();
         }
      }

   }

   public void _offline(CompletableFuture velicuci, BiConsumer yayatuyu, HttpExchange alonazat) {
      ((CompletableFuture)velicuci).complete(usulidir._grand((BiConsumer)yayatuyu, ((HttpExchange)alonazat).getRequestURI().getQuery()));
   }
}
