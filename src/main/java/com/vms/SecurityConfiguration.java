/*
 * package com.vms;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfiguration extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired UserDetailsService userDetailsService;
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.userDetailsService(userDetailsService); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .requiresChannel().anyRequest().requiresSecure() .and() .formLogin()
 * .loginPage("/index.html"); }
 * 
 * @Bean public PasswordEncoder getpasswordencoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * }
 */