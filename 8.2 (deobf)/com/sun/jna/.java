package com.sun.jna;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class  {
   public static int  = 0;
   public static int  = 1;
   public static int  = 2;
   public static int  = 3;
   public static int  = -1;
   public static Map  = new WeakHashMap();
   public static Map  = new WeakHashMap();
   public Pointer ;
   public int size;
   public int ;
   public String ;
   public int ;
   public int ;
   public Map ;
   public Map ;
   public  ;
   public long ;
   public boolean ;
   public boolean ;
   public [] ;
   public boolean ;
   public static ThreadLocal  = new ThreadLocal() {
      public synchronized Map __/* $FF was: */() {
         return new HashMap();
      }

      public Object initialValue() {
         return SAO46.();
      }
   };
   public static ThreadLocal  = new ThreadLocal() {
      public synchronized Set _/* $FF was: */() {
         return new .();
      }

      public Object initialValue() {
         return SAO46.();
      }
   };
   public static Pointer  = new Pointer((long)-1698720193 ^ -1698720193L) {
      public Pointer _/* $FF was: */(long SAO46xx, long SAO46x) {
         return SAO46;
      }
   };

   public ___/* $FF was: */() {
      this(0);
   }

   public ___/* $FF was: */( SAO46) {
      this((Pointer)null, 0, SAO46);
   }

   public ___/* $FF was: */(int SAO46) {
      this((Pointer)null, SAO46);
   }

   public ___/* $FF was: */(int SAO46,  SAO46) {
      this((Pointer)null, SAO46, SAO46);
   }

   public ___/* $FF was: */(Pointer SAO46) {
      this(SAO46, 0);
   }

   public ___/* $FF was: */(Pointer SAO46, int SAO46) {
      this(SAO46, SAO46, ()null);
   }

   public ___/* $FF was: */(Pointer SAO46, int SAO46,  SAO46) {
      SAO46.size = -1;
      SAO46. = new HashMap();
      SAO46. = true;
      SAO46. = true;
      SAO46.(SAO46);
      SAO46.(Native.(SAO46.getClass()));
      SAO46.(SAO46);
      SAO46.();
      if (SAO46 != null) {
         SAO46.(SAO46, 0, true);
      } else {
         SAO46.(-1);
      }

      SAO46.();
   }

   public Map _/* $FF was: */() {
      return SAO46.;
   }

   public  _/* $FF was: */() {
      return SAO46.;
   }

   public void _/* $FF was: */( SAO46) {
      if (SAO46 == null) {
         SAO46 = Native.(SAO46.getClass());
      }

      SAO46. = SAO46;
      SAO46.();
   }

   public void __/* $FF was: */() {
      if (SAO46.size != -1) {
         SAO46.size = -1;
         if (SAO46. instanceof .) {
            SAO46. = null;
         }

         SAO46.();
      }

   }

   public void _/* $FF was: */(String SAO46) {
      SAO46. = SAO46;
   }

   public String __/* $FF was: */() {
      return SAO46.;
   }

   public void _/* $FF was: */(int SAO46) {
      SAO46. = SAO46;
      if (SAO46 == 0) {
         SAO46 = Native.(SAO46.getClass());
         if (SAO46 == 0) {
            if (.()) {
               SAO46 = 3;
            } else {
               SAO46 = 2;
            }
         }
      }

      SAO46. = SAO46;
      SAO46.();
   }

   public  _/* $FF was: */(int SAO46) {
      return new .(SAO46);
   }

   public void _/* $FF was: */(Pointer SAO46) {
      SAO46.(SAO46, 0);
   }

   public void _/* $FF was: */(Pointer SAO46, int SAO46) {
      SAO46.(SAO46, SAO46, false);
   }

   public void _/* $FF was: */(Pointer SAO46, int SAO46, boolean SAO46) {
      try {
         SAO46..clear();
         if (SAO46 instanceof . && !SAO46) {
            byte[] SAO46 = new byte[SAO46.size()];
            SAO46.((long)1622176288 ^ 1622176288L, SAO46, 0, SAO46.length);
            SAO46..((long)199025377 ^ 199025377L, SAO46, 0, SAO46.length);
         } else {
            SAO46. = SAO46.((long)SAO46);
            if (SAO46.size == -1) {
               SAO46.size = SAO46.(false);
            }

            if (SAO46.size != -1) {
               SAO46. = SAO46.((long)SAO46, (long)SAO46.size);
            }
         }

         SAO46. = null;
         SAO46. = false;
      } catch (IndexOutOfBoundsException var5) {
         throw new IllegalArgumentException("Structure exceeds provided memory bounds", var5);
      }
   }

   public void __/* $FF was: */() {
      SAO46.(false);
   }

   public void _/* $FF was: */(boolean SAO46) {
      if (SAO46. == null) {
         SAO46.(SAO46);
      } else if (SAO46.size == -1) {
         SAO46.size = SAO46.(true, SAO46);
         if (!(SAO46. instanceof .)) {
            try {
               SAO46. = SAO46..((long)1813797409 ^ 1813797409L, (long)SAO46.size);
            } catch (IndexOutOfBoundsException var3) {
               throw new IllegalArgumentException("Structure exceeds provided memory bounds", var3);
            }
         }
      }

   }

   public void __/* $FF was: */() {
      SAO46.(false);
   }

   public void __/* $FF was: */(boolean SAO46) {
      SAO46.(SAO46.(true, SAO46));
   }

   public void __/* $FF was: */(int SAO46) {
      if (SAO46 == -1) {
         SAO46 = SAO46.(false);
      } else if (SAO46 <= 0) {
         throw new IllegalArgumentException("Structure size must be greater than zero: " + SAO46);
      }

      if (SAO46 != -1) {
         if (SAO46. == null || SAO46. instanceof .) {
            SAO46. = SAO46.(SAO46);
         }

         SAO46.size = SAO46;
      }

   }

   public int size() {
      SAO46.();
      return SAO46.size;
   }

   public void clear() {
      SAO46.();
      SAO46..((long)SAO46.size());
   }

   public Pointer _/* $FF was: */() {
      SAO46.();
      return SAO46.;
   }

   public static Set _/* $FF was: */() {
      return (Set).get();
   }

   public static Map _/* $FF was: */() {
      return (Map).get();
   }

   public void ___/* $FF was: */() {
      if (!SAO46.) {
         SAO46.();
      }

   }

   public void read() {
      if (SAO46. != ) {
         SAO46. = true;
         SAO46.();
         if (!().contains(SAO46)) {
            ().add(SAO46);
            if (SAO46 instanceof .) {
               ().put(SAO46.(), SAO46);
            }

            try {
               for(. SAO46 : SAO46.().values()) {
                  SAO46.(SAO46);
               }
            } finally {
               ().remove(SAO46);
               if (().get(SAO46.()) == SAO46) {
                  ().remove(SAO46.());
               }

            }

         }
      }
   }

   public int _/* $FF was: */(String SAO46) {
      SAO46.();
      . SAO46 = (.)SAO46.().get(SAO46);
      if (SAO46 == null) {
         throw new IllegalArgumentException("No such field: " + SAO46);
      } else {
         return SAO46.offset;
      }
   }

   public Object _/* $FF was: */(String SAO46) {
      SAO46.();
      . SAO46 = (.)SAO46.().get(SAO46);
      if (SAO46 == null) {
         throw new IllegalArgumentException("No such field: " + SAO46);
      } else {
         return SAO46.(SAO46);
      }
   }

   public Object _/* $FF was: */(Field SAO46) {
      try {
         return SAO46.get(SAO46);
      } catch (Exception var3) {
         throw new Error("Exception reading field '" + SAO46.getName() + "' in " + SAO46.getClass(), var3);
      }
   }

   public void _/* $FF was: */(Field SAO46, Object SAO46) {
      SAO46.(SAO46, SAO46, false);
   }

   public void _/* $FF was: */(Field SAO46, Object SAO46, boolean SAO46) {
      try {
         SAO46.set(SAO46, SAO46);
      } catch (IllegalAccessException var6) {
         int SAO46 = SAO46.getModifiers();
         if (Modifier.isFinal(SAO46)) {
            if (SAO46) {
               throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + SAO46.getName() + "' within " + SAO46.getClass() + ")", var6);
            } else {
               throw new UnsupportedOperationException("Attempt to write to read-only field '" + SAO46.getName() + "' within " + SAO46.getClass(), var6);
            }
         } else {
            throw new Error("Unexpectedly unable to write to field '" + SAO46.getName() + "' within " + SAO46.getClass(), var6);
         }
      }
   }

   public static  _/* $FF was: */(Class SAO46,  SAO46, Pointer SAO46) {
      if (SAO46 == null) {
         SAO46 = null;
      } else if (SAO46 != null && SAO46.equals(SAO46.())) {
         SAO46.();
      } else {
          SAO46 = ()().get(SAO46);
         if (SAO46 != null && SAO46.equals(SAO46.getClass())) {
            SAO46 = SAO46;
            SAO46.();
         } else {
            SAO46 = (SAO46, SAO46);
            SAO46.();
         }
      }

      return SAO46;
   }

   public Object _/* $FF was: */(. SAO46) {
      int SAO46 = SAO46.offset;
      Class SAO46 = SAO46.;
      FromNativeConverter SAO46 = SAO46.;
      if (SAO46 != null) {
         SAO46 = SAO46.();
      }

      Object SAO46 = !.class.isAssignableFrom(SAO46) && !Callback.class.isAssignableFrom(SAO46) && (!. || !Buffer.class.isAssignableFrom(SAO46)) && !Pointer.class.isAssignableFrom(SAO46) && !.class.isAssignableFrom(SAO46) && !SAO46.isArray() ? null : SAO46.(SAO46.);
      Object SAO46;
      if (SAO46 == String.class) {
         Pointer SAO46 = SAO46..((long)SAO46);
         SAO46 = SAO46 == null ? null : SAO46.((long)-589876499 ^ -589876499L, SAO46.);
      } else {
         SAO46 = SAO46..((long)SAO46, SAO46, SAO46);
      }

      if (SAO46 != null) {
         SAO46 = SAO46.fromNative(SAO46, SAO46.);
         if (SAO46 != null && SAO46.equals(SAO46)) {
            SAO46 = SAO46;
         }
      }

      if (SAO46.equals(String.class) || SAO46.equals(.class)) {
         SAO46..put(SAO46.name + ".ptr", SAO46..((long)SAO46));
         SAO46..put(SAO46.name + ".val", SAO46);
      }

      SAO46.(SAO46., SAO46, true);
      return SAO46;
   }

   public void write() {
      if (SAO46. != ) {
         SAO46.();
         if (SAO46 instanceof .) {
            SAO46.();
         }

         if (!().contains(SAO46)) {
            ().add(SAO46);

            try {
               for(. SAO46 : SAO46.().values()) {
                  if (!SAO46.) {
                     SAO46.(SAO46);
                  }
               }
            } finally {
               ().remove(SAO46);
            }

         }
      }
   }

   public void _/* $FF was: */(String SAO46) {
      SAO46.();
      . SAO46 = (.)SAO46.().get(SAO46);
      if (SAO46 == null) {
         throw new IllegalArgumentException("No such field: " + SAO46);
      } else {
         SAO46.(SAO46);
      }
   }

   public void _/* $FF was: */(String SAO46, Object SAO46) {
      SAO46.();
      . SAO46 = (.)SAO46.().get(SAO46);
      if (SAO46 == null) {
         throw new IllegalArgumentException("No such field: " + SAO46);
      } else {
         SAO46.(SAO46., SAO46);
         SAO46.(SAO46);
      }
   }

   public void _/* $FF was: */(. SAO46) {
      if (!SAO46.) {
         int SAO46 = SAO46.offset;
         Object SAO46 = SAO46.(SAO46.);
         Class SAO46 = SAO46.;
         ToNativeConverter SAO46 = SAO46.;
         if (SAO46 != null) {
            SAO46 = SAO46.(SAO46, new (SAO46, SAO46.));
            SAO46 = SAO46.();
         }

         if (String.class == SAO46 || .class == SAO46) {
            boolean SAO46 = SAO46 == .class;
            if (SAO46 != null) {
               if (SAO46..containsKey(SAO46.name + ".ptr") && SAO46.equals(SAO46..get(SAO46.name + ".val"))) {
                  return;
               }

                SAO46 = SAO46 ? new (SAO46.toString(), true) : new (SAO46.toString(), SAO46.);
               SAO46..put(SAO46.name, SAO46);
               SAO46 = SAO46.();
            } else {
               SAO46..remove(SAO46.name);
            }

            SAO46..remove(SAO46.name + ".ptr");
            SAO46..remove(SAO46.name + ".val");
         }

         try {
            SAO46..((long)SAO46, SAO46, SAO46);
         } catch (IllegalArgumentException var8) {
            String SAO46 = "Structure field \"" + SAO46.name + "\" was declared as " + SAO46. + (SAO46. == SAO46 ? "" : " (native type " + SAO46 + ")") + ", which is not supported within a Structure";
            throw new IllegalArgumentException(SAO46, var8);
         }
      }
   }

   public abstract List _/* $FF was: */();

   /** @deprecated */
   @Deprecated
   public void _/* $FF was: */(String[] SAO46) {
      throw new Error("This method is obsolete, use getFieldOrder() instead");
   }

   public void _/* $FF was: */(List SAO46, List SAO46) {
      for(int SAO46 = 0; SAO46 < SAO46.size(); ++SAO46) {
         String SAO46 = (String)SAO46.get(SAO46);

         for(int SAO46 = 0; SAO46 < SAO46.size(); ++SAO46) {
            Field SAO46 = (Field)SAO46.get(SAO46);
            if (SAO46.equals(SAO46.getName())) {
               Collections.swap(SAO46, SAO46, SAO46);
               break;
            }
         }
      }

   }

   public List _/* $FF was: */() {
      List SAO46 = new ArrayList();

      for(Class SAO46 = SAO46.getClass(); !SAO46.equals(.class); SAO46 = SAO46.getSuperclass()) {
         List SAO46 = new ArrayList();
         Field[] SAO46 = SAO46.getDeclaredFields();

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            int SAO46 = SAO46[SAO46].getModifiers();
            if (!Modifier.isStatic(SAO46) && Modifier.isPublic(SAO46)) {
               SAO46.add(SAO46[SAO46]);
            }
         }

         SAO46.addAll(0, SAO46);
      }

      return SAO46;
   }

   public List _/* $FF was: */() {
      Class SAO46 = SAO46.getClass();
      synchronized() {
         List SAO46 = (List).get(SAO46);
         if (SAO46 == null) {
            SAO46 = SAO46.();
            .put(SAO46, SAO46);
         }

         return SAO46;
      }
   }

   public static List _/* $FF was: */(List SAO46, String... SAO46) {
      return (SAO46, Arrays.asList(SAO46));
   }

   public static List _/* $FF was: */(List SAO46, List SAO46) {
      List SAO46 = new ArrayList(SAO46.size() + SAO46.size());
      SAO46.addAll(SAO46);
      SAO46.addAll(SAO46);
      return Collections.unmodifiableList(SAO46);
   }

   public static List _/* $FF was: */(String SAO46) {
      return Collections.unmodifiableList(Collections.singletonList(SAO46));
   }

   public static List _/* $FF was: */(String... SAO46) {
      return Collections.unmodifiableList(Arrays.asList(SAO46));
   }

   public static List _/* $FF was: */(Collection SAO46) {
      List SAO46 = new ArrayList(SAO46);
      Collections.sort(SAO46);
      return SAO46;
   }

   public List _/* $FF was: */(boolean SAO46) {
      List SAO46 = SAO46.();
      Set SAO46 = new HashSet();

      for(Field SAO46 : SAO46) {
         SAO46.add(SAO46.getName());
      }

      List SAO46 = SAO46.();
      if (SAO46.size() != SAO46.size() && SAO46.size() > 1) {
         if (SAO46) {
            throw new Error("Structure.getFieldOrder() on " + SAO46.getClass() + " does not provide enough names [" + SAO46.size() + "] (" + (SAO46) + ") to match declared fields [" + SAO46.size() + "] (" + (SAO46) + ")");
         } else {
            return null;
         }
      } else {
         Set SAO46 = new HashSet(SAO46);
         if (!SAO46.equals(SAO46)) {
            throw new Error("Structure.getFieldOrder() on " + SAO46.getClass() + " returns names (" + (SAO46) + ") which do not match declared field names (" + (SAO46) + ")");
         } else {
            SAO46.(SAO46, SAO46);
            return SAO46;
         }
      }
   }

   public int _/* $FF was: */(boolean SAO46) {
      return SAO46.(SAO46, false);
   }

   public static int _/* $FF was: */(Class SAO46) {
      return (SAO46, ()null);
   }

   public static int _/* $FF was: */(Class SAO46,  SAO46) {
      . SAO46;
      synchronized() {
         SAO46 = (.).get(SAO46);
      }

      int SAO46 = SAO46 != null && !SAO46. ? SAO46.size : -1;
      if (SAO46 == -1) {
         if (SAO46 == null) {
            SAO46 = (SAO46, );
         }

         SAO46 = SAO46.size();
      }

      return SAO46;
   }

   public int _/* $FF was: */(boolean SAO46, boolean SAO46) {
      int SAO46 = -1;
      Class SAO46 = SAO46.getClass();
      . SAO46;
      synchronized() {
         SAO46 = (.).get(SAO46);
      }

      if (SAO46 == null || SAO46. != SAO46. || SAO46. != SAO46.) {
         SAO46 = SAO46.(SAO46, SAO46);
      }

      if (SAO46 != null) {
         SAO46. = SAO46.;
         SAO46. = SAO46.fields;
         if (!SAO46.) {
            synchronized() {
               if (!.containsKey(SAO46) || SAO46. != 0 || SAO46. != null) {
                  .put(SAO46, SAO46);
               }
            }
         }

         SAO46 = SAO46.size;
      }

      return SAO46;
   }

   public void _/* $FF was: */(String SAO46, Class SAO46) {
      if (SAO46. != null) {
         ToNativeConverter SAO46 = SAO46..(SAO46);
         if (SAO46 != null) {
            SAO46.(SAO46, SAO46.());
            return;
         }
      }

      if (SAO46.isArray()) {
         SAO46.(SAO46, SAO46.getComponentType());
      } else {
         try {
            SAO46.(SAO46);
         } catch (IllegalArgumentException var5) {
            String SAO46 = "Invalid Structure field in " + SAO46.getClass() + ", field name '" + SAO46 + "' (" + SAO46 + "): " + var5.getMessage();
            throw new IllegalArgumentException(SAO46, var5);
         }
      }

   }

   public void ___/* $FF was: */() {
      for(Field SAO46 : SAO46.()) {
         SAO46.(SAO46.getName(), SAO46.getType());
      }

   }

   public . _/* $FF was: */(boolean SAO46, boolean SAO46) {
      int SAO46 = 0;
      List SAO46 = SAO46.(SAO46);
      if (SAO46 == null) {
         return null;
      } else {
         . SAO46 = new .();
         SAO46. = SAO46.;
         SAO46. = SAO46.;
         boolean SAO46 = true;

         for(Field SAO46 : SAO46) {
            int SAO46 = SAO46.getModifiers();
            Class SAO46 = SAO46.getType();
            if (SAO46.isArray()) {
               SAO46. = true;
            }

            . SAO46 = new .();
            SAO46. = Modifier.isVolatile(SAO46);
            SAO46. = Modifier.isFinal(SAO46);
            if (SAO46.) {
               if (!.) {
                  throw new IllegalArgumentException("This VM does not support read-only fields (field '" + SAO46.getName() + "' within " + SAO46.getClass() + ")");
               }

               SAO46.setAccessible(true);
            }

            SAO46. = SAO46;
            SAO46.name = SAO46.getName();
            SAO46. = SAO46;
            if (Callback.class.isAssignableFrom(SAO46) && !SAO46.isInterface()) {
               throw new IllegalArgumentException("Structure Callback field '" + SAO46.getName() + "' must be an interface");
            }

            if (SAO46.isArray() && .class.equals(SAO46.getComponentType())) {
               String SAO46 = "Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined";
               throw new IllegalArgumentException(SAO46);
            }

            int SAO46 = 1;
            if (Modifier.isPublic(SAO46.getModifiers())) {
               Object SAO46 = SAO46.(SAO46.);
               if (SAO46 == null && SAO46.isArray()) {
                  if (SAO46) {
                     throw new IllegalStateException("Array fields must be initialized");
                  }

                  return null;
               }

               Class SAO46 = SAO46;
               if (.class.isAssignableFrom(SAO46)) {
                   SAO46 = .(SAO46);
                  SAO46 = SAO46.();
                  SAO46. = SAO46;
                  SAO46. = SAO46;
                  SAO46. = new (SAO46, SAO46);
               } else if (SAO46. != null) {
                  ToNativeConverter SAO46 = SAO46..(SAO46);
                  FromNativeConverter SAO46 = SAO46..(SAO46);
                  if (SAO46 != null && SAO46 != null) {
                     SAO46 = SAO46.(SAO46, new (SAO46, SAO46.));
                     SAO46 = SAO46 != null ? SAO46.getClass() : Pointer.class;
                     SAO46. = SAO46;
                     SAO46. = SAO46;
                     SAO46. = new (SAO46, SAO46);
                  } else if (SAO46 != null || SAO46 != null) {
                     String SAO46 = "Structures require bidirectional type conversion for " + SAO46;
                     throw new IllegalArgumentException(SAO46);
                  }
               }

               if (SAO46 == null) {
                  SAO46 = SAO46.(SAO46., SAO46);
               }

               try {
                  SAO46.size = SAO46.(SAO46, SAO46);
                  SAO46 = SAO46.(SAO46, SAO46, SAO46);
               } catch (IllegalArgumentException var18) {
                  if (!SAO46 && SAO46. == null) {
                     return null;
                  }

                  String SAO46 = "Invalid Structure field in " + SAO46.getClass() + ", field name '" + SAO46.name + "' (" + SAO46. + "): " + var18.getMessage();
                  throw new IllegalArgumentException(SAO46, var18);
               }

               if (SAO46 == 0) {
                  throw new Error("Field alignment is zero for field '" + SAO46.name + "' within " + SAO46.getClass());
               }

               SAO46. = Math.max(SAO46., SAO46);
               if (SAO46 % SAO46 != 0) {
                  SAO46 += SAO46 - SAO46 % SAO46;
               }

               if (SAO46 instanceof ) {
                  SAO46.offset = 0;
                  SAO46 = Math.max(SAO46, SAO46.size);
               } else {
                  SAO46.offset = SAO46;
                  SAO46 += SAO46.size;
               }

               SAO46.fields.put(SAO46.name, SAO46);
               if (SAO46. == null || SAO46..size < SAO46.size || SAO46..size == SAO46.size && .class.isAssignableFrom(SAO46.)) {
                  SAO46. = SAO46;
               }
            }

            SAO46 = false;
         }

         if (SAO46 > 0) {
            int SAO46 = SAO46.(SAO46, SAO46.);
            if (SAO46 instanceof . && !SAO46) {
               SAO46.();
            }

            SAO46.size = SAO46;
            return SAO46;
         } else {
            throw new IllegalArgumentException("Structure " + SAO46.getClass() + " has unknown or zero size (ensure all fields are public)");
         }
      }
   }

   public void ___/* $FF was: */() {
      for(Field SAO46 : SAO46.()) {
         try {
            Object SAO46 = SAO46.get(SAO46);
            if (SAO46 == null) {
               SAO46.(SAO46, SAO46.getType());
            }
         } catch (Exception var5) {
            throw new Error("Exception reading field '" + SAO46.getName() + "' in " + SAO46.getClass(), var5);
         }
      }

   }

   public Object _/* $FF was: */(Field SAO46, Class SAO46) {
      Object SAO46 = null;
      if (.class.isAssignableFrom(SAO46) && !..class.isAssignableFrom(SAO46)) {
         try {
            SAO46 = (SAO46, );
            SAO46.(SAO46, SAO46);
         } catch (IllegalArgumentException var6) {
            String SAO46 = "Can't determine size of nested structure";
            throw new IllegalArgumentException(SAO46, var6);
         }
      } else if (.class.isAssignableFrom(SAO46)) {
          SAO46 = .(SAO46);
         SAO46 = SAO46.();
         SAO46.(SAO46, SAO46);
      }

      return SAO46;
   }

   public int _/* $FF was: */(int SAO46) {
      return SAO46.(SAO46, SAO46.);
   }

   public int _/* $FF was: */(int SAO46, int SAO46) {
      if (SAO46. != 1 && SAO46 % SAO46 != 0) {
         SAO46 += SAO46 - SAO46 % SAO46;
      }

      return SAO46;
   }

   public int __/* $FF was: */() {
      if (SAO46.size == -1) {
         SAO46.(true);
      }

      return SAO46.;
   }

   public int _/* $FF was: */(Class SAO46, Object SAO46, boolean SAO46) {
      int SAO46 = 1;
      if (.class.isAssignableFrom(SAO46)) {
          SAO46 = .(SAO46);
         SAO46 = SAO46.();
         SAO46 = SAO46.(SAO46, new ());
      }

      int SAO46 = Native.(SAO46, SAO46);
      if (!SAO46.isPrimitive() && Long.class != SAO46 && Integer.class != SAO46 && Short.class != SAO46 && Character.class != SAO46 && Byte.class != SAO46 && Boolean.class != SAO46 && Float.class != SAO46 && Double.class != SAO46) {
         if ((!Pointer.class.isAssignableFrom(SAO46) || Function.class.isAssignableFrom(SAO46)) && (!. || !Buffer.class.isAssignableFrom(SAO46)) && !Callback.class.isAssignableFrom(SAO46) && .class != SAO46 && String.class != SAO46) {
            if (.class.isAssignableFrom(SAO46)) {
               if (..class.isAssignableFrom(SAO46)) {
                  SAO46 = Pointer.;
               } else {
                  if (SAO46 == null) {
                     SAO46 = (SAO46, );
                  }

                  SAO46 = (()SAO46).();
               }
            } else {
               if (!SAO46.isArray()) {
                  throw new IllegalArgumentException("Type " + SAO46 + " has unknown native alignment");
               }

               SAO46 = SAO46.(SAO46.getComponentType(), (Object)null, SAO46);
            }
         } else {
            SAO46 = Pointer.;
         }
      } else {
         SAO46 = SAO46;
      }

      if (SAO46. == 1) {
         SAO46 = 1;
      } else if (SAO46. == 3) {
         SAO46 = Math.min(8, SAO46);
      } else if (SAO46. == 2) {
         if (!SAO46 || !.() || !.()) {
            SAO46 = Math.min(Native., SAO46);
         }

         if (!SAO46 && .() && (SAO46 == Double.TYPE || SAO46 == Double.class)) {
            SAO46 = 4;
         }
      }

      return SAO46;
   }

   public String toString() {
      return SAO46.(Boolean.getBoolean("jna.dump_memory"));
   }

   public String _/* $FF was: */(boolean SAO46) {
      return SAO46.(0, true, SAO46);
   }

   public String _/* $FF was: */(Class SAO46) {
      String SAO46 = SAO46.getName();
      int SAO46 = SAO46.lastIndexOf(".");
      return SAO46.substring(SAO46 + 1);
   }

   public String _/* $FF was: */(int SAO46, boolean SAO46, boolean SAO46) {
      SAO46.();
      String SAO46 = System.getProperty("line.separator");
      String SAO46 = SAO46.(SAO46.getClass()) + "(" + SAO46.() + ")";
      if (!(SAO46.() instanceof )) {
         SAO46 = SAO46 + " (" + SAO46.size() + " bytes)";
      }

      String SAO46 = "";

      for(int SAO46 = 0; SAO46 < SAO46; ++SAO46) {
         SAO46 = SAO46 + "  ";
      }

      String SAO46 = SAO46;
      if (!SAO46) {
         SAO46 = "...}";
      } else {
         Iterator SAO46 = SAO46.().values().iterator();

         while(SAO46.hasNext()) {
            . SAO46 = (.)SAO46.next();
            Object SAO46 = SAO46.(SAO46.);
            String SAO46 = SAO46.(SAO46.);
            String SAO46 = "";
            SAO46 = SAO46 + SAO46;
            if (SAO46..isArray() && SAO46 != null) {
               SAO46 = SAO46.(SAO46..getComponentType());
               SAO46 = "[" + Array.getLength(SAO46) + "]";
            }

            SAO46 = SAO46 + String.format("  %s %s%s@0x%X", SAO46, SAO46.name, SAO46, SAO46.offset);
            if (SAO46 instanceof ) {
               SAO46 = (()SAO46).(SAO46 + 1, !(SAO46 instanceof .), SAO46);
            }

            SAO46 = SAO46 + "=";
            if (SAO46 instanceof Long) {
               SAO46 = SAO46 + String.format("0x%08X", (Long)SAO46);
            } else if (SAO46 instanceof Integer) {
               SAO46 = SAO46 + String.format("0x%04X", (Integer)SAO46);
            } else if (SAO46 instanceof Short) {
               SAO46 = SAO46 + String.format("0x%02X", (Short)SAO46);
            } else if (SAO46 instanceof Byte) {
               SAO46 = SAO46 + String.format("0x%01X", (Byte)SAO46);
            } else {
               SAO46 = SAO46 + String.valueOf(SAO46).trim();
            }

            SAO46 = SAO46 + SAO46;
            if (!SAO46.hasNext()) {
               SAO46 = SAO46 + SAO46 + "}";
            }
         }
      }

      if (SAO46 == 0 && SAO46) {
         int SAO46 = 4;
         SAO46 = SAO46 + SAO46 + "memory dump" + SAO46;
         byte[] SAO46 = SAO46.().((long)344782939 ^ 344782939L, SAO46.size());

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46 % 4 == 0) {
               SAO46 = SAO46 + "[";
            }

            if (SAO46[SAO46] >= 0 && SAO46[SAO46] < 16) {
               SAO46 = SAO46 + "0";
            }

            SAO46 = SAO46 + Integer.toHexString(SAO46[SAO46] & 255);
            if (SAO46 % 4 == 3 && SAO46 < SAO46.length - 1) {
               SAO46 = SAO46 + "]" + SAO46;
            }
         }

         SAO46 = SAO46 + "]";
      }

      return SAO46 + " {" + SAO46;
   }

   public [] _/* $FF was: */([] SAO46) {
      SAO46.();
      if (SAO46. instanceof .) {
          SAO46 = ()SAO46.;
         int SAO46 = SAO46.length * SAO46.size();
         if (SAO46.() < (long)SAO46) {
            SAO46.((Pointer)SAO46.(SAO46));
         }
      }

      SAO46[0] = SAO46;
      int SAO46 = SAO46.size();

      for(int SAO46 = 1; SAO46 < SAO46.length; ++SAO46) {
         SAO46[SAO46] = (SAO46.getClass(), SAO46..((long)(SAO46 * SAO46), (long)SAO46));
         SAO46[SAO46].();
      }

      if (!(SAO46 instanceof .)) {
         SAO46. = SAO46;
      }

      return SAO46;
   }

   public [] toArray(int SAO46) {
      return SAO46.(([])Array.newInstance(SAO46.getClass(), SAO46));
   }

   public Class __/* $FF was: */() {
      return (SAO46 instanceof . || SAO46 instanceof .) && .class.isAssignableFrom(SAO46.getClass().getSuperclass()) ? SAO46.getClass().getSuperclass() : SAO46.getClass();
   }

   public boolean _/* $FF was: */( SAO46) {
      return SAO46.(SAO46, false);
   }

   public boolean _/* $FF was: */( SAO46, boolean SAO46) {
      if (SAO46) {
         SAO46.().((long)SAO46.size());
         SAO46.write();
         SAO46.().((long)SAO46.size());
         SAO46.write();
      }

      byte[] SAO46 = SAO46.().((long)643476129 ^ 643476129L, SAO46.size());
      byte[] SAO46 = SAO46.().((long)1162132525 ^ 1162132525L, SAO46.size());
      if (SAO46.length == SAO46.length) {
         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46[SAO46] != SAO46[SAO46]) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean equals(Object SAO46) {
      return SAO46 instanceof  && SAO46.getClass() == SAO46.getClass() && (()SAO46).().equals(SAO46.());
   }

   public int hashCode() {
      Pointer SAO46 = SAO46.();
      return SAO46 != null ? SAO46.().hashCode() : SAO46.getClass().hashCode();
   }

   public void _/* $FF was: */(Pointer SAO46) {
      SAO46. = SAO46.;
   }

   public Pointer _/* $FF was: */(. SAO46) {
      Class SAO46 = SAO46.;
      Object SAO46 = SAO46.(SAO46.);
      if (SAO46. != null) {
         ToNativeConverter SAO46 = SAO46..(SAO46);
         if (SAO46 != null) {
            SAO46 = SAO46.();
            SAO46 = SAO46.(SAO46, new ());
         }
      }

      return ..(SAO46, SAO46);
   }

   public Pointer _/* $FF was: */() {
      Pointer SAO46 = ((Object)SAO46);
      SAO46.(SAO46);
      return SAO46;
   }

   public void __/* $FF was: */(boolean SAO46) {
      SAO46.(SAO46);
      SAO46.(SAO46);
   }

   public void __/* $FF was: */(boolean SAO46) {
      SAO46. = SAO46;
   }

   public boolean ___/* $FF was: */() {
      return SAO46.;
   }

   public void __/* $FF was: */(boolean SAO46) {
      SAO46. = SAO46;
   }

   public boolean ___/* $FF was: */() {
      return SAO46.;
   }

   public static Pointer _/* $FF was: */(Object SAO46) {
      return ..(SAO46);
   }

   public static  _/* $FF was: */(Class SAO46, long SAO46) {
      try {
          SAO46 = (SAO46, SAO46 == ((long)1696394030 ^ 1696394030L) ?  : new Pointer(SAO46));
         if (SAO46 != ((long)-1925346771 ^ -1925346771L)) {
            SAO46.();
         }

         return SAO46;
      } catch (Throwable var4) {
         System.err.println("JNA: Error creating structure: " + var4);
         return null;
      }
   }

   public static  _/* $FF was: */(Class SAO46, Pointer SAO46) throws IllegalArgumentException {
      try {
         Constructor SAO46 = SAO46.getConstructor(Pointer.class);
         return ()SAO46.newInstance(SAO46);
      } catch (NoSuchMethodException var4) {
         ;
      } catch (SecurityException var5) {
         ;
      } catch (InstantiationException var6) {
         String SAO46 = "Can't instantiate " + SAO46;
         throw new IllegalArgumentException(SAO46, var6);
      } catch (IllegalAccessException var7) {
         String SAO46 = "Instantiation of " + SAO46 + " (Pointer) not allowed, is it public?";
         throw new IllegalArgumentException(SAO46, var7);
      } catch (InvocationTargetException var8) {
         String SAO46 = "Exception thrown while instantiating an instance of " + SAO46;
         var8.printStackTrace();
         throw new IllegalArgumentException(SAO46, var8);
      }

       SAO46 = (SAO46);
      if (SAO46 != ) {
         SAO46.(SAO46);
      }

      return SAO46;
   }

   public static  _/* $FF was: */(Class SAO46) throws IllegalArgumentException {
      try {
          SAO46 = ()SAO46.newInstance();
         if (SAO46 instanceof .) {
            SAO46.();
         }

         return SAO46;
      } catch (InstantiationException var3) {
         String SAO46 = "Can't instantiate " + SAO46;
         throw new IllegalArgumentException(SAO46, var3);
      } catch (IllegalAccessException var4) {
         String SAO46 = "Instantiation of " + SAO46 + " not allowed, is it public?";
         throw new IllegalArgumentException(SAO46, var4);
      }
   }

   public . _/* $FF was: */() {
      . SAO46;
      synchronized() {
         SAO46 = (.).get(SAO46.getClass());
      }

      return SAO46 != null ? SAO46. : null;
   }

   public static void _/* $FF was: */([] SAO46) {
      if (!.[].class.isAssignableFrom(SAO46.getClass())) {
         Pointer SAO46 = SAO46[0].();
         int SAO46 = SAO46[0].size();

         for(int SAO46 = 1; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46[SAO46].(). != SAO46. + (long)(SAO46 * SAO46)) {
               String SAO46 = "Structure array elements must use contiguous memory (bad backing address at Structure array index " + SAO46 + ")";
               throw new IllegalArgumentException(SAO46);
            }
         }

      }
   }

   public static void _/* $FF was: */([] SAO46) {
      (SAO46);
      if (SAO46[0]. == SAO46) {
         SAO46[0].();
      } else {
         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46[SAO46] != null) {
               SAO46[SAO46].();
            }
         }
      }

   }

   public void ___/* $FF was: */() {
      if (SAO46.()) {
         SAO46.read();
         if (SAO46. != null) {
            for(int SAO46 = 1; SAO46 < SAO46..length; ++SAO46) {
               SAO46.[SAO46].();
            }
         }
      }

   }

   public static void _/* $FF was: */([] SAO46) {
      (SAO46);
      if (SAO46[0]. == SAO46) {
         SAO46[0].();
      } else {
         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            if (SAO46[SAO46] != null) {
               SAO46[SAO46].();
            }
         }
      }

   }

   public void ___/* $FF was: */() {
      if (SAO46.()) {
         SAO46.write();
         if (SAO46. != null) {
            for(int SAO46 = 1; SAO46 < SAO46..length; ++SAO46) {
               SAO46.[SAO46].();
            }
         }
      }

   }

   public int _/* $FF was: */(Class SAO46) {
      return SAO46.(SAO46, (Object)null);
   }

   public int _/* $FF was: */(Class SAO46, Object SAO46) {
      return Native.(SAO46, SAO46);
   }

   public static void _/* $FF was: */(Class SAO46) {
      (SAO46, );
   }

   public static void _/* $FF was: */( SAO46, boolean SAO46) {
      SAO46.(SAO46);
   }

   public static Pointer __/* $FF was: */() {
      return ;
   }

   public interface  {
   }

   static class  extends AbstractCollection implements Set {
      public [] ;
      public int count;

      public void __/* $FF was: */(int SAO46) {
         if (SAO46. == null) {
            SAO46. = new [SAO46 * 3 / 2];
         } else if (SAO46..length < SAO46) {
            [] SAO46 = new [SAO46 * 3 / 2];
            System.arraycopy(SAO46., 0, SAO46, 0, SAO46..length);
            SAO46. = SAO46;
         }

      }

      public [] _/* $FF was: */() {
         return SAO46.;
      }

      public int size() {
         return SAO46.count;
      }

      public boolean contains(Object SAO46) {
         return SAO46.(()SAO46) != -1;
      }

      public boolean _/* $FF was: */( SAO46) {
         if (!SAO46.contains(SAO46)) {
            SAO46.(SAO46.count + 1);
            SAO46.[SAO46.count++] = SAO46;
         }

         return true;
      }

      public int _/* $FF was: */( SAO46) {
         for(int SAO46 = 0; SAO46 < SAO46.count; ++SAO46) {
             SAO46 = SAO46.[SAO46];
            if (SAO46 == SAO46 || SAO46.getClass() == SAO46.getClass() && SAO46.size() == SAO46.size() && SAO46.().equals(SAO46.())) {
               return SAO46;
            }
         }

         return -1;
      }

      public boolean remove(Object SAO46) {
         int SAO46 = SAO46.(()SAO46);
         if (SAO46 != -1) {
            if (--SAO46.count >= 0) {
               SAO46.[SAO46] = SAO46.[SAO46.count];
               SAO46.[SAO46.count] = null;
            }

            return true;
         } else {
            return false;
         }
      }

      public Iterator iterator() {
         [] SAO46 = new [SAO46.count];
         if (SAO46.count > 0) {
            System.arraycopy(SAO46., 0, SAO46, 0, SAO46.count);
         }

         return Arrays.asList(SAO46).iterator();
      }

      public boolean add(Object var1) {
         return SAO46.(()var1);
      }
   }

   public interface  {
   }

   private static class  extends  {
      public _/* $FF was: */(int SAO46) {
         super((long)SAO46);
         super.clear();
      }

      public String toString() {
         return "auto-" + super.toString();
      }
   }

   private static class  {
      public int size;
      public int ;
      public Map fields;
      public int ;
      public  ;
      public boolean ;
      public . ;

      public __/* $FF was: */() {
         SAO46.size = -1;
         SAO46. = 1;
         SAO46.fields = Collections.synchronizedMap(new LinkedHashMap());
         SAO46. = 0;
      }

      public static boolean _/* $FF was: */(. SAO46) {
         return SAO46.;
      }

      public static int _/* $FF was: */(. SAO46) {
         return SAO46.size;
      }

      public static int _/* $FF was: */(. SAO46) {
         return SAO46.;
      }

      public static  _/* $FF was: */(. SAO46) {
         return SAO46.;
      }

      public static int _/* $FF was: */(. SAO46) {
         return SAO46.;
      }

      public static Map _/* $FF was: */(. SAO46) {
         return SAO46.fields;
      }

      public __/* $FF was: */(Object SAO46) {
         this();
      }

      public static int _/* $FF was: */(. SAO46, int SAO46) {
         return SAO46. = SAO46;
      }

      public static  _/* $FF was: */(. SAO46,  SAO46) {
         return SAO46. = SAO46;
      }

      public static boolean _/* $FF was: */(. SAO46, boolean SAO46) {
         return SAO46. = SAO46;
      }

      public static int _/* $FF was: */(. SAO46, int SAO46) {
         return SAO46. = SAO46;
      }

      public static . _/* $FF was: */(. SAO46) {
         return SAO46.;
      }

      public static . _/* $FF was: */(. SAO46, . SAO46) {
         return SAO46. = SAO46;
      }

      public static int _/* $FF was: */(. SAO46, int SAO46) {
         return SAO46.size = SAO46;
      }
   }

   protected static class  {
      public String name;
      public Class ;
      public Field ;
      public int size = -1;
      public int offset = -1;
      public boolean ;
      public boolean ;
      public FromNativeConverter ;
      public ToNativeConverter ;
      public  ;

      public String toString() {
         return SAO46.name + "@" + SAO46.offset + "[" + SAO46.size + "] (" + SAO46. + ")";
      }
   }

   static class  extends  {
      public static Map  = new WeakHashMap();
      public static int  = 13;
      public .. ;
      public short ;
      public short  = 13;
      public Pointer ;

      public __/* $FF was: */( SAO46) {
         SAO46.(true);
         Pointer[] SAO46;
         if (SAO46 instanceof ) {
            . SAO46 = (()SAO46).();
            SAO46 = new Pointer[]{(SAO46.(SAO46.), SAO46.), null};
         } else {
            SAO46 = new Pointer[SAO46.().size() + 1];
            int SAO46 = 0;

            for(. SAO46 : SAO46.().values()) {
               SAO46[SAO46++] = SAO46.(SAO46);
            }
         }

         SAO46.(SAO46);
      }

      public __/* $FF was: */(Object SAO46, Class SAO46) {
         int SAO46 = Array.getLength(SAO46);
         Pointer[] SAO46 = new Pointer[SAO46 + 1];
         Pointer SAO46 = ((Object)null, SAO46.getComponentType());

         for(int SAO46 = 0; SAO46 < SAO46; ++SAO46) {
            SAO46[SAO46] = SAO46;
         }

         SAO46.(SAO46);
      }

      public List _/* $FF was: */() {
         return Arrays.asList("size", "alignment", "type", "elements");
      }

      public void _/* $FF was: */(Pointer[] SAO46) {
         SAO46. = new ((long)(Pointer. * SAO46.length));
         SAO46..((long)-1946119082 ^ -1946119082L, SAO46, 0, SAO46.length);
         SAO46.write();
      }

      public static Pointer _/* $FF was: */(Object SAO46) {
         if (SAO46 == null) {
            return ...;
         } else {
            return SAO46 instanceof Class ? ((Object)null, (Class)SAO46) : (SAO46, SAO46.getClass());
         }
      }

      public static Pointer _/* $FF was: */(Object SAO46, Class SAO46) {
          SAO46 = Native.(SAO46);
         if (SAO46 != null) {
            ToNativeConverter SAO46 = SAO46.(SAO46);
            if (SAO46 != null) {
               SAO46 = SAO46.();
            }
         }

         synchronized() {
            Object SAO46 = .get(SAO46);
            if (SAO46 instanceof Pointer) {
               return (Pointer)SAO46;
            } else if (SAO46 instanceof .) {
               return ((.)SAO46).();
            } else if ((!. || !Buffer.class.isAssignableFrom(SAO46)) && !Callback.class.isAssignableFrom(SAO46)) {
               if (.class.isAssignableFrom(SAO46)) {
                  if (SAO46 == null) {
                     SAO46 = (SAO46, .);
                  }

                  if (..class.isAssignableFrom(SAO46)) {
                     .put(SAO46, ...);
                     return ...;
                  } else {
                     . SAO46 = new .(()SAO46);
                     .put(SAO46, SAO46);
                     return SAO46.();
                  }
               } else if (.class.isAssignableFrom(SAO46)) {
                   SAO46 = .(SAO46);
                  return (SAO46.(SAO46, new ()), SAO46.());
               } else if (SAO46.isArray()) {
                  . SAO46 = new .(SAO46, SAO46);
                  .put(SAO46, SAO46);
                  return SAO46.();
               } else {
                  throw new IllegalArgumentException("Unsupported type " + SAO46);
               }
            } else {
               .put(SAO46, ...);
               return ...;
            }
         }
      }

      public static Pointer _/* $FF was: */(Object SAO46, Class SAO46) {
         return (SAO46, SAO46);
      }

      static {
         if (Native. == 0) {
            throw new Error("Native library not initialized");
         } else if (... == null) {
            throw new Error("FFI types not initialized");
         } else {
            .put(Void.TYPE, ...);
            .put(Void.class, ...);
            .put(Float.TYPE, ...);
            .put(Float.class, ...);
            .put(Double.TYPE, ...);
            .put(Double.class, ...);
            .put(Long.TYPE, ...);
            .put(Long.class, ...);
            .put(Integer.TYPE, ...);
            .put(Integer.class, ...);
            .put(Short.TYPE, ...);
            .put(Short.class, ...);
            Pointer SAO46 = Native. == 2 ? ... : ...;
            .put(Character.TYPE, SAO46);
            .put(Character.class, SAO46);
            .put(Byte.TYPE, ...);
            .put(Byte.class, ...);
            .put(Pointer.class, ...);
            .put(String.class, ...);
            .put(.class, ...);
            .put(Boolean.TYPE, ...);
            .put(Boolean.class, ...);
         }
      }

      public static class  extends  {
         public static long serialVersionUID = (long)-850950275 ^ -850950276L;

         public _/* $FF was: */() {
            this((long)-942664048 ^ -942664048L);
         }

         public _/* $FF was: */(long SAO46) {
            super(Native., SAO46);
         }
      }

      private static class  {
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;
         public static Pointer ;

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer __/* $FF was: */() {
            return ;
         }

         public static Pointer ___/* $FF was: */() {
            return ;
         }

         public static Pointer ___/* $FF was: */() {
            return ;
         }
      }
   }
}
