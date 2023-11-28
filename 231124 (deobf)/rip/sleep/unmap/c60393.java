package rip.sleep.unmap;

import com.google.gson.annotations.Expose;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.interfaces.IControl;
import rip.sleep.module.Module;
import rip.sleep.util.Control;
import rip.sleep.value.Value;

public class c60393 {
   public static final c60393 c87322 = new c60393((IControl)null, 0, Control.None);
   private IControl c30554;
   @Expose
   private String c97861;
   @Expose
   private Control c53284;
   @Expose
   private int c71946;

   public c60393(IControl var1, int var2, Control var3) {
      this.c30554 = var1;
      this.c71946 = var2;
      this.c53284 = var3;
      this.c97861 = Keyboard.getKeyName(var2);
   }

   public c60393(IControl var1, int var2) {
      this.c30554 = var1;
      this.c71946 = var2;
      this.c53284 = Control.None;
      this.c97861 = Keyboard.getKeyName(var2);
   }

   public boolean c94024() {
      Module[] var1 = Value.c27574();
      return this.c53284 == Control.None || c2671.c78282(this.c53284);
   }

   public void c17835() {
      Module[] var1 = Value.c27574();
      if (this.c94024()) {
         this.c30554.c24719();
      }

   }

   public void c94611(c60393 var1) {
      this.c97861 = var1.c3538();
      this.c53284 = var1.c86975();
      this.c71946 = var1.c86140();
   }

   public void c95105() {
      this.c30554.c10833();
   }

   public IControl c20943() {
      return this.c30554;
   }

   public String c3538() {
      return this.c97861;
   }

   public void c7385(String var1) {
      this.c97861 = var1;
   }

   public Control c86975() {
      return this.c53284;
   }

   public void c20959(Control var1) {
      this.c53284 = var1;
   }

   public int c86140() {
      return this.c71946;
   }

   public void c67067(int var1) {
      this.c71946 = var1;
   }

   private static JSONException c43841(JSONException var0) {
      return var0;
   }
}
