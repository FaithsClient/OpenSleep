package tessellate;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

public class BasicTess implements Tessellation {
   int index;
   int[] raw;
   ByteBuffer buffer;
   FloatBuffer fBuffer;
   IntBuffer iBuffer;
   private int colors;
   private float texU;
   private float texV;
   private boolean color;
   private boolean texture;

   BasicTess(int capacity) {
      capacity = capacity * 6;
      this.raw = new int[capacity];
      this.buffer = ByteBuffer.allocateDirect(capacity * 4).order(ByteOrder.nativeOrder());
      this.fBuffer = this.buffer.asFloatBuffer();
      this.iBuffer = this.buffer.asIntBuffer();
   }

   public Tessellation setColor(int color) {
      this.color = true;
      this.colors = color;
      return this;
   }

   public Tessellation setTexture(float u, float v) {
      this.texture = true;
      this.texU = u;
      this.texV = v;
      return this;
   }

   public Tessellation addVertex(float x, float y, float z) {
      int dex = this.index * 6;
      this.raw[dex] = Float.floatToRawIntBits(x);
      this.raw[dex + 1] = Float.floatToRawIntBits(y);
      this.raw[dex + 2] = Float.floatToRawIntBits(z);
      this.raw[dex + 3] = this.colors;
      this.raw[dex + 4] = Float.floatToRawIntBits(this.texU);
      this.raw[dex + 5] = Float.floatToRawIntBits(this.texV);
      ++this.index;
      return this;
   }

   public Tessellation bind() {
      int dex = this.index * 6;
      this.iBuffer.put(this.raw, 0, dex);
      this.buffer.position(0);
      this.buffer.limit(dex * 4);
      if (this.color) {
         this.buffer.position(12);
         GL11.glColorPointer(4, true, 24, this.buffer);
      }

      if (this.texture) {
         this.fBuffer.position(4);
         GL11.glTexCoordPointer(2, 24, this.fBuffer);
      }

      this.fBuffer.position(0);
      GL11.glVertexPointer(3, 24, this.fBuffer);
      return this;
   }

   public Tessellation pass(int mode) {
      GL11.glDrawArrays(mode, 0, this.index);
      return this;
   }

   public Tessellation unbind() {
      this.iBuffer.position(0);
      return this;
   }

   public Tessellation reset() {
      this.iBuffer.clear();
      this.index = 0;
      this.color = false;
      this.texture = false;
      return this;
   }
}
