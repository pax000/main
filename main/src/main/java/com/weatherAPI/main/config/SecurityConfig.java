package com.weatherAPI.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
    private H2ConsoleProperties h2Console;
	
	@Override
    protected void configure(HttpSecurity httpSec) throws Exception {
		
		 String path = this.h2Console.getPath();
         String antPattern = (path.endsWith("/") ? path + "**" : path + "/**");
         
         httpSec
        .authorizeRequests()
        .anyRequest()
        .permitAll()
        .and()
        .httpBasic()
        .and()
        .csrf()
        .ignoringAntMatchers(antPattern);
    }
}
