package rip.sleep.ui.neverlose.components;

import net.minecraft.client.gui.Gui;
import rip.sleep.value.Value;
import rip.sleep.ui.renderer.ComponentRenderer;

public abstract class NeverLoseComponent<V extends Value> extends Gui {
   public V c93183;
   private float c12867;
   private float c73023;
   private int c34901;
   private int c61946;
   public ComponentRenderer c43133;

   public NeverLoseComponent(V var1, ComponentRenderer var2) {
      this.c93183 = var1;
      this.c43133 = var2;
   }

   public abstract void c60551(int var1, int var2);

   public abstract void c80028(int var1, int var2, int var3);

   public void c91879(char var1, int var2) {
   }

   public abstract void c66160(int var1, int var2, int var3);

   public float c9605() {
      return this.c12867;
   }

   public float c49717() {
      return this.c73023;
   }

   public int c37142() {
      return this.c61946;
   }

   public int c44884() {
      return this.c34901;
   }

   public void c91958(int var1) {
      this.c12867 = (float)var1;
   }

   public void c57589(int var1) {
      this.c73023 = (float)var1;
   }

   public int c51261() {
      return this.c43133.c9138;
   }
}
