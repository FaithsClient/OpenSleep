package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Group {
   String name() default "";

   int min() default -1;

   int max() default -1;
}
