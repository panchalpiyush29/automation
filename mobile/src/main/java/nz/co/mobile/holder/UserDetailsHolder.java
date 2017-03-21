package nz.co.mobile.holder;

import nz.co.mobile.domain.UserDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Component
@Scope(scopeName = "cucumber-glue", proxyMode = TARGET_CLASS)
public class UserDetailsHolder extends GenericHolder <UserDetails>{
}
