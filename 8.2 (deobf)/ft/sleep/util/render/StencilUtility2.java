package ft.sleep.util.render;

import org.lwjgl.opengl.GL11;

public class StencilUtility2 {
   public static int meyer$;
   public static int sorts$;
   public static int hampton$;
   public static int sending$;
   public static int dayton$;
   public static int theta$;

   public StencilUtility2(StencilUtility alolubom, int asabilif, int opamuyoz, int yizuzebi, int pagurepe, int ecesecod, int var7) {
      meyer$ = (int)asabilif;
      sorts$ = (int)opamuyoz;
      hampton$ = (int)yizuzebi;
      sending$ = (int)pagurepe;
      dayton$ = (int)ecesecod;
      theta$ = var7;
   }

   public void _claim() {
      GL11.glStencilFunc(meyer$, sorts$, hampton$);
      GL11.glStencilOp(sending$, dayton$, theta$);
   }
}
