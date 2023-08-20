//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.other;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class ShaderUtil {
   public static Minecraft leader$ = Minecraft.getMinecraft();
   public int flower$;
   public String tiger$;
   public String numeric$;

   public ShaderUtil(String revepaye, String licogada) {
      dorocosa.tiger$ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}";
      dorocosa.tiger$ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}";
      dorocosa.numeric$ = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    // Smooth the result (free antialiasing).\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);// mix(quadColor, shadowColor, 0.0);\n\n}";
      Object ovubotoy = GL20.glCreateProgram();
      Object mucesumu = -1;
      switch(((String)revepaye).hashCode()) {
      case -493757311:
         if (((String)revepaye).equals("roundedRectGradient")) {
            mucesumu = 1;
         }
         break;
      case -72859087:
         if (((String)revepaye).equals("roundedRect")) {
            mucesumu = 0;
         }
      }

      int turefasi;
      switch(mucesumu) {
      case 0:
         turefasi = dorocosa._prayer(new ByteArrayInputStream(dorocosa.numeric$.getBytes()), 35632);
         break;
      case 1:
         turefasi = dorocosa._prayer(new ByteArrayInputStream("#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}".getBytes()), 35632);
         break;
      default:
         turefasi = dorocosa._prayer(leader$.getResourceManager().getResource(new ResourceLocation((String)revepaye)).getInputStream(), 35632);
      }

      GL20.glAttachShader(ovubotoy, turefasi);
      Object ugecoyed = dorocosa._prayer(leader$.getResourceManager().getResource(new ResourceLocation((String)licogada)).getInputStream(), 35633);
      GL20.glAttachShader(ovubotoy, ugecoyed);
      GL20.glLinkProgram(ovubotoy);
      turefasi = GL20.glGetProgrami(ovubotoy, 35714);
      if (turefasi == 0) {
         throw new IllegalStateException("Shader failed to link!");
      } else {
         dorocosa.flower$ = ovubotoy;
      }
   }

   public ShaderUtil(String salvador) {
      this((String)salvador, "sleep/Shaders/vertex.vsh");
   }

   public void _folks() {
      GL20.glUseProgram(gisiluto.flower$);
   }

   public void _consist() {
      GL20.glUseProgram(0);
   }

   public int _tagged(String cycling) {
      return GL20.glGetUniformLocation(confused.flower$, (CharSequence)cycling);
   }

   public void _brunei(String yifotabo, float... gipapusi) {
      Object yivifize = GL20.glGetUniformLocation(musarobo.flower$, (CharSequence)yifotabo);
      switch(((Object[])gipapusi).length) {
      case 1:
         GL20.glUniform1f(yivifize, (float)((Object[])gipapusi)[0]);
         break;
      case 2:
         GL20.glUniform2f(yivifize, (float)((Object[])gipapusi)[0], (float)((Object[])gipapusi)[1]);
         break;
      case 3:
         GL20.glUniform3f(yivifize, (float)((Object[])gipapusi)[0], (float)((Object[])gipapusi)[1], (float)((Object[])gipapusi)[2]);
         break;
      case 4:
         GL20.glUniform4f(yivifize, (float)((Object[])gipapusi)[0], (float)((Object[])gipapusi)[1], (float)((Object[])gipapusi)[2], (float)((Object[])gipapusi)[3]);
      }

   }

   public void _fraser(String steel, int... rough) {
      Object lying = GL20.glGetUniformLocation(download.flower$, (CharSequence)steel);
      if (((Object[])rough).length > 1) {
         GL20.glUniform2i(lying, (int)((Object[])rough)[0], (int)((Object[])rough)[1]);
      } else {
         GL20.glUniform1i(lying, (int)((Object[])rough)[0]);
      }

   }

   public static void _involved(float ofunogad, float sipetafe, float muvudume, float rigaseva) {
      GL11.glBegin(7);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glVertex2f((float)ofunogad, (float)sipetafe);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), 1.0F);
      GL11.glVertex2f((float)ofunogad, (float)(sipetafe + rigaseva));
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f((float)(ofunogad + muvudume), (float)(sipetafe + rigaseva));
      GL11.glTexCoord2f(1.0F, Float.intBitsToFloat(0));
      GL11.glVertex2f((float)(ofunogad + muvudume), (float)sipetafe);
      GL11.glEnd();
   }

   public static void _handbags() {
      Object outdoor = new ScaledResolution(leader$);
      Object stock = (float)outdoor.getScaledWidth_double();
      Object shield = (float)outdoor.getScaledHeight_double();
      GL11.glBegin(7);
      GL11.glTexCoord2f(Float.intBitsToFloat(0), 1.0F);
      GL11.glVertex2f(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glTexCoord2f(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      GL11.glVertex2f(Float.intBitsToFloat(0), shield);
      GL11.glTexCoord2f(1.0F, Float.intBitsToFloat(0));
      GL11.glVertex2f(stock, shield);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex2f(stock, Float.intBitsToFloat(0));
      GL11.glEnd();
   }

   public int _prayer(InputStream seventh, int stores) {
      Object allen = GL20.glCreateShader((int)stores);
      GL20.glShaderSource(allen, _survivor((InputStream)seventh));
      GL20.glCompileShader(allen);
      if (GL20.glGetShaderi(allen, 35713) == 0) {
         System.out.println(GL20.glGetShaderInfoLog(allen, 4096));
         throw new IllegalStateException(String.format("Shader (%s) failed to compile!", Integer.valueOf((int)stores)));
      } else {
         return allen;
      }
   }

   public static String _survivor(InputStream gapobofa) {
      Object olayayar = new StringBuilder();
      Object rororibe = new BufferedReader(new InputStreamReader((InputStream)gapobofa));

      String tenafasi;
      while((tenafasi = rororibe.readLine()) != null) {
         olayayar.append(tenafasi).append('\n');
      }

      return olayayar.toString();
   }
}
