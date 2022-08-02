package com.zemoso.washmetrics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

@Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.cors().configurationSource(request -> {
      var cors = new CorsConfiguration();
      cors.setAllowedOrigins(List.of("http://localhost:8062/api/locations"));
      cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
      cors.setAllowedHeaders(List.of("*"));
      return cors;
    });
  }
}