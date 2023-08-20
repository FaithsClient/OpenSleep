package ft.sleep.api.value;

import com.google.gson.JsonElement;
import java.util.function.Supplier;

public abstract class Value {
   private final String displayName;
   private final String name;
   public Object value;
   public float optionAnim = 0.0F;
   public float optionAnimNow = 0.0F;
   public Supplier displayableFunc = () -> {
      return true;
   };

   public Value(String displayName, String name) {
      this.displayName = displayName;
      this.name = name;
   }

   public Value(String name) {
      this.displayName = "";
      this.name = name;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public String getName() {
      return this.name.replaceAll(" ", "");
   }

   public Object getValue() {
      return this.value;
   }

   public void setValue(Object value) {
      this.value = value;
      if (.().() != null) {
         .().().saveConfig(.().().configs);
      }

   }

   public abstract JsonElement toJson();

   public abstract void fromJson(JsonElement var1);

   public Value displayable(Supplier supplier) {
      this.displayableFunc = supplier;
      return this;
   }

   public Boolean getDisplayableFunc() {
      return (Boolean)this.displayableFunc.get();
   }
}
