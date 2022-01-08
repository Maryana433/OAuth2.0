package org.maryana.springbootopenid;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/oauth").authenticated()
                .antMatchers("/login").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }

}

/*

https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?
client_id=84889951475-0afqp1cq35r7l3v8rocdba08mmellbvm.apps.googleusercontent.com
&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Flogin
&response_type=code
&scope=email%20profile&state=K8utM8
&flowName=GeneralOAuthFlow

 */
