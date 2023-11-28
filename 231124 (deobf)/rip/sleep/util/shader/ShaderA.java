package rip.sleep.util.shader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import rip.sleep.value.Value;

public class ShaderA {
   static Minecraft c21764 = Minecraft.getMinecraft();
   private final int c85769;
   private final String c95074;
   private String c99657;

   public ShaderA(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public ShaderA(String var1) {
      this(var1, "sleep/Shaders/vertex.vsh");
   }

   public void c78750() {
      GL20.glUseProgram(this.c85769);
   }

   public void c2875() {
      GL20.glUseProgram(0);
   }

   public int c83861(String var1) {
      return GL20.glGetUniformLocation(this.c85769, var1);
   }

   public void c30180(String var1, float... var2) {
      Value.c27574();
      int var4 = GL20.glGetUniformLocation(this.c85769, var1);
      switch(var2.length) {
      case 1:
         GL20.glUniform1f(var4, var2[0]);
      case 2:
         GL20.glUniform2f(var4, var2[0], var2[1]);
      case 3:
         GL20.glUniform3f(var4, var2[0], var2[1], var2[2]);
      case 4:
         GL20.glUniform4f(var4, var2[0], var2[1], var2[2], var2[3]);
      default:
      }
   }

   public void c95251(String var1, int... var2) {
      Value.c27574();
      int var4 = GL20.glGetUniformLocation(this.c85769, var1);
      if (var2.length > 1) {
         GL20.glUniform2i(var4, var2[0], var2[1]);
      }

      GL20.glUniform1i(var4, var2[0]);
   }

   public static void c47219(float var0, float var1, float var2, float var3) {
      GL11.glBegin(7);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex2f(var0, var1);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex2f(var0, var1 + var3);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(var0 + var2, var1 + var3);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex2f(var0 + var2, var1);
      GL11.glEnd();
   }

   public static void c3738() {
      ScaledResolution var0 = new ScaledResolution(c21764);
      float var1 = (float)var0.getScaledWidth_double();
      float var2 = (float)var0.getScaledHeight_double();
      GL11.glBegin(7);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex2f(0.0F, 0.0F);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex2f(0.0F, var2);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex2f(var1, var2);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(var1, 0.0F);
      GL11.glEnd();
   }

   private int c52718(InputStream var1, int var2) {
      int var3 = GL20.glCreateShader(var2);
      GL20.glShaderSource(var3, c28192(var1));
      GL20.glCompileShader(var3);
      if (GL20.glGetShaderi(var3, 35713) == 0) {
         System.out.println(GL20.glGetShaderInfoLog(var3, 4096));
         throw new IllegalStateException(String.format("Shader (%s) failed to compile!", var2));
      } else {
         return var3;
      }
   }

   public static String c28192(InputStream var0) {
      StringBuilder var1 = new StringBuilder();
      BufferedReader var10000 = new BufferedReader;
      BufferedReader var10001 = var10000;
      InputStreamReader var10002 = new InputStreamReader;
      InputStreamReader var10003 = var10002;
      InputStream var10004 = var0;

      try {
         var10003.<init>(var10004);
         var10001.<init>(var10002);
         BufferedReader var2 = var10000;

         String var3;
         while((var3 = var2.readLine()) != null) {
            var1.append(var3).append('\n');
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var1.toString();
   }

   private static Exception c51594(Exception var0) {
      return var0;
   }
}
