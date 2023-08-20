package ft.sleep.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class ColorValue extends Value {
   public boolean Expanded;

   public ColorValue(String name, int color) {
      super(name);
      this.setValue(Integer.valueOf(color));
   }

   public boolean isExpanded() {
      return this.Expanded;
   }

   public Integer getValue() {
      return (Integer)super.getValue();
   }

   public JsonElement toJson() {
      return new JsonPrimitive(this.getValue());
   }

   public void fromJson(JsonElement element) {
      if (element.isJsonPrimitive()) {
         this.setValue(Integer.valueOf(element.getAsInt()));
      }

   }

   public void setExpanded(boolean expanded) {
      this.Expanded = expanded;
   }

   public float[] getHSB() {
      float[] hsbValues = new float[3];
      int cMax = Math.max(this.getValue().intValue() >>> 16 & 255, this.getValue().intValue() >>> 8 & 255);
      if ((this.getValue().intValue() & 255) > cMax) {
         cMax = this.getValue().intValue() & 255;
      }

      int cMin = Math.min(this.getValue().intValue() >>> 16 & 255, this.getValue().intValue() >>> 8 & 255);
      if ((this.getValue().intValue() & 255) < cMin) {
         cMin = this.getValue().intValue() & 255;
      }

      float brightness = (float)cMax / 255.0F;
      float saturation = cMax != 0 ? (float)(cMax - cMin) / (float)cMax : 0.0F;
      float hue;
      if (saturation == 0.0F) {
         hue = 0.0F;
      } else {
         float redC = (float)(cMax - (this.getValue().intValue() >>> 16 & 255)) / (float)(cMax - cMin);
         float greenC = (float)(cMax - (this.getValue().intValue() >>> 8 & 255)) / (float)(cMax - cMin);
         float blueC = (float)(cMax - (this.getValue().intValue() & 255)) / (float)(cMax - cMin);
         hue = ((this.getValue().intValue() >>> 16 & 255) == cMax ? blueC - greenC : ((this.getValue().intValue() >>> 8 & 255) == cMax ? 2.0F + redC - blueC : 4.0F + greenC - redC)) / 6.0F;
         if (hue < 0.0F) {
            ++hue;
         }
      }

      hsbValues[0] = hue;
      hsbValues[1] = saturation;
      hsbValues[2] = brightness;
      return hsbValues;
   }
}
