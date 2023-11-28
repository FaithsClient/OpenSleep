package rip.sleep.ui.element.elements;

import java.awt.Color;
import org.json.JSONException;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.RenderUtilA;
import rip.sleep.value.Value;

public class InteractiveElement {
   private final String c26108;
   private int c17253;
   private int c59185;
   private final int c3984;
   private final int c93070;
   private final int c25319;
   private final int c69135;

   public InteractiveElement(String var1, int var2, int var3) {
      this.c26108 = var1;
      this.c17253 = var2;
      this.c59185 = var3;
      this.c3984 = 150;
      this.c93070 = 20;
      this.c25319 = 553648127;
      this.c69135 = 822083583;
   }

   public void c26187(int var1, int var2, int var3, int var4) {
      Value.c27574();
      this.c17253 = var3;
      this.c59185 = var4;
      RenderUtilA.c69215(var3, var4, this.c3984, this.c93070, 1, RenderUtilA.c43580(var3, var4, this.c3984, this.c93070, var1, var2) ? this.c69135 : (new Color(28, 28, 28, 120)).getRGB(), 0);
      FontManager.c17232.c59386(this.c26108, (float)(var3 + this.c3984 / 2 - FontManager.c2780.c65036(this.c26108) / 2 - 1), (float)(var4 + this.c93070 / 2) - 3.5F, -1);
   }

   public boolean c35710(int var1, int var2) {
      return RenderUtilA.c43580(this.c58444(), this.c40082(), this.c8783(), this.c76479(), var1, var2);
   }

   public int c8783() {
      return this.c3984;
   }

   public int c76479() {
      return this.c93070;
   }

   public int c58444() {
      return this.c17253;
   }

   public int c40082() {
      return this.c59185;
   }

   public String c5875() {
      return this.c26108;
   }

   private static JSONException c15726(JSONException var0) {
      return var0;
   }
}
