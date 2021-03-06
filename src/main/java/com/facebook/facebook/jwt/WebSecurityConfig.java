package com.facebook.facebook.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()

        .antMatchers(HttpMethod.POST, "/users/generate/jwt","/users/check/register","/users/check/login",
                "/","/users","/send/code/email","/send/code/phone","/users/generate/login/id/jwt","/users/check/login").permitAll()

        .antMatchers(HttpMethod.DELETE,"/").permitAll()


        .antMatchers(HttpMethod.PUT,"/users").permitAll()


        .antMatchers(HttpMethod.GET, "/users/token","/users/id","/users/search").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
        // disable page caching
        .headers().cacheControl();
  }
}