package rip.sleep.file;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.modules.HUD;
import rip.sleep.module.modules.TargetHUD;
import rip.sleep.module.modules.TargetList;
import rip.sleep.value.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map.Entry;

public class TargetFile extends FileStruct {
   public TargetFile(File var1) {
      super(var1);
   }

   protected void c587() throws IOException {
      Value.c27574();
      JsonElement var2 = (new JsonParser()).parse(new BufferedReader(new FileReader(this.c63704())));
      if (!(var2 instanceof JsonNull)) {
         Iterator var3 = var2.getAsJsonObject().entrySet().iterator();
         if (var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            Sleep.getInstance();
            Module var5 = Sleep.c33759().c39099((String)var4.getKey());
            JsonObject var6 = (JsonObject)var4.getValue();
            if (((String)var4.getKey()).equalsIgnoreCase("user")) {
               JsonObject var7 = (JsonObject)var4.getValue();
               if (var7.has("name1")) {
                  HUD.c95730(var7.get("name1").getAsString());
               }
            }

            if (var5 != null) {
               var5.c23631(var6.get("State").getAsBoolean());
               var5.c32946(var6.get("KeyBind").getAsInt());
               if (((String)var4.getKey()).equalsIgnoreCase("Target_Hud")) {
                  JsonObject var10 = (JsonObject)var4.getValue();
                  if (var10.has("hud_x")) {
                     TargetHUD.c95424(var10.get("hud_x").getAsInt());
                  }

                  if (var10.has("hud_y")) {
                     TargetHUD.c88120(var10.get("hud_y").getAsInt());
                  }
               }

               if (((String)var4.getKey()).equalsIgnoreCase("Target_List")) {
                  JsonObject var11 = (JsonObject)var4.getValue();
                  if (var11.has("list_x")) {
                     TargetList.c93075(var11.get("list_x").getAsInt());
                  }

                  if (var11.has("list_y")) {
                     TargetList.c92639(var11.get("list_y").getAsInt());
                  }
               }

               if (var6.has("CustomName")) {
                  var5.c45577(var6.get("CustomName").getAsString());
               }

               if (var6.has("Array")) {
                  var5.c68609(var6.get("Array").getAsBoolean());
               }

               Iterator var12 = var5.c22326().iterator();
               if (var12.hasNext()) {
                  Value var8 = (Value)var12.next();
                  JsonElement var9 = var6.get(var8.getName());
                  if (var9 != null) {
                     var8.c10550(var9);
                  }
               }
            }
         }

      }
   }

   protected void c61142() throws IOException {
      JsonObject var2 = new JsonObject();
      new JsonObject();
      JsonObject var4 = new JsonObject();
      JsonObject var5 = new JsonObject();
      JsonObject var6 = new JsonObject();
      Value.c27574();
      var6.addProperty("name1", HUD.c27743);
      var2.add("user", var6);
      var4.addProperty("hud_x", Integer.valueOf(TargetHUD.c46389()));
      var4.addProperty("hud_y", Integer.valueOf(TargetHUD.c28175()));
      var2.add("Target_Hud", var4);
      var5.addProperty("list_x", Integer.valueOf(TargetList.c70725()));
      var5.addProperty("list_y", Integer.valueOf(TargetList.c78433()));
      var2.add("Target_List", var5);
      Sleep var10001 = Sleep.INSTANCE;
      Sleep.c33759();
      Iterator var7 = ModuleManager.c84590().iterator();
      if (var7.hasNext()) {
         Module var8 = (Module)var7.next();
         JsonObject var9 = new JsonObject();
         var9.addProperty("State", Boolean.valueOf(var8.c24622()));
         var9.addProperty("KeyBind", Integer.valueOf(var8.c93366()));
         var9.addProperty("Array", Boolean.valueOf(var8.c41971()));
         var9.addProperty("CustomName", var8.c15191());
         var2.add(var8.getName(), var9);
         if (!var8.c22326().isEmpty()) {
            Iterator var10 = var8.c22326().iterator();
            if (var10.hasNext()) {
               Value var11 = (Value)var10.next();
               var9.add(var11.getName(), var11.c75132());
            }
         }
      }

      PrintWriter var12 = new PrintWriter(new FileWriter(this.c63704()));
      var12.println(FileManager.c69355.toJson(var2));
      var12.close();
   }

   private static IOException c40326(IOException var0) {
      return var0;
   }
}
