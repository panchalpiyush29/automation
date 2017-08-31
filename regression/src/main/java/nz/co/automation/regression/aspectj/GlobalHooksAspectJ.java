package nz.co.automation.regression.aspectj;

import nz.co.automation.regression.annotations.AfterAll;
import nz.co.automation.regression.annotations.BeforeAll;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.String.format;

@Component
@Aspect
public class GlobalHooksAspectJ {

  private boolean globalHooksSet = false;

  @Before("@annotation(cucumber.api.java.Before)")
  public void before(JoinPoint joinPoint) throws Throwable {
    if (!globalHooksSet) {
      final Method afterAllMethod = getMethodWithAnnotation(joinPoint, AfterAll.class);
      final Method beforeAllMethod = getMethodWithAnnotation(joinPoint, BeforeAll.class);

      // execute beforeAll once
      final Object target = joinPoint.getTarget();
      beforeAllMethod.invoke(target);

      // register afterAll to run at the end
      Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
          try {
            afterAllMethod.invoke(target);
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
        }
      });

      // mark globalHooks set
      globalHooksSet = true;
    }
  }

  private Method getMethodWithAnnotation(JoinPoint joinPoint, Class<? extends Annotation> annotationClass) throws IllegalAccessException, InvocationTargetException {
    final Object target = joinPoint.getTarget();
    final Class<?> targetClass = target.getClass();
    final Method[] methods = targetClass.getMethods();
    for (Method method : methods) {
      if (method.isAnnotationPresent(annotationClass)) {
        return method;
      }
    }
    throw new IllegalStateException(format("Annotation class %s does not exist in %s!", annotationClass.getName(), targetClass.getName()));
  }

}
