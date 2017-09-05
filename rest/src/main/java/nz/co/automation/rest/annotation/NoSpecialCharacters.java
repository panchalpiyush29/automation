package nz.co.automation.rest.annotation;

import nz.co.automation.rest.annotation.hibernate.constraint.NoSpecialCharactersConstraint;
import org.springframework.core.annotation.AliasFor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoSpecialCharactersConstraint.class)
public @interface NoSpecialCharacters {

  @AliasFor("specialCharacters")
  String[] value() default {};

  @AliasFor("value")
  String[] specialCharacters() default {};

  String message() default "Value must not contain special characters!";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
