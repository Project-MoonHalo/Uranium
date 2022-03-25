package MoonHalo.Uranium.Others;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {
    String ModName() default " ";
    ModuleType type() default ModuleType.Hidden;
    String info() default " ";
}
