package rip.sleep.account;

import rip.sleep.interfaces.IAccount;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class LegacyAccount implements IAccount {
   private final String c3541;
   private final UUID c71304;

   public LegacyAccount(String var1, UUID var2) {
      this.c3541 = var1;
      this.c71304 = var2;
   }

   public UUID c97270() {
      return this.c71304;
   }

   public String name() {
      return this.c3541;
   }

   public CompletableFuture<SessionData> c59276(BiConsumer<String, Object[]> var1) {
      return CompletableFuture.completedFuture(new SessionData(this.name(), this.c97270(), "0", "legacy"));
   }
}
