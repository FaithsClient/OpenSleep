package rip.sleep.value.values;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.Supplier;
import org.json.JSONException;
import rip.sleep.value.Value;

public class NumberValue<T extends Number> extends Value<T> {
   private String c82515;
   public T c19933;
   public T c57556;
   public T c29860;
   public String c4188;
   private final boolean c74535;
   private String c41724 = "";

   public NumberValue(String var1, T var2, T var3, T var4, T var5) {
      super(var1);
      this.c70375(var2);
      this.c19933 = var3;
      this.c57556 = var4;
      this.c29860 = var5;
      this.c74535 = false;
      this.c41724 = "";
   }

   public NumberValue(String var1, T var2, T var3, T var4, T var5, String var6) {
      super(var1);
      this.c70375(var2);
      this.c19933 = var3;
      this.c57556 = var4;
      this.c29860 = var5;
      this.c74535 = false;
      this.c41724 = var6;
   }

   public NumberValue(String var1, String var2, T var3, T var4, T var5, T var6) {
      super(var1, var2);
      this.c70375(var3);
      this.c19933 = var4;
      this.c57556 = var5;
      this.c29860 = var6;
      this.c74535 = false;
   }

   public NumberValue(String var1, Supplier<Boolean> var2, T var3, T var4, T var5, T var6) {
      super(var1, var2);
      this.c70375(var3);
      this.c19933 = var4;
      this.c57556 = var5;
      this.c29860 = var6;
      this.c74535 = false;
      this.c41724 = "";
   }

   public NumberValue(String var1, Supplier<Boolean> var2, T var3, T var4, T var5, T var6, String var7) {
      super(var1, var2);
      this.c70375(var3);
      this.c19933 = var4;
      this.c57556 = var5;
      this.c29860 = var6;
      this.c74535 = false;
      this.c41724 = var7;
   }

   public NumberValue(String var1, String var2, Supplier<Boolean> var3, T var4, T var5, T var6, T var7) {
      super(var1, var2, var3);
      this.c70375(var4);
      this.c19933 = var5;
      this.c57556 = var6;
      this.c29860 = var7;
      this.c74535 = false;
   }

   public T c53968() {
      return (T)(super.c36545());
   }

   public void c70375(T var1) {
      super.c28440(var1);
   }

   public JsonElement c75132() {
      return new JsonPrimitive(this.c53968());
   }

   public void c10550(JsonElement var1) {
      if (var1.isJsonPrimitive()) {
         this.c70375(var1.getAsNumber());
      }

   }

   public T c61905() {
      return this.c19933;
   }

   public T c36673() {
      return this.c57556;
   }

   public void c35132(T var1) {
      this.c29860 = var1;
   }

   public T c18780() {
      return this.c29860;
   }

   public String c82770() {
      return this.c82515;
   }

   public String c96577() {
      return this.c41724;
   }

   public boolean c65697() {
      return this.c74535;
   }

   // $FF: synthetic method
   public void c28440(Object var1) {
      this.c70375((Number)var1);
   }

   // $FF: synthetic method
   public Object c36545() {
      return this.c53968();
   }

   private static JSONException c6647(JSONException var0) {
      return var0;
   }
}
