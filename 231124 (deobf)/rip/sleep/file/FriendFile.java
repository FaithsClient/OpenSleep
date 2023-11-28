package rip.sleep.file;

import rip.sleep.module.Module;
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

public class FriendFile extends FileStruct {
   private final List<FriendFile.c73407> c40125 = new ArrayList();

   public FriendFile(File var1) {
      super(var1);
   }

   protected void c587() throws IOException {
      Value.c27574();
      this.c492();
      BufferedReader var2 = new BufferedReader(new FileReader(this.c63704()));

      String var3;
      while((var3 = var2.readLine()) != null) {
         if (!var3.contains("{") && !var3.contains("}")) {
            var3 = var3.replace(" ", "").replace("\"", "").replace(",", "");
            if (var3.contains(":")) {
               String[] var4 = var3.split(":");
               this.c78693(var4[0]);
            }

            this.c78693(var3);
            break;
         }
      }

      var2.close();
   }

   protected void c61142() throws IOException {
      PrintWriter var2 = new PrintWriter(new FileWriter(this.c63704()));
      Value.c27574();
      Iterator var3 = this.c72817().iterator();
      if (var3.hasNext()) {
         FriendFile.c73407 var4 = (FriendFile.c73407)var3.next();
         var2.append(var4.c19239()).append(":");
      }

      var2.close();
   }

   public boolean c78693(String var1) {
      Module[] var2 = Value.c27574();
      if (this.c43312(var1)) {
         return false;
      } else {
         this.c40125.add(new FriendFile.c73407(var1));
         return true;
      }
   }

   public boolean c46491(String var1) {
      Module[] var2 = Value.c27574();
      if (!this.c43312(var1)) {
         return false;
      } else {
         this.c40125.removeIf((var1x) -> {
            return var1x.c19239().equals(var1);
         });
         return true;
      }
   }

   public boolean c43312(String var1) {
      Value.c27574();
      Iterator var3 = this.c40125.iterator();
      if (var3.hasNext()) {
         FriendFile.c73407 var4 = (FriendFile.c73407)var3.next();
         if (var4.c19239().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public void c492() {
      this.c40125.clear();
   }

   public List<FriendFile.c73407> c72817() {
      return this.c40125;
   }

   private static Exception c19939(Exception var0) {
      return var0;
   }

   public class c73407 {
      private final String c46956;

      c73407(String var2) {
         this.c46956 = var2;
      }

      public String c19239() {
         return this.c46956;
      }
   }
}
