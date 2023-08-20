package ft.sleep.command.commands;

import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;

public class Module extends Command {
   public ft.sleep.module.Module mounting$;
   public ft.sleep.module.Module water$;

   public Module(ft.sleep.module.Module vessels, String holly, String[] holdings, String journey, String lucia) {
      super((String)holly, (String[])holdings, (String)journey, (String)lucia);
      farmer.water$ = (ft.sleep.module.Module)vessels;
      farmer.mounting$ = (ft.sleep.module.Module)vessels;
   }

   public String _absolute(String[] ifadesay) {
      if (((Object[])ifadesay).length >= 2) {
         Object osiruzuf = null;
         Object tacaleyi = null;
         Object cefufope = null;

         for(Object bigobeco : isezaper.mounting$.write$) {
            if (bigobeco instanceof Option && bigobeco.getName().equalsIgnoreCase((String)((Object[])ifadesay)[0])) {
               osiruzuf = (Option)bigobeco;
            }
         }

         if (osiruzuf != null) {
            osiruzuf.setValue(Boolean.valueOf(!osiruzuf.getValue().booleanValue()));
            Helper._seller(String.format("> %s has been set to %s", osiruzuf.getName(), osiruzuf.getValue()));
         } else {
            for(Object var16 : isezaper.mounting$.write$) {
               if (var16 instanceof Numbers && var16.getName().equalsIgnoreCase((String)((Object[])ifadesay)[0])) {
                  tacaleyi = (Numbers)var16;
               }
            }

            if (tacaleyi != null) {
               if (MathUtil._racks((String)((Object[])ifadesay)[1], (byte)4)) {
                  Object unozayel = MathUtil._teach(Double.parseDouble((String)((Object[])ifadesay)[1]), 1);
                  tacaleyi.setValue(Double.valueOf(unozayel > tacaleyi.getMaximum().doubleValue() ? tacaleyi.getMaximum().doubleValue() : unozayel));
                  Helper._seller(String.format("> %s has been set to %s", tacaleyi.getName(), tacaleyi.getValue()));
               } else {
                  Helper._seller("> " + ((Object[])ifadesay)[1] + " is not a number");
               }
            }

            for(Object var17 : isezaper.mounting$.write$) {
               if (((String)((Object[])ifadesay)[0]).equalsIgnoreCase(var17.getName()) && var17 instanceof Mode) {
                  cefufope = (Mode)var17;
               }
            }

            if (cefufope != null) {
               if (cefufope.isValid((String)((Object[])ifadesay)[1])) {
                  cefufope.setMode((String)((Object[])ifadesay)[1]);
                  Helper._seller(String.format("> %s set to %s", cefufope.getName(), cefufope.getModeAsString()));
               } else {
                  Helper._seller("> " + ((Object[])ifadesay)[1] + " is an invalid mode");
               }
            }
         }

         if (tacaleyi == null && osiruzuf == null && cefufope == null) {
            isezaper._kidney("Valid .<module> <setting> <mode if needed>");
         }
      } else if (((Object[])ifadesay).length >= 1) {
         Object var9 = null;

         for(Object var11 : isezaper.mounting$.write$) {
            if (var11 instanceof Option && var11.getName().equalsIgnoreCase((String)((Object[])ifadesay)[0])) {
               var9 = (Option)var11;
            }
         }

         if (var9 != null) {
            var9.setValue(Boolean.valueOf(!var9.getValue().booleanValue()));
            Object var12 = var9.getName().substring(1);
            Object var15 = var9.getName().substring(0, 1).toUpperCase();
            if (var9.getValue().booleanValue()) {
               Helper._seller(String.format("> %s has been set to §a%s", var15 + var12, var9.getValue()));
            } else {
               Helper._seller(String.format("> %s has been set to §c%s", var15 + var12, var9.getValue()));
            }
         } else {
            isezaper._kidney("Valid .<module> <setting> <mode if needed>");
         }
      } else {
         Helper._seller(String.format("%s Values: \n %s", isezaper._rivers().substring(0, 1).toUpperCase() + isezaper._rivers().substring(1).toLowerCase(), isezaper._taught(), "false"));
      }

      return null;
   }
}
