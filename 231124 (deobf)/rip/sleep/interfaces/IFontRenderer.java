package rip.sleep.interfaces;

public interface IFontRenderer {
   float c8296(CharSequence var1, float var2, float var3, int var4, boolean var5);

   float c63319(CharSequence var1, double var2, double var4, int var6, boolean var7);

   String c52754(CharSequence var1, int var2, boolean var3);

   int c80174(CharSequence var1);

   float c90293(char var1);

   String getName();

   int c5397();

   boolean c98228();

   boolean c94302();

   default float c18223(CharSequence var1, float var2, float var3, int var4) {
      return this.c8296(var1, var2, var3, var4, false);
   }

   default float c48462(CharSequence var1, int var2, int var3, int var4) {
      return this.c8296(var1, (float)var2, (float)var3, var4, false);
   }

   default String c65781(CharSequence var1, int var2) {
      return this.c52754(var1, var2, false);
   }

   default float c19763(CharSequence var1, float var2, float var3, int var4, boolean var5) {
      return this.c8296(var1, var2 - (float)this.c80174(var1) / 2.0F, var3, var4, var5);
   }

   default float c15113(float var1) {
      return var1 / 2.0F - (float)this.c5397() / 2.0F;
   }

   default float c5112(CharSequence var1, float var2, float var3, int var4) {
      return this.c19763(var1, var2, var3, var4, false);
   }
}
