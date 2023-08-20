package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObfuscationData implements Iterable {
   private final Map data;
   private final Object defaultValue;

   public ObfuscationData() {
      this((Object)null);
   }

   public ObfuscationData(Object defaultValue) {
      this.data = new HashMap();
      this.defaultValue = defaultValue;
   }

   /** @deprecated */
   @Deprecated
   public void add(ObfuscationType type, Object value) {
      this.put(type, value);
   }

   public void put(ObfuscationType type, Object value) {
      this.data.put(type, value);
   }

   public boolean isEmpty() {
      return this.data.isEmpty();
   }

   public Object get(ObfuscationType type) {
      Object value = (T)this.data.get(type);
      return value != null ? value : this.defaultValue;
   }

   public Iterator iterator() {
      return this.data.keySet().iterator();
   }

   public String toString() {
      return String.format("ObfuscationData[%s,DEFAULT=%s]", this.listValues(), this.defaultValue);
   }

   public String values() {
      return "[" + this.listValues() + "]";
   }

   private String listValues() {
      StringBuilder sb = new StringBuilder();
      boolean delim = false;

      for(ObfuscationType type : this.data.keySet()) {
         if (delim) {
            sb.append(',');
         }

         sb.append(type.getKey()).append('=').append(this.data.get(type));
         delim = true;
      }

      return sb.toString();
   }
}
