package ft.sleep.util.win32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.;
import com.sun.jna.;
import com.sun.jna.;
import com.sun.jna.;
import java.lang.reflect.Method;

public class StdCallFunctionMapper implements  {
   public int __/* $FF was: */(Class ivesasul) {
      if (.class.isAssignableFrom((Class)ivesasul)) {
         ivesasul = .((Class)ivesasul).();
      }

      return ((Class)ivesasul).isArray() ? Pointer. : Native.((Class)ivesasul);
   }

   public String getFunctionName( imuzumag, Method eruretum) {
      Object oresufun = ((Method)eruretum).getName();
      Object upederiv = 0;
      Object adicebuc = ((Method)eruretum).getParameterTypes();

      for(Object vuyezani : adicebuc) {
         upederiv += fopanapu.(vuyezani);
      }

      Object var11 = oresufun + "@" + upederiv;
      Object var12 = 63;
      Object var13 = (()imuzumag).(var11, var12);
      oresufun = var13.getName();
      return oresufun;
   }
}
