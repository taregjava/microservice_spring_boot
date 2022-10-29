package com.halfacode.loginservice.config;

import com.halfacode.loginservice.service.LoginUserDetailsService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Data
@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final LoginUserDetailsService loginUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(loginUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin();
    }


    /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(http);
        auth.inMemoryAuthentication()
                .withUser("tareg")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
                .roles("USER")
                .and()
                .withUser("john")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
                .roles("ADMIN");
    }*/

  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN");
              //  .antMatchers("/**").permitAll();
    }*/

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
