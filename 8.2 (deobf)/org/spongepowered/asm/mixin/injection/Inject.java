package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@java.lang.annotation.Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
   String id() default "";

   String[] method();

   Slice[] slice() default {};

   At[] at();

   boolean cancellable() default false;

   LocalCapture locals() default LocalCapture.NO_CAPTURE;

   boolean remap() default true;

   int require() default -1;

   int expect() default 1;

   int allow() default -1;

   String constraints() default "";
}
