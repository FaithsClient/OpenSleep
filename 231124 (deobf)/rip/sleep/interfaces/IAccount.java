package rip.sleep.interfaces;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public interface IAccount {
   UUID c97270();

   String name();

   CompletableFuture<SessionData> c59276(BiConsumer<String, Object[]> var1);

   public static class SessionData {
      public static final String c67197 = "msa";
      public static final String c36631 = "mojang";
      public static final String c19706 = "legacy";
      private final String c14722;
      private final UUID c33175;
      private final String c22205;
      private final String c94304;

      public SessionData(String var1, UUID var2, String var3, String var4) {
         this.c14722 = var1;
         this.c33175 = var2;
         this.c22205 = var3;
         this.c94304 = var4;
      }

      public String name() {
         return this.c14722;
      }

      public UUID c62581() {
         return this.c33175;
      }

      public String c84432() {
         return this.c22205;
      }

      public String c17308() {
         return this.c94304;
      }
   }
}
