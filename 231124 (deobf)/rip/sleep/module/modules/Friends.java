package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.util.RenderUtilG;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.StringValue;

public class Friends extends Module {
   private boolean c93288;
   private final StringValue c30152 = new StringValue("Add Name", "");
   public static BooleanValue c70443 = new BooleanValue("Add", false);
   public static BooleanValue c88974 = new BooleanValue("Del", false);

   public Friends() {
      super("Friends", new String[]{"mcf", "middleclick"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(241, 175, 67)).getRGB());
   }

   @EventTarget
   private void c24138(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c88974.c1473().booleanValue() && this.c30152.c36545() != null && Sleep.INSTANCE.c43557().c25756.c43312((String)this.c30152.c36545())) {
         Sleep.INSTANCE.c43557().c25756.c46491((String)this.c30152.c36545());
         PlayerUtilG.c11143("del " + (String)this.c30152.c36545());
         Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c25756);
         this.c30152.c28440("");
         c88974.c28440(Boolean.valueOf(false));
      }

      if (c70443.c1473().booleanValue() && this.c30152.c36545() != null && !Sleep.INSTANCE.c43557().c25756.c43312((String)this.c30152.c36545())) {
         Sleep.INSTANCE.c43557().c25756.c78693((String)this.c30152.c36545());
         PlayerUtilG.c11143("add " + (String)this.c30152.c36545());
         Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c25756);
         this.c30152.c28440("");
         c70443.c28440(Boolean.valueOf(false));
      }

      if (mc.currentScreen == null) {
         if (!this.c93288 && Mouse.isButtonDown(2)) {
            Entity var3 = mc.objectMouseOver.entityHit;
            EntityPlayer var4 = (EntityPlayer) mc.objectMouseOver.entityHit;
            String var5 = RenderUtilG.c70907(var4.getName());
            if (Sleep.INSTANCE.c43557().c25756.c43312(var5)) {
               Sleep.INSTANCE.c43557().c25756.c46491(var5);
               PlayerUtilG.c11143("remove " + var5);
               Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c25756);
            }

            Sleep.INSTANCE.c43557().c25756.c78693(var5);
            PlayerUtilG.c11143("add " + var5);
            Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c25756);
         }

         this.c93288 = Mouse.isButtonDown(2);
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
