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
    CreateDogRequest createDogRequest = new CreateDogRequest("a dog", 2);

    // when
    final Set<ConstraintViolation<CreateDogRequest>> constraintViolations = validator.validate(createDogRequest);

    // then
    assertThat(constraintViolations).isEmpty();
  }

  @Test
  public void isNotValid() throws Exception {
    // given
    CreateDogRequest createDogRequest = new CreateDogRequest("! dog", 2);

    // when
    final Set<ConstraintViolation<CreateDogRequest>> constraintViolations = validator.validate(createDogRequest);

    // then
    final ArrayList<ConstraintViolation<CreateDogRequest>> constraintViolationList = Lists.newArrayList(constraintViolations);
    assertThat(constraintViolationList.get(0).getMessage()).isNotBlank();
  }

  @Test
  public void isValidWithSpecifiedValue() {
    // given
    final DummyModel dummyModel = new DummyModel("c dog");

    // when
    final Set<ConstraintViolation<DummyModel>> constraintViolations = validator.validate(dummyModel);

    // then
    assertThat(constraintViolations).isEmpty();
  }

  @Test
  public void isNotValidWithSpecifiedValue() {
    // given
    final DummyModel dummyModel = new DummyModel("a dog");

    // when
    final Set<ConstraintViolation<DummyModel>> constraintViolations = validator.validate(dummyModel);

    // then
    final ArrayList<ConstraintViolation<DummyModel>> constraintViolationList = Lists.newArrayList(constraintViolations);
    assertThat(constraintViolationList.get(0).getMessage()).isNotBlank();
  }
}