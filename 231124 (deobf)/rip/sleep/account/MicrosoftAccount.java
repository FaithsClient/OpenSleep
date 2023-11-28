package rip.sleep.account;

import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import org.apache.logging.log4j.Logger;
import rip.sleep.interfaces.IAccount;
import rip.sleep.util.IASShared;

public class MicrosoftAccount implements IAccount {
   private String c19488;
   private String c24196;
   private String c59752;
   private UUID c31459;

   public MicrosoftAccount(String var1, String var2, String var3, UUID var4) {
      this.c19488 = var1;
      this.c24196 = var2;
      this.c59752 = var3;
      this.c31459 = var4;
   }

   public UUID c97270() {
      return this.c31459;
   }

   public String name() {
      return this.c19488;
   }

   public String c75634() {
      return this.c24196;
   }

   public String c35335() {
      return this.c59752;
   }

   public CompletableFuture<SessionData> c59276(BiConsumer<String, Object[]> var1) {
      CompletableFuture var2 = new CompletableFuture();
      IASShared.c59270.execute(() -> {
         MicrosoftAccount var10000 = this;
         BiConsumer var10001 = var1;

         try {
            var10000.c38(var10001);
            var2.complete(new SessionData(this.c19488, this.c31459, this.c24196, "msa"));
         } catch (Throwable var4) {
            IASShared.c95173.error("Unable to login/refresh Microsoft account.", var4);
            var2.completeExceptionally(var4);
         }

      });
      return var2;
   }

   private void c38(BiConsumer<String, Object[]> var1) throws Exception {
      Logger var10000 = IASShared.c95173;
      String var10001 = "Refreshing...";

      try {
         var10000.info(var10001);
         var1.accept("Authentication... (%s)", new Object[]{"getProfile"});
         Entry var2 = c25664.c39961(this.c24196);
         IASShared.c95173.info("Access token is valid.");
         this.c31459 = (UUID)var2.getKey();
         this.c19488 = (String)var2.getValue();
      } catch (Exception var10) {
         var10000 = IASShared.c95173;
         var10001 = "Step: refreshToken.";

         try {
            var10000.info(var10001);
            var1.accept("Authentication... (%s)", new Object[]{"refreshToken"});
            Entry var3 = c25664.c67110(this.c59752);
            String var4 = (String)var3.getValue();
            IASShared.c95173.info("Step: authXBL.");
            var1.accept("Authentication... (%s)", new Object[]{"authXBL"});
            String var5 = c25664.c46251((String)var3.getKey());
            IASShared.c95173.info("Step: authXSTS.");
            var1.accept("Authentication... (%s)", new Object[]{"authXSTS"});
            Entry var6 = c25664.c14162(var5);
            IASShared.c95173.info("Step: authMinecraft.");
            var1.accept("Authentication... (%s)", new Object[]{"authMinecraft"});
            String var7 = c25664.c74587((String)var6.getValue(), (String)var6.getKey());
            IASShared.c95173.info("Step: getProfile.");
            var1.accept("Authentication... (%s)", new Object[]{"getProfile"});
            Entry var8 = c25664.c39961(var7);
            IASShared.c95173.info("Refreshed.");
            this.c31459 = (UUID)var8.getKey();
            this.c19488 = (String)var8.getValue();
            this.c24196 = var7;
            this.c59752 = var4;
         } catch (Exception var9) {
            var9.addSuppressed(var10);
            throw var9;
         }
      }

   }
}
