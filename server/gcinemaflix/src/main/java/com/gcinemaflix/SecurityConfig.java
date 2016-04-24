package com.gcinemaflix;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gcinemaflix.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserService userService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    		
    		//auth.authenticationProvider(authenticationProvider());
    		auth.userDetailsService(userService);
    		//      auth.jdbcAuthentication().dataSource(dataSource)
//        .usersByUsernameQuery(
//            "select username,password from user where username=?")
//        .authoritiesByUsernameQuery(
//            "select username, role from role where username=?");
    }   

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    			http
    				.authorizeRequests()
    				.anyRequest().authenticated()
    				.and()
    				.formLogin()
    				.and()
    				.httpBasic()
    				;
    	}
    
    

 }