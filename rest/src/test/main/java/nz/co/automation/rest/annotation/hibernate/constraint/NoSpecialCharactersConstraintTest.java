package nz.co.automation.rest.annotation.hibernate.constraint;

import com.google.common.collect.Lists;
import nz.co.automation.rest.domain.CreateDogRequest;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NoSpecialCharactersConstraintTest {

  private Validator validator;

  @Before
  public void setUp() throws Exception {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  @Test
  public void isValid() throws Exception {
    // given
    CreateDogRequest createDogRequest = new CreateDogRequest("! dog", 2);

    // when
    final Set<ConstraintViolation<CreateDogRequest>> constraintViolations = validator.validate(createDogRequest);

    // then
    final ArrayList<ConstraintViolation<CreateDogRequest>> constraintViolationList = Lists.newArrayList(constraintViolations);
    assertThat(constraintViolationList.get(0).getMessage()).isNotBlank();
  }

}