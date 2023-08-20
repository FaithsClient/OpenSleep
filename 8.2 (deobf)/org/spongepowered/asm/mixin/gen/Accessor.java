package org.spongepowered.asm.mixin.gen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Accessor {
   String value() default "";

   boolean remap() default true;
}
