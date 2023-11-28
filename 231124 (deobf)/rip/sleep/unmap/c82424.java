package rip.sleep.unmap;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class c82424 {
   private final String c25771;
   private final String c29151;

   public c82424(String var1, String var2) {
      Value.c27574();
      super();
      this.c25771 = var1.trim();
      this.c29151 = StringUtils.isNotBlank(var2) ? var2 : null;
   }

   public String c4609() {
      return this.c25771;
   }

   public String c81400() {
      return this.c29151;
   }

   public boolean equals(Object var1) {
      Module[] var2 = Value.c27574();
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         c82424 var3 = (c82424)var1;
         return this.c25771.equals(var3.c25771) && Objects.equals(this.c29151, var3.c29151);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.c25771, this.c29151});
   }

   public String toString() {
      Module[] var1 = Value.c27574();
      return this.c25771 + (this.c29151 != null ? ":" + this.c29151 : "");
   }

   private static JSONException c93897(JSONException var0) {
      return var0;
   }
}
