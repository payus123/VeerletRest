package veerlethome.VeerletRest.Secuirity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import veerlethome.VeerletRest.CustomUserDetailsService;

public class SecuirityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
   private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(customUserDetailsService);
    }
}
