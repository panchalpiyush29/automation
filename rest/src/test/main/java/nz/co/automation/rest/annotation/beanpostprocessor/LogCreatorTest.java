package nz.co.automation.rest.annotation.beanpostprocessor;

import nz.co.automation.rest.controller.DogRestController;
import nz.co.automation.rest.service.DogRestService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class LogCreatorTest {

  private LogCreator logCreator;
  private DogRestService dogRestService;

  @Before
  public void setUp() throws Exception {
    logCreator = new LogCreator();
  }

  @Test
  public void postProcessBeforeInitialization() throws Exception {
    // given
    dogRestService = mock(DogRestService.class);
    final DogRestController dogRestController = new DogRestController(dogRestService);

    // when
    logCreator.postProcessBeforeInitialization(dogRestController, "dogRestController");

    // then
    dogRestController.printHelloWorld();
  }

}