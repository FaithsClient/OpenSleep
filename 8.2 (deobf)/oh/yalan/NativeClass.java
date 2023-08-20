package oh.yalan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NativeClass {
}
