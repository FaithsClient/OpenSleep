package ft.sleep.alt.auth;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class Auth3 {
   public static String recover$ = "54fd49e4-2103-4044-9603-2b028c814ec3";
   public static String internet$ = "http://localhost:59125";
   public static boolean conclude$ = Boolean.getBoolean("ias.blindSSL");
   public static boolean fingers$ = Boolean.getBoolean("ias.noCustomSSL");
   public static SSLContext ebony$;

   public static Entry _actor(String efuvivoc) throws Exception {
      Object ulevupef = (HttpsURLConnection)(new URL("https://login.live.com/oauth20_token.srf")).openConnection();
      if (ebony$ != null) {
         ulevupef.setSSLSocketFactory(ebony$.getSocketFactory());
      }

      ulevupef.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      ulevupef.setRequestMethod("POST");
      ulevupef.setConnectTimeout(15000);
      ulevupef.setReadTimeout(15000);
      ulevupef.setDoOutput(true);
      Object rateziti = ulevupef.getOutputStream();
      Object odalizuv = null;
      rateziti.write(("client_id=" + URLEncoder.encode("54fd49e4-2103-4044-9603-2b028c814ec3", "UTF-8") + "&code=" + URLEncoder.encode((String)efuvivoc, "UTF-8") + "&grant_type=authorization_code&redirect_uri=" + URLEncoder.encode("http://localhost:59125", "UTF-8") + "&scope=XboxLive.signin%20XboxLive.offline_access").getBytes(StandardCharsets.UTF_8));
      if (ulevupef.getResponseCode() >= 200 && ulevupef.getResponseCode() <= 299) {
         Object var13 = new BufferedReader(new InputStreamReader(ulevupef.getInputStream(), StandardCharsets.UTF_8));
         Object var14 = null;
         Object cudicabi = (JsonObject) SharedIAS.nobody$.fromJson((String)var13.lines().collect(Collectors.joining("\n")), JsonObject.class);
         Object ibumedeg = new SimpleImmutableEntry(cudicabi.get("access_token").getAsString(), cudicabi.get("refresh_token").getAsString());
         if (var13 != null) {
            if (var14 != null) {
               var13.close();
            } else {
               var13.close();
            }
         }

         if (rateziti != null) {
            if (odalizuv != null) {
               rateziti.close();
            } else {
               rateziti.close();
            }
         }

         return ibumedeg;
      } else {
         Object marimotu = new BufferedReader(new InputStreamReader(ulevupef.getErrorStream(), StandardCharsets.UTF_8));
         Object yusiyese = null;
         throw new IllegalArgumentException("codeToToken response: " + ulevupef.getResponseCode() + ", data: " + (String)marimotu.lines().collect(Collectors.joining("\n")));
      }
   }

   public static Entry _resist(String piano) throws Exception {
      Object governor = (HttpsURLConnection)(new URL("https://login.live.com/oauth20_token.srf")).openConnection();
      if (ebony$ != null) {
         governor.setSSLSocketFactory(ebony$.getSocketFactory());
      }

      governor.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      governor.setRequestMethod("POST");
      governor.setConnectTimeout(15000);
      governor.setReadTimeout(15000);
      governor.setDoOutput(true);
      Object blocked = governor.getOutputStream();
      Object movie = null;
      blocked.write(("client_id=" + URLEncoder.encode("54fd49e4-2103-4044-9603-2b028c814ec3", "UTF-8") + "&refresh_token=" + URLEncoder.encode((String)piano, "UTF-8") + "&grant_type=refresh_token&redirect_uri=" + URLEncoder.encode("http://localhost:59125", "UTF-8") + "&scope=XboxLive.signin%20XboxLive.offline_access").getBytes(StandardCharsets.UTF_8));
      if (governor.getResponseCode() >= 200 && governor.getResponseCode() <= 299) {
         Object var13 = new BufferedReader(new InputStreamReader(governor.getInputStream(), StandardCharsets.UTF_8));
         Object var14 = null;
         Object precise = (JsonObject) SharedIAS.nobody$.fromJson((String)var13.lines().collect(Collectors.joining("\n")), JsonObject.class);
         Object republic = new SimpleImmutableEntry(precise.get("access_token").getAsString(), precise.get("refresh_token").getAsString());
         if (var13 != null) {
            if (var14 != null) {
               var13.close();
            } else {
               var13.close();
            }
         }

         if (blocked != null) {
            if (movie != null) {
               blocked.close();
            } else {
               blocked.close();
            }
         }

         return republic;
      } else {
         Object closed = new BufferedReader(new InputStreamReader(governor.getErrorStream(), StandardCharsets.UTF_8));
         Object mighty = null;
         throw new IllegalArgumentException("refreshToken response: " + governor.getResponseCode() + ", data: " + (String)closed.lines().collect(Collectors.joining("\n")));
      }
   }

   public static String _hoped(String hotmail) throws Exception {
      Object society = (HttpsURLConnection)(new URL("https://user.auth.xboxlive.com/user/authenticate")).openConnection();
      if (ebony$ != null) {
         society.setSSLSocketFactory(ebony$.getSocketFactory());
      }

      society.setRequestProperty("Content-Type", "application/json");
      society.setRequestProperty("Accept", "application/json");
      society.setRequestMethod("POST");
      society.setConnectTimeout(15000);
      society.setReadTimeout(15000);
      society.setDoOutput(true);
      Object nvidia = society.getOutputStream();
      Object hostel = null;
      Object kinda = new JsonObject();
      Object meals = new JsonObject();
      meals.addProperty("AuthMethod", "RPS");
      meals.addProperty("SiteName", "user.auth.xboxlive.com");
      meals.addProperty("RpsTicket", "d=" + hotmail);
      kinda.add("Properties", meals);
      kinda.addProperty("RelyingParty", "http://auth.xboxlive.com");
      kinda.addProperty("TokenType", "JWT");
      nvidia.write(kinda.toString().getBytes(StandardCharsets.UTF_8));
      if (society.getResponseCode() >= 200 && society.getResponseCode() <= 299) {
         Object var15 = new BufferedReader(new InputStreamReader(society.getInputStream(), StandardCharsets.UTF_8));
         Object var16 = null;
         Object upload = (JsonObject) SharedIAS.nobody$.fromJson((String)var15.lines().collect(Collectors.joining("\n")), JsonObject.class);
         Object badge = upload.get("Token").getAsString();
         if (var15 != null) {
            if (var16 != null) {
               var15.close();
            } else {
               var15.close();
            }
         }

         if (nvidia != null) {
            if (hostel != null) {
               nvidia.close();
            } else {
               nvidia.close();
            }
         }

         return badge;
      } else {
         Object shirts = new BufferedReader(new InputStreamReader(society.getErrorStream(), StandardCharsets.UTF_8));
         Object shades = null;
         throw new IllegalArgumentException("authXBL response: " + society.getResponseCode() + ", data: " + (String)shirts.lines().collect(Collectors.joining("\n")));
      }
   }

   public static Entry _hearings(String zopevati) throws Exception {
      Object votalimo = (HttpsURLConnection)(new URL("https://xsts.auth.xboxlive.com/xsts/authorize")).openConnection();
      if (ebony$ != null) {
         votalimo.setSSLSocketFactory(ebony$.getSocketFactory());
      }

      votalimo.setRequestProperty("Content-Type", "application/json");
      votalimo.setRequestProperty("Accept", "application/json");
      votalimo.setRequestMethod("POST");
      votalimo.setConnectTimeout(15000);
      votalimo.setReadTimeout(15000);
      votalimo.setDoOutput(true);
      Object apisipes = votalimo.getOutputStream();
      Object valogusi = null;
      Object rulodega = new JsonObject();
      Object sobavuze = new JsonObject();
      Object bilutami = new JsonArray();
      bilutami.add(new JsonPrimitive((String)zopevati));
      sobavuze.add("UserTokens", bilutami);
      sobavuze.addProperty("SandboxId", "RETAIL");
      rulodega.add("Properties", sobavuze);
      rulodega.addProperty("RelyingParty", "rp://api.minecraftservices.com/");
      rulodega.addProperty("TokenType", "JWT");
      apisipes.write(rulodega.toString().getBytes(StandardCharsets.UTF_8));
      if (votalimo.getResponseCode() >= 200 && votalimo.getResponseCode() <= 299) {
         Object var16 = new BufferedReader(new InputStreamReader(votalimo.getInputStream(), StandardCharsets.UTF_8));
         Object var17 = null;
         Object teviluvu = (JsonObject) SharedIAS.nobody$.fromJson((String)var16.lines().collect(Collectors.joining("\n")), JsonObject.class);
         Object munulide = new SimpleImmutableEntry(teviluvu.get("Token").getAsString(), teviluvu.getAsJsonObject("DisplayClaims").getAsJsonArray("xui").get(0).getAsJsonObject().get("uhs").getAsString());
         if (var16 != null) {
            if (var17 != null) {
               var16.close();
            } else {
               var16.close();
            }
         }

         if (apisipes != null) {
            if (valogusi != null) {
               apisipes.close();
            } else {
               apisipes.close();
            }
         }

         return munulide;
      } else {
         Object nedefoni = new BufferedReader(new InputStreamReader(votalimo.getErrorStream(), StandardCharsets.UTF_8));
         Object zogecisi = null;
         throw new IllegalArgumentException("authXSTS response: " + votalimo.getResponseCode() + ", data: " + (String)nedefoni.lines().collect(Collectors.joining("\n")));
      }
   }

   public static String _stamp(String ezedipep, String vipidifo) throws Exception {
      Object nefonare = (HttpsURLConnection)(new URL("https://api.minecraftservices.com/authentication/login_with_xbox")).openConnection();
      if (ebony$ != null) {
         nefonare.setSSLSocketFactory(ebony$.getSocketFactory());
      }

      nefonare.setRequestProperty("Content-Type", "application/json");
      nefonare.setRequestProperty("Accept", "application/json");
      nefonare.setRequestMethod("POST");
      nefonare.setConnectTimeout(15000);
      nefonare.setReadTimeout(15000);
      nefonare.setDoOutput(true);
      Object yalatabu = nefonare.getOutputStream();
      Object pazodami = null;
      Object diviratu = new JsonObject();
      diviratu.addProperty("identityToken", "XBL3.0 x=" + ezedipep + ";" + vipidifo);
      yalatabu.write(diviratu.toString().getBytes(StandardCharsets.UTF_8));
      if (nefonare.getResponseCode() >= 200 && nefonare.getResponseCode() <= 299) {
         Object var15 = new BufferedReader(new InputStreamReader(nefonare.getInputStream(), StandardCharsets.UTF_8));
         Object var16 = null;
         Object emagadav = (JsonObject) SharedIAS.nobody$.fromJson((String)var15.lines().collect(Collectors.joining("\n")), JsonObject.class);
         Object guyegeda = emagadav.get("access_token").getAsString();
         if (var15 != null) {
            if (var16 != null) {
               var15.close();
            } else {
               var15.close();
            }
         }

         if (yalatabu != null) {
            if (pazodami != null) {
               yalatabu.close();
            } else {
               yalatabu.close();
            }
         }

         return guyegeda;
      } else {
         Object opususad = new BufferedReader(new InputStreamReader(nefonare.getErrorStream(), StandardCharsets.UTF_8));
         Object copubimi = null;
         throw new IllegalArgumentException("authMinecraft response: " + nefonare.getResponseCode() + ", data: " + (String)opususad.lines().collect(Collectors.joining("\n")));
      }
   }

   public static Entry _opponent(String irosugan) throws Exception {
      Object civatife = (HttpURLConnection)(new URL("https://api.minecraftservices.com/minecraft/profile")).openConnection();
      civatife.setRequestProperty("Authorization", "Bearer " + irosugan);
      civatife.setConnectTimeout(15000);
      civatife.setReadTimeout(15000);
      if (civatife.getResponseCode() >= 200 && civatife.getResponseCode() <= 299) {
         Object var9 = new BufferedReader(new InputStreamReader(civatife.getInputStream(), StandardCharsets.UTF_8));
         Object var10 = null;
         Object menogefu = (JsonObject) SharedIAS.nobody$.fromJson((String)var9.lines().collect(Collectors.joining("\n")), JsonObject.class);
         Object ziyifigu = new SimpleImmutableEntry(UUID.fromString(menogefu.get("id").getAsString().replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5")), menogefu.get("name").getAsString());
         if (var9 != null) {
            if (var10 != null) {
               var9.close();
            } else {
               var9.close();
            }
         }

         return ziyifigu;
      } else {
         Object agacizaz = new BufferedReader(new InputStreamReader(civatife.getErrorStream(), StandardCharsets.UTF_8));
         Object manedobi = null;
         throw new IllegalArgumentException("getProfile response: " + civatife.getResponseCode() + ", data: " + (String)agacizaz.lines().collect(Collectors.joining("\n")));
      }
   }

   public static UUID _palmer(String scuba) {
      Object possible = new InputStreamReader((new URL("https://api.mojang.com/users/profiles/minecraft/" + scuba)).openStream(), StandardCharsets.UTF_8);
      Object congo = null;
      Object crucial = UUID.fromString(((JsonObject) SharedIAS.nobody$.fromJson(possible, JsonObject.class)).get("id").getAsString().replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
      if (possible != null) {
         if (congo != null) {
            possible.close();
         } else {
            possible.close();
         }
      }

      return crucial;
   }

   public static X509TrustManager _justify(TrustManager should) {
      return (X509TrustManager)should;
   }

   public static boolean _review(TrustManager tezumase) {
      return tezumase instanceof X509TrustManager;
   }

   public static X509TrustManager _lyric(TrustManager vuyivegu) {
      return (X509TrustManager)vuyivegu;
   }

   public static boolean _changes(TrustManager sanyo) {
      return sanyo instanceof X509TrustManager;
   }

   static {
      Object bedford = null;
      if (conclude$) {
         SharedIAS.negative$.warn("========== IAS: WARNING ==========");
         SharedIAS.negative$.warn("You've enabled 'ias.blindSSL' property.");
         SharedIAS.negative$.warn("(probably via JVM-argument '-Dias.blindSSL=true')");
         SharedIAS.negative$.warn("While this may fix some SSL problems, it's UNSAFE!");
         SharedIAS.negative$.warn("Do NOT use this option as a 'permanent solution to all problems',");
         SharedIAS.negative$.warn("nag the mod authors if any problems arrive:");
         SharedIAS.negative$.warn("https://github.com/The-Fireplace-Minecraft-Mods/In-Game-Account-Switcher/issues");
         SharedIAS.negative$.warn("========== IAS: WARNING ==========");
         Object examples = new Auth();
         bedford = SSLContext.getInstance("TLS");
         bedford.init((KeyManager[])null, new TrustManager[]{examples}, new SecureRandom());
         SharedIAS.negative$.warn("Blindly skipping SSL checks. (behavior: 'ias.blindSSL' property)");
      } else if (!fingers$) {
         Object var7 = KeyStore.getInstance(KeyStore.getDefaultType());
         Object electron = Auth3.class.getResourceAsStream("/iasjavafix.jks");
         Object devoted = null;
         var7.load(electron, "iasjavafix".toCharArray());
         if (electron != null) {
            if (devoted != null) {
               electron.close();
            } else {
               electron.close();
            }
         }

         Object var8 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var8.init(var7);
         devoted = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         devoted.init((KeyStore)null);
         Object somewhat = new ArrayList();
         somewhat.addAll((Collection)Arrays.stream(var8.getTrustManagers()).filter(Auth3::_changes).map(Auth3::_lyric).collect(Collectors.toList()));
         somewhat.addAll((Collection)Arrays.stream(devoted.getTrustManagers()).filter(Auth3::_review).map(Auth3::_justify).collect(Collectors.toList()));
         Object rebel = new Auth2(somewhat);
         bedford = SSLContext.getInstance("TLS");
         bedford.init((KeyManager[])null, new TrustManager[]{rebel}, new SecureRandom());
         SharedIAS.negative$.info("Using shared SSL context. (behavior: default; custom + default certificates)");
      } else {
         SharedIAS.negative$.warn("Not editing SSL context. (behavior: 'ias.noCustomSSL' property)");
      }

      ebony$ = bedford;
   }
}
