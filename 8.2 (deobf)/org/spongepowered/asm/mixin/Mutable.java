package org.spongepowered.asm.mixin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mutable {
}
