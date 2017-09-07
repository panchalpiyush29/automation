package nz.co.automation.rest.annotation.beanpostprocessor;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutocreateLog {
}
