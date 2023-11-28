package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.entity.EntityLivingBase;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class UnknownRenderEvent extends Event {
   private final EntityLivingBase c67176;
   private final boolean c85003;
   public boolean c58135;
   private float c78651;
   private float c30447;
   private float c52731;
   private float c26237;
   private float c54046;
   private float c50439;
   private float c36306;

   public UnknownRenderEvent(EntityLivingBase var1, boolean var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.c67176 = var1;
      this.c85003 = var2;
      this.c78651 = var3;
      this.c30447 = var4;
      this.c52731 = var5;
      this.c26237 = var6;
      this.c54046 = var7;
      this.c50439 = var8;
      this.c36306 = var9;
      this.c58135 = false;
   }

   public UnknownRenderEvent(EntityLivingBase var1, boolean var2) {
      this.c67176 = var1;
      this.c85003 = var2;
   }

   public EntityLivingBase c74212() {
      return this.c67176;
   }

   public boolean c1161() {
      return this.c85003;
   }

   public boolean c64297() {
      Module[] var1 = Value.c27574();
      return !this.c85003;
   }

   public float c53744() {
      return this.c78651;
   }

   public void c72064(float var1) {
      this.c78651 = var1;
   }

   public float c98474() {
      return this.c30447;
   }

   public void c16437(float var1) {
      this.c30447 = var1;
   }

   public float c13054() {
      return this.c52731;
   }

   public void c54215(float var1) {
      this.c52731 = var1;
   }

   public float c73908() {
      return this.c26237;
   }

   public void c94854(float var1) {
      this.c26237 = var1;
   }

   public float c31966() {
      return this.c54046;
   }

   public void c18396(float var1) {
      this.c54046 = var1;
   }

   public float c55715() {
      return this.c36306;
   }

   public void c6941(float var1) {
      this.c36306 = var1;
   }

   public float c62275() {
      return this.c50439;
   }

   public void c41213(float var1) {
      this.c50439 = var1;
   }

   public boolean c58917() {
      return this.c58135;
   }

   public void c8253(boolean var1) {
      this.c58135 = var1;
   }

   private static JSONException c83349(JSONException var0) {
      return var0;
   }
}
