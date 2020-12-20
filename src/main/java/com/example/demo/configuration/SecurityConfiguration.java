package com.example.demo.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.httpBasic();

    http
      .authorizeRequests().antMatchers("/secured").authenticated()
      .and()
      .authorizeRequests().anyRequest().permitAll();
  }
  
}
