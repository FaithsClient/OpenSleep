package rip.sleep.struct;

import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public enum AnimationState {
   Forward,
   Backward;

   public AnimationState c30380() {
      Module[] var1 = Value.c27574();
      return this == Forward ? Backward : Forward;
   }

   private static JSONException c16773(JSONException var0) {
      return var0;
   }
}
