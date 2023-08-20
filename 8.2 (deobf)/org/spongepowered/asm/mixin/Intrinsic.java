package org.spongepowered.asm.mixin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Intrinsic {
   boolean displace() default false;
}
