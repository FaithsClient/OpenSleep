package rip.sleep.injection.in;

import net.minecraft.util.Session;

public interface IMixinMinecraft {
   Session getSession();

   void setSession(Session var1);

   void setClickCounter(int var1);
}
