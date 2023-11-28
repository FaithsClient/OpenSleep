package rip.sleep.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import rip.sleep.file.FileManager;
import rip.sleep.file.FileStruct;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtilA extends FileStruct {
   private final List<JsonUtilA.c16238> c26579 = new ArrayList();

   public JsonUtilA(File var1) {
      super(var1);
   }

   protected void c587() throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected void c61142() throws IOException {
      Value.c27574();
      JsonArray var2 = new JsonArray();
      Iterator var3 = this.c5425().iterator();
      if (var3.hasNext()) {
         JsonUtilA.c16238 var4 = (JsonUtilA.c16238)var3.next();
         JsonObject var5 = new JsonObject();
         var5.addProperty("playerName", var4.c40734());
         var2.add(var5);
      }

      PrintWriter var6 = new PrintWriter(new FileWriter(this.c63704()));
      var6.println(FileManager.c69355.toJson(var2));
      var6.close();
   }

   public boolean c30803(String var1) {
      Module[] var2 = Value.c27574();
      if (this.c21722(var1)) {
         return false;
      } else {
         this.c26579.add(new JsonUtilA.c16238(var1));
         return true;
      }
   }

   public boolean c36634(String var1) {
      Module[] var2 = Value.c27574();
      if (!this.c21722(var1)) {
         return false;
      } else {
         this.c26579.removeIf((var1x) -> {
            return var1x.c40734().equals(var1);
         });
         return true;
      }
   }

   public boolean c21722(String var1) {
      Value.c27574();
      Iterator var3 = this.c26579.iterator();
      if (var3.hasNext()) {
         JsonUtilA.c16238 var4 = (JsonUtilA.c16238)var3.next();
         if (var4.c40734().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public void c87689() {
      this.c26579.clear();
   }

   public List<JsonUtilA.c16238> c5425() {
      return this.c26579;
   }

   private static JsonSyntaxException c13053(JsonSyntaxException var0) {
      return var0;
   }

   public static class c16238 {
      private final String c25910;

      public c16238(String var1) {
         this.c25910 = var1;
      }

      public String c40734() {
         return this.c25910;
      }
   }
}
