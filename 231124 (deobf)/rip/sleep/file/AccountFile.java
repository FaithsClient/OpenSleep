package rip.sleep.file;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rip.sleep.account.LegacyAccount;
import rip.sleep.account.MicrosoftAccount;
import rip.sleep.interfaces.IAccount;
import rip.sleep.module.Module;
import rip.sleep.ui.renderer.AccountRenderer;
import rip.sleep.value.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class AccountFile extends FileStruct {
   public final List<AccountRenderer> c35592 = new ArrayList();
   public final List<IAccount> c57149 = new ArrayList();

   public AccountFile(File var1) {
      super(var1);
   }

   protected void c587() throws IOException {
      Value.c27574();
      JsonElement var2 = (new JsonParser()).parse(new BufferedReader(new FileReader(this.c63704())));
      if (!(var2 instanceof JsonNull)) {
         Iterator var3 = var2.getAsJsonArray().iterator();
         if (var3.hasNext()) {
            JsonElement var4 = (JsonElement)var3.next();
            JsonObject var5 = var4.getAsJsonObject();
            if (this.c61648(var5.get("name").getAsString())) {
               return;
            }

            if (var5.get("type").getAsString().equalsIgnoreCase("microsoft")) {
               this.c98074(var5.get("name").getAsString(), var5.get("accessToken").getAsString(), var5.get("refreshToken").getAsString(), UUID.fromString(var5.get("uuid").getAsString()));
            }

            if (var5.get("type").getAsString().equalsIgnoreCase("offline")) {
               this.c45424(var5.get("name").getAsString());
            }
         }

      }
   }

   protected void c61142() throws IOException {
      JsonArray var2 = new JsonArray();
      Value.c27574();
      Iterator var3 = this.c57149.iterator();
      if (var3.hasNext()) {
         IAccount var4 = (IAccount)var3.next();
         JsonObject var5 = new JsonObject();
         if (var4 instanceof MicrosoftAccount) {
            MicrosoftAccount var6 = (MicrosoftAccount)var4;
            var5.addProperty("type", "microsoft");
            var5.addProperty("name", var6.name());
            var5.addProperty("accessToken", var6.c75634());
            var5.addProperty("refreshToken", var6.c35335());
            var5.addProperty("uuid", var6.c97270().toString());
            var5.addProperty("size", Integer.valueOf(this.c35592.size()));
            var2.add(var5);
         }

         if (var4 instanceof LegacyAccount) {
            var5.addProperty("type", "offline");
            var5.addProperty("name", var4.name());
            var5.addProperty("uuid", var4.c97270().toString());
            var5.addProperty("size", Integer.valueOf(this.c35592.size()));
            var2.add(var5);
         }
      }

      PrintWriter var7 = new PrintWriter(new FileWriter(this.c63704()));
      var7.println(FileManager.c69355.toJson(var2));
      var7.close();
   }

   public void c45424(String var1) {
      Module[] var2 = Value.c27574();
      if (!this.c61648(var1)) {
         this.c35592.add(new AccountRenderer(new LegacyAccount(var1, c25664.c68686(var1))));
         this.c57149.add(new LegacyAccount(var1, c25664.c68686(var1)));
      }
   }

   public void c98074(String var1, String var2, String var3, UUID var4) {
      Module[] var5 = Value.c27574();
      if (!this.c61648(var1)) {
         this.c35592.add(new AccountRenderer(new MicrosoftAccount(var1, var2, var3, var4)));
         this.c57149.add(new MicrosoftAccount(var1, var2, var3, var4));
      }
   }

   public void c30252(AccountRenderer var1) {
      this.c57149.remove(this.c57149.get(this.c57149.indexOf(var1.c13273) + 1));
      this.c35592.remove(var1);
   }

   public boolean c61648(String var1) {
      Value.c27574();
      Iterator var3 = this.c57149.iterator();
      if (var3.hasNext()) {
         IAccount var4 = (IAccount)var3.next();
         if (var4.name().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private static Exception c19939(Exception var0) {
      return var0;
   }
}
