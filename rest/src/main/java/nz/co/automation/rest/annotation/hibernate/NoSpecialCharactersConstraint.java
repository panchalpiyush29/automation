package nz.co.automation.rest.annotation.hibernate;

import nz.co.automation.rest.annotation.NoSpecialCharacters;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

import static java.lang.String.format;

public class NoSpecialCharactersConstraint implements ConstraintValidator<NoSpecialCharacters, String> {

  private static final String[] SPECIAL_CHARACTERS = "!@#$%^&*()_+".split("");
  private static String[] specialCharacters;
  private static String specialCharactersPrint;

  @Override
  public void initialize(NoSpecialCharacters noSpecialCharacters) {
    specialCharacters = noSpecialCharacters.value().length == 0 ? SPECIAL_CHARACTERS : noSpecialCharacters.value();
    specialCharactersPrint = StringUtils.join(specialCharacters, ", ");
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    final boolean containsSpecialCharacters = Arrays.stream(specialCharacters).anyMatch(specialCharacter -> value.contains(specialCharacter));
    if (containsSpecialCharacters) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(format("'%s' must not contain any of these special characters '%s'", value, specialCharactersPrint)).addConstraintViolation();
    }
    return !containsSpecialCharacters;
  }
}
