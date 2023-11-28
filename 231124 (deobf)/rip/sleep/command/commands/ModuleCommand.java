package rip.sleep.command.commands;

import java.util.Iterator;
import org.json.JSONException;
import rip.sleep.command.Command;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.util.MathUtilB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

class ModuleCommand extends Command {
   private final Module c8108;
   final Module c99318;

   ModuleCommand(Module var1, String var2, String[] var3, String var4, String var5) {
      super(var2, var3, var4, var5);
      this.c99318 = var1;
      this.c8108 = var1;
   }

   public String c23111(String[] var1) {
      Module[] var2 = Value.c27574();
      if (var1.length >= 2) {
         BooleanValue var3 = null;
         NumberValue var4 = null;
         ModeValue var5 = null;

         for(Value var7 : this.c8108.c79199) {
            if (var7 instanceof BooleanValue && var7.getName().equalsIgnoreCase(var1[0])) {
               var3 = (BooleanValue)var7;
               break;
            }
         }

         if (var3 != null) {
            var3.c28440(Boolean.valueOf(!var3.c1473().booleanValue()));
            ChatUtilA.c34080(String.format("> %s has been set to %s", var3.getName(), var3.c1473()));
         }

         for(Value var17 : this.c8108.c79199) {
            if (var17 instanceof NumberValue && var17.getName().equalsIgnoreCase(var1[0])) {
               var4 = (NumberValue)var17;
               break;
            }
         }

         if (MathUtilB.c81955(var1[1], (byte)4)) {
            double var8 = MathUtilB.c98725(Double.parseDouble(var1[1]), 1);
            var4.c70375(Double.valueOf(var8 > var4.c36673().doubleValue() ? var4.c36673().doubleValue() : var8));
            ChatUtilA.c34080(String.format("> %s has been set to %s", var4.getName(), var4.c53968()));
         }

         ChatUtilA.c34080("> " + var1[1] + " is not a number");

         for(Value var18 : this.c8108.c79199) {
            if (var1[0].equalsIgnoreCase(var18.getName()) && var18 instanceof ModeValue) {
               var5 = (ModeValue)var18;
               break;
            }
         }

         if (var5 != null) {
            if (var5.c93891(var1[1])) {
               var5.c94243(var1[1]);
               ChatUtilA.c34080(String.format("> %s set to %s", var5.getName(), var5.c21632()));
            }

            ChatUtilA.c34080("> " + var1[1] + " is an invalid mode");
         }

         this.c73172("Valid .<module> <setting> <mode if needed>");
      }

      if (var1.length >= 1) {
         BooleanValue var10 = null;
         Iterator var11 = this.c8108.c79199.iterator();
         if (var11.hasNext()) {
            Value var12 = (Value)var11.next();
            if (var12 instanceof BooleanValue && var12.getName().equalsIgnoreCase(var1[0])) {
               var10 = (BooleanValue)var12;
            }
         }

         if (var10 != null) {
            var10.c28440(Boolean.valueOf(!var10.c1473().booleanValue()));
            String var13 = var10.getName().substring(1);
            String var16 = var10.getName().substring(0, 1).toUpperCase();
            if (var10.c1473().booleanValue()) {
               ChatUtilA.c34080(String.format("> %s has been set to §a%s", var16 + var13, var10.c1473()));
            }

            ChatUtilA.c34080(String.format("> %s has been set to §c%s", var16 + var13, var10.c1473()));
         }

         this.c73172("Valid .<module> <setting> <mode if needed>");
      }

      ChatUtilA.c34080(String.format("%s Values: \n %s", this.getName().substring(0, 1).toUpperCase() + this.getName().substring(1).toLowerCase(), this.c41918(), "false"));
      return null;
   }

   private static JSONException c78785(JSONException var0) {
      return var0;
   }
}
