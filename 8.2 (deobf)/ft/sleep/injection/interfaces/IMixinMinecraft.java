package ft.sleep.injection.interfaces;

import net.minecraft.util.Session;

public interface IMixinMinecraft {
   Session getSession();

   void setSession(Session var1);

   void setClickCounter(int var1);
}
