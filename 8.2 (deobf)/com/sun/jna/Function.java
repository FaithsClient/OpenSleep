package com.sun.jna;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public class Function extends Pointer {
   public static int  = 256;
   public static int  = 0;
   public static int  = 63;
   public static int  = 63;
   public static int  = 64;
   public static int  = 384;
   public static Integer  = Integer.valueOf(-1);
   public static Integer  = Integer.valueOf(0);
   public  ;
   public String ;
   public String ;
   public int ;
   public Map options;
   public static String  = "invoking-method";
   public static   = .();

   public static Function _/* $FF was: */(String SAO46, String SAO46) {
      return .(SAO46).(SAO46);
   }

   public static Function _/* $FF was: */(String SAO46, String SAO46, int SAO46) {
      return .(SAO46).(SAO46, SAO46, (String)null);
   }

   public static Function _/* $FF was: */(String SAO46, String SAO46, int SAO46, String SAO46) {
      return .(SAO46).(SAO46, SAO46, SAO46);
   }

   public static Function _/* $FF was: */(Pointer SAO46) {
      return (SAO46, 0, (String)null);
   }

   public static Function _/* $FF was: */(Pointer SAO46, int SAO46) {
      return (SAO46, SAO46, (String)null);
   }

   public static Function _/* $FF was: */(Pointer SAO46, int SAO46, String SAO46) {
      return new Function(SAO46, SAO46, SAO46);
   }

   public Function( SAO46, String SAO46, int SAO46, String SAO46) {
      SAO46.(SAO46 & 63);
      if (SAO46 == null) {
         throw new NullPointerException("Function name must not be null");
      } else {
         SAO46. = SAO46;
         SAO46. = SAO46;
         SAO46. = SAO46;
         SAO46.options = SAO46.options;
         SAO46. = SAO46 != null ? SAO46 : Native.();

         try {
            SAO46. = SAO46.(SAO46);
         } catch (UnsatisfiedLinkError var6) {
            throw new UnsatisfiedLinkError("Error looking up function '" + SAO46 + "': " + var6.getMessage());
         }
      }
   }

   public Function(Pointer SAO46, int SAO46, String SAO46) {
      SAO46.(SAO46 & 63);
      if (SAO46 != null && SAO46. != ((long)367334629 ^ 367334629L)) {
         SAO46. = SAO46.toString();
         SAO46. = SAO46;
         SAO46. = SAO46.;
         SAO46.options = Collections.EMPTY_MAP;
         SAO46. = SAO46 != null ? SAO46 : Native.();
      } else {
         throw new NullPointerException("Function address may not be null");
      }
   }

   public void _/* $FF was: */(int SAO46) throws IllegalArgumentException {
      if ((SAO46 & 63) != SAO46) {
         throw new IllegalArgumentException("Unrecognized calling convention: " + SAO46);
      }
   }

   public String getName() {
      return SAO46.;
   }

   public int _/* $FF was: */() {
      return SAO46. & 63;
   }

   public Object _/* $FF was: */(Class SAO46, Object[] SAO46) {
      return SAO46.(SAO46, SAO46, SAO46.options);
   }

   public Object _/* $FF was: */(Class SAO46, Object[] SAO46, Map SAO46) {
      Method SAO46 = (Method)SAO46.get("invoking-method");
      Class[] SAO46 = SAO46 != null ? SAO46.getParameterTypes() : null;
      return SAO46.(SAO46, SAO46, SAO46, SAO46, SAO46);
   }

   public Object _/* $FF was: */(Method SAO46, Class[] SAO46, Class SAO46, Object[] SAO46, Map SAO46) {
      Object[] SAO46 = new Object[0];
      if (SAO46 != null) {
         if (SAO46.length > 256) {
            throw new UnsupportedOperationException("Maximum argument count is 256");
         }

         SAO46 = new Object[SAO46.length];
         System.arraycopy(SAO46, 0, SAO46, 0, SAO46.length);
      }

       SAO46 = ()SAO46.get("type-mapper");
      boolean SAO46 = Boolean.TRUE.equals(SAO46.get("allow-objects"));
      boolean SAO46 = SAO46.length > 0 && SAO46 != null ? (SAO46) : false;
      int SAO46 = SAO46.length > 0 && SAO46 != null ? (SAO46) : 0;

      for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
         Class SAO46 = SAO46 != null ? (SAO46 && SAO46 >= SAO46.length - 1 ? SAO46[SAO46.length - 1].getComponentType() : SAO46[SAO46]) : null;
         SAO46[SAO46] = SAO46.(SAO46, SAO46, SAO46, SAO46, SAO46, SAO46);
      }

      Class SAO46 = SAO46;
      FromNativeConverter SAO46 = null;
      if (.class.isAssignableFrom(SAO46)) {
          SAO46 = .(SAO46);
         SAO46 = SAO46;
         SAO46 = SAO46.();
      } else if (SAO46 != null) {
         SAO46 = SAO46.(SAO46);
         if (SAO46 != null) {
            SAO46 = SAO46.();
         }
      }

      Object SAO46 = SAO46.(SAO46, SAO46, SAO46, SAO46);
      if (SAO46 != null) {
          SAO46;
         if (SAO46 != null) {
            SAO46 = new (SAO46, SAO46, SAO46, SAO46);
         } else {
            SAO46 = new (SAO46, SAO46, SAO46);
         }

         SAO46 = SAO46.fromNative(SAO46, SAO46);
      }

      if (SAO46 != null) {
         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            Object SAO46 = SAO46[SAO46];
            if (SAO46 != null) {
               if (SAO46 instanceof ) {
                  if (!(SAO46 instanceof .)) {
                     (()SAO46).();
                  }
               } else if (SAO46[SAO46] instanceof Function.) {
                  ((Function.)SAO46[SAO46]).read();
                  if (SAO46[SAO46] instanceof Function.) {
                     Function. SAO46 = (Function.)SAO46[SAO46];
                     if (.[].class.isAssignableFrom(SAO46.getClass())) {
                        Class SAO46 = SAO46.getClass().getComponentType();
                        [] SAO46 = ([])SAO46;

                        for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
                           Pointer SAO46 = SAO46.((long)(Pointer. * SAO46));
                           SAO46[SAO46] = .(SAO46, SAO46[SAO46], SAO46);
                        }
                     }
                  }
               } else if ([].class.isAssignableFrom(SAO46.getClass())) {
                  .(([])SAO46);
               }
            }
         }
      }

      return SAO46;
   }

   public Object _/* $FF was: */(Object[] SAO46, Class SAO46, boolean SAO46) {
      return SAO46.(SAO46, SAO46, SAO46, 0);
   }

   public Object _/* $FF was: */(Object[] SAO46, Class SAO46, boolean SAO46, int SAO46) {
      Object SAO46 = null;
      int SAO46 = SAO46. | (SAO46 & 3) << 7;
      if (SAO46 != null && SAO46 != Void.TYPE && SAO46 != Void.class) {
         if (SAO46 != Boolean.TYPE && SAO46 != Boolean.class) {
            if (SAO46 != Byte.TYPE && SAO46 != Byte.class) {
               if (SAO46 != Short.TYPE && SAO46 != Short.class) {
                  if (SAO46 != Character.TYPE && SAO46 != Character.class) {
                     if (SAO46 != Integer.TYPE && SAO46 != Integer.class) {
                        if (SAO46 != Long.TYPE && SAO46 != Long.class) {
                           if (SAO46 != Float.TYPE && SAO46 != Float.class) {
                              if (SAO46 != Double.TYPE && SAO46 != Double.class) {
                                 if (SAO46 == String.class) {
                                    SAO46 = SAO46.(SAO46, SAO46, false);
                                 } else if (SAO46 == .class) {
                                    String SAO46 = SAO46.(SAO46, SAO46, true);
                                    if (SAO46 != null) {
                                       SAO46 = new (SAO46);
                                    }
                                 } else {
                                    if (Pointer.class.isAssignableFrom(SAO46)) {
                                       return SAO46.(SAO46, SAO46);
                                    }

                                    if (.class.isAssignableFrom(SAO46)) {
                                       if (..class.isAssignableFrom(SAO46)) {
                                           SAO46 = Native.(SAO46, SAO46., SAO46, SAO46, .(SAO46));
                                          SAO46.();
                                          SAO46 = SAO46;
                                       } else {
                                          SAO46 = SAO46.(SAO46, SAO46);
                                          if (SAO46 != null) {
                                              SAO46 = .(SAO46, (Pointer)SAO46);
                                             SAO46.();
                                             SAO46 = SAO46;
                                          }
                                       }
                                    } else if (Callback.class.isAssignableFrom(SAO46)) {
                                       SAO46 = SAO46.(SAO46, SAO46);
                                       if (SAO46 != null) {
                                          SAO46 = com.sun.jna..(SAO46, (Pointer)SAO46);
                                       }
                                    } else if (SAO46 == String[].class) {
                                       Pointer SAO46 = SAO46.(SAO46, SAO46);
                                       if (SAO46 != null) {
                                          SAO46 = SAO46.((long)383778079 ^ 383778079L, SAO46.);
                                       }
                                    } else if (SAO46 == [].class) {
                                       Pointer SAO46 = SAO46.(SAO46, SAO46);
                                       if (SAO46 != null) {
                                          String[] SAO46 = SAO46.((long)1668370287 ^ 1668370287L);
                                          [] SAO46 = new [SAO46.length];

                                          for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
                                             SAO46[SAO46] = new (SAO46[SAO46]);
                                          }

                                          SAO46 = SAO46;
                                       }
                                    } else if (SAO46 == Pointer[].class) {
                                       Pointer SAO46 = SAO46.(SAO46, SAO46);
                                       if (SAO46 != null) {
                                          SAO46 = SAO46.((long)369184230 ^ 369184230L);
                                       }
                                    } else {
                                       if (!SAO46) {
                                          throw new IllegalArgumentException("Unsupported return type " + SAO46 + " in function " + SAO46.getName());
                                       }

                                       SAO46 = Native.invokeObject(SAO46, SAO46., SAO46, SAO46);
                                       if (SAO46 != null && !SAO46.isAssignableFrom(SAO46.getClass())) {
                                          throw new ClassCastException("Return type " + SAO46 + " does not match result " + SAO46.getClass());
                                       }
                                    }
                                 }
                              } else {
                                 SAO46 = Native.invokeDouble(SAO46, SAO46., SAO46, SAO46);
                              }
                           } else {
                              SAO46 = Native.invokeFloat(SAO46, SAO46., SAO46, SAO46);
                           }
                        } else {
                           SAO46 = Native.invokeLong(SAO46, SAO46., SAO46, SAO46);
                        }
                     } else {
                        SAO46 = Native.invokeInt(SAO46, SAO46., SAO46, SAO46);
                     }
                  } else {
                     SAO46 = (char)Native.invokeInt(SAO46, SAO46., SAO46, SAO46);
                  }
               } else {
                  SAO46 = (short)Native.invokeInt(SAO46, SAO46., SAO46, SAO46);
               }
            } else {
               SAO46 = (byte)Native.invokeInt(SAO46, SAO46., SAO46, SAO46);
            }
         } else {
            SAO46 = (Native.invokeInt(SAO46, SAO46., SAO46, SAO46) != 0);
         }
      } else {
         Native.invokeVoid(SAO46, SAO46., SAO46, SAO46);
         SAO46 = null;
      }

      return SAO46;
   }

   public Pointer _/* $FF was: */(int SAO46, Object[] SAO46) {
      long SAO46 = Native.invokePointer(SAO46, SAO46., SAO46, SAO46);
      return SAO46 == ((long)795261873 ^ 795261873L) ? null : new Pointer(SAO46);
   }

   public Object _/* $FF was: */(Object[] SAO46, int SAO46, Method SAO46,  SAO46, boolean SAO46, Class SAO46) {
      Object SAO46 = SAO46[SAO46];
      if (SAO46 != null) {
         Class SAO46 = SAO46.getClass();
         ToNativeConverter SAO46 = null;
         if (.class.isAssignableFrom(SAO46)) {
            SAO46 = .(SAO46);
         } else if (SAO46 != null) {
            SAO46 = SAO46.(SAO46);
         }

         if (SAO46 != null) {
             SAO46;
            if (SAO46 != null) {
               SAO46 = new (SAO46, SAO46, SAO46, SAO46);
            } else {
               SAO46 = new (SAO46, SAO46, SAO46);
            }

            SAO46 = SAO46.(SAO46, SAO46);
         }
      }

      if (SAO46 != null && !SAO46.(SAO46.getClass())) {
         Class SAO46 = SAO46.getClass();
         if (SAO46 instanceof ) {
             SAO46 = ()SAO46;
            SAO46.();
            if (SAO46 instanceof .) {
               Class SAO46 = SAO46.getClass();
               if (SAO46 != null) {
                  Class[] SAO46 = SAO46.getParameterTypes();
                  if (.(SAO46)) {
                     if (SAO46 < SAO46.length - 1) {
                        SAO46 = SAO46[SAO46];
                     } else {
                        Class SAO46 = SAO46[SAO46.length - 1].getComponentType();
                        if (SAO46 != Object.class) {
                           SAO46 = SAO46;
                        }
                     }
                  } else {
                     SAO46 = SAO46[SAO46];
                  }
               }

               if (..class.isAssignableFrom(SAO46)) {
                  return SAO46;
               }
            }

            return SAO46.();
         } else if (SAO46 instanceof Callback) {
            return com.sun.jna..((Callback)SAO46);
         } else if (SAO46 instanceof String) {
            return (new ((String)SAO46, false)).();
         } else if (SAO46 instanceof ) {
            return (new (SAO46.toString(), true)).();
         } else if (SAO46 instanceof Boolean) {
            return Boolean.TRUE.equals(SAO46) ?  : ;
         } else if (String[].class == SAO46) {
            return new ((String[])SAO46, SAO46.);
         } else if ([].class == SAO46) {
            return new (([])SAO46);
         } else if (Pointer[].class == SAO46) {
            return new Function.((Pointer[])SAO46);
         } else if ([].class.isAssignableFrom(SAO46)) {
            return new Function.(([])SAO46);
         } else if (![].class.isAssignableFrom(SAO46)) {
            if (SAO46.isArray()) {
               throw new IllegalArgumentException("Unsupported array argument type: " + SAO46.getComponentType());
            } else if (SAO46) {
               return SAO46;
            } else if (!Native.(SAO46.getClass())) {
               throw new IllegalArgumentException("Unsupported argument type " + SAO46.getClass().getName() + " at parameter " + SAO46 + " of function " + SAO46.getName());
            } else {
               return SAO46;
            }
         } else {
            [] SAO46 = ([])SAO46;
            Class SAO46 = SAO46.getComponentType();
            boolean SAO46 = ..class.isAssignableFrom(SAO46);
            if (SAO46 != null && !.[].class.isAssignableFrom(SAO46)) {
               if (SAO46) {
                  throw new IllegalArgumentException("Function " + SAO46.getName() + " declared Structure[] at parameter " + SAO46 + " but array of " + SAO46 + " was passed");
               }

               for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
                  if (SAO46[SAO46] instanceof .) {
                     throw new IllegalArgumentException("Function " + SAO46.getName() + " declared Structure[] at parameter " + SAO46 + " but element " + SAO46 + " is of Structure.ft.sleep.util.reflect.ByReference type");
                  }
               }
            }

            if (SAO46) {
               .(SAO46);
               Pointer[] SAO46 = new Pointer[SAO46.length + 1];

               for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
                  SAO46[SAO46] = SAO46[SAO46] != null ? SAO46[SAO46].() : null;
               }

               return new Function.(SAO46);
            } else if (SAO46.length == 0) {
               throw new IllegalArgumentException("Structure array must have non-zero length");
            } else if (SAO46[0] == null) {
               .(SAO46).(SAO46);
               return SAO46[0].();
            } else {
               .(SAO46);
               return SAO46[0].();
            }
         }
      } else {
         return SAO46;
      }
   }

   public boolean _/* $FF was: */(Class SAO46) {
      return SAO46.isArray() && SAO46.getComponentType().isPrimitive();
   }

   public void _/* $FF was: */(Object[] SAO46) {
      SAO46.(Void.class, SAO46);
   }

   public String _/* $FF was: */(int SAO46, Object[] SAO46, boolean SAO46) {
      Pointer SAO46 = SAO46.(SAO46, SAO46);
      String SAO46 = null;
      if (SAO46 != null) {
         if (SAO46) {
            SAO46 = SAO46.((long)-1583211629 ^ -1583211629L);
         } else {
            SAO46 = SAO46.((long)-1375579242 ^ -1375579242L, SAO46.);
         }
      }

      return SAO46;
   }

   public String toString() {
      return SAO46. != null ? "native function " + SAO46. + "(" + SAO46..getName() + ")@0x" + Long.toHexString(SAO46.) : "native function@0x" + Long.toHexString(SAO46.);
   }

   public Object _/* $FF was: */(Object[] SAO46) {
      return SAO46.(Object.class, SAO46);
   }

   public Pointer _/* $FF was: */(Object[] SAO46) {
      return (Pointer)SAO46.(Pointer.class, SAO46);
   }

   public String _/* $FF was: */(Object[] SAO46, boolean SAO46) {
      Object SAO46 = SAO46.(SAO46 ? .class : String.class, SAO46);
      return SAO46 != null ? SAO46.toString() : null;
   }

   public int _/* $FF was: */(Object[] SAO46) {
      return ((Integer)SAO46.(Integer.class, SAO46)).intValue();
   }

   public long _/* $FF was: */(Object[] SAO46) {
      return ((Long)SAO46.(Long.class, SAO46)).longValue();
   }

   public float _/* $FF was: */(Object[] SAO46) {
      return ((Float)SAO46.(Float.class, SAO46)).floatValue();
   }

   public double _/* $FF was: */(Object[] SAO46) {
      return ((Double)SAO46.(Double.class, SAO46)).doubleValue();
   }

   public void _/* $FF was: */(Object[] SAO46) {
      SAO46.(Void.class, SAO46);
   }

   public boolean equals(Object SAO46) {
      if (SAO46 == SAO46) {
         return true;
      } else if (SAO46 == null) {
         return false;
      } else if (SAO46.getClass() != SAO46.getClass()) {
         return false;
      } else {
         Function SAO46 = (Function)SAO46;
         return SAO46. == SAO46. && SAO46.options.equals(SAO46.options) && SAO46. == SAO46.;
      }
   }

   public int hashCode() {
      return SAO46. + SAO46.options.hashCode() + super.hashCode();
   }

   public static Object[] _/* $FF was: */(Object[] SAO46) {
      if (SAO46 != null && SAO46.length > 0) {
         Object SAO46 = SAO46[SAO46.length - 1];
         Class SAO46 = SAO46 != null ? SAO46.getClass() : null;
         if (SAO46 != null && SAO46.isArray()) {
            Object[] SAO46 = SAO46;

            for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
               if (SAO46[SAO46] instanceof Float) {
                  SAO46[SAO46] = (double)((Float)SAO46[SAO46]).floatValue();
               }
            }

            Object[] SAO46 = new Object[SAO46.length + SAO46.length];
            System.arraycopy(SAO46, 0, SAO46, 0, SAO46.length - 1);
            System.arraycopy(SAO46, 0, SAO46, SAO46.length - 1, SAO46.length);
            SAO46[SAO46.length - 1] = null;
            SAO46 = SAO46;
         }
      }

      return SAO46;
   }

   public static boolean _/* $FF was: */(Method SAO46) {
      return .(SAO46);
   }

   public static int _/* $FF was: */(Method SAO46) {
      return .(SAO46);
   }

   public static Boolean _/* $FF was: */(boolean SAO46) {
      return SAO46 ? Boolean.TRUE : Boolean.FALSE;
   }

   private static class  extends  implements Function. {
      public Pointer[] ;

      public _/* $FF was: */(Pointer[] SAO46) {
         super((long)(Pointer. * (SAO46.length + 1)));
         SAO46. = SAO46;

         for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
            SAO46.((long)(SAO46 * Pointer.), SAO46[SAO46]);
         }

         SAO46.((long)(Pointer. * SAO46.length), (Pointer)null);
      }

      public void read() {
         SAO46.((long)-1710156038 ^ -1710156038L, SAO46., 0, SAO46..length);
      }
   }

   public interface  {
      void read();
   }

   private static class  extends  implements Function. {
      public [] ;

      public _/* $FF was: */([] SAO46) {
         super((long)Native.(SAO46.getClass(), SAO46));
         SAO46. = SAO46;
         SAO46.((long)-2074416616 ^ -2074416616L, SAO46., SAO46..getClass());
      }

      public void read() {
         SAO46.((long)-597277082 ^ -597277082L, SAO46..getClass(), SAO46.);
      }
   }
}
