package nz.co.automation.regression.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "cucumber-glue")
public class DogDetailsHolder extends GenericHolder<DogDetails> {
}
