package nz.co.automation.rest.annotation.aspectj;

import nz.co.automation.rest.controller.DogRestController;
import nz.co.automation.rest.exception.UnauthorizedAccessException;
import nz.co.automation.rest.service.DogRestService;
import nz.co.automation.rest.service.JwtService;
import nz.co.automation.rest.service.JwtServiceDefaultImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class JwtVerifyAsjectJTest {

  private DogRestController target;
  private DogRestController proxy;
  private DogRestService dogRestService;

  @Before
  public void setUp() throws Exception {
    dogRestService = mock(DogRestService.class);
    target = new DogRestController(dogRestService);
    AspectJProxyFactory factory = new AspectJProxyFactory(target);

    JwtVerifyAsjectJ aspect = new JwtVerifyAsjectJ(mock(HttpServletRequest.class), mock(JwtService.class));
    factory.addAspect(aspect);

    proxy = (DogRestController) factory.getProxy();
  }

  @Test(expected = UnauthorizedAccessException.class)
  public void invalidJwt() throws Exception {

    // when
    proxy.delete(5, "blah");
  }

  @Test
  public void validToken() {
    final JwtService jwtService = new JwtServiceDefaultImpl("quick catch up");
    final int id = 10000000;
    final String authorization = "Bearer " + jwtService.generate("nick");

    // when
    proxy.delete(id, authorization);

    // then
    then(dogRestService).should().deleteDog(id);
  }

}