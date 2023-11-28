package rip.sleep.command;

import org.json.JSONException;
import rip.sleep.util.ChatUtilA;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public abstract class Command {
   private final String c8715;
   protected String[] c13992;
   private final String c900;
   private final String c62378;
   public static final String c57551 = "§c[§fA§c]§7 ";

   public Command(String var1, String[] var2, String var3, String var4) {
      this.c8715 = var1.toLowerCase();
      this.c900 = var3.toLowerCase();
      this.c62378 = var4;
      this.c13992 = var2;
   }

   public abstract String c23111(String[] var1);

   public String getName() {
      return this.c8715;
   }

   public String[] c29280() {
      return this.c13992;
   }

   public String c41918() {
      return this.c900;
   }

   public String c20388() {
      return this.c62378;
   }

   public void c73172(String var1) {
      ChatUtilA.c34080(String.format("§7Invalid command usage", var1));
   }

   public void c8366(byte var1) {
      Module[] var2 = Value.c27574();
      switch(var1) {
      case 0:
         this.c73172("bad argument");
      case 1:
         this.c73172("argument gay");
      default:
      }
   }

   private static JSONException c96395(JSONException var0) {
      return var0;
   }
}
