package com.springmvc.secapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {

    @Autowired
    HttpSecurity httpSecurity;


    @Bean
            public InMemoryUserDetailsManager setUpUsers() {
        UserDetails firsrUser = User
                .withUsername("root")
                .password("root")
                .roles("admin", "guest")
                .build();

        UserDetails secondUser = User
                .withUsername("root2")
                .password("root2")
                .roles("admin", "guest")
                .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(firsrUser);
        inMemoryUserDetailsManager.createUser(secondUser);
   //     return new InMemoryUserDetailsManager(firsrUser);
        return  inMemoryUserDetailsManager;
    }

        @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
SecurityFilterChain setUpSpringSecurity() throws Exception {
httpSecurity.authorizeHttpRequests().requestMatchers("/hi").authenticated();
httpSecurity.authorizeHttpRequests().requestMatchers("/bye").permitAll();

       // httpSecurity.authorizeHttpRequests().requestMatchers("/hello").denyAll();
httpSecurity.formLogin();
httpSecurity.httpBasic();
return  httpSecurity.build();
}


@Bean(name="mvcHandlerMappingIntrospector")
HandlerMappingIntrospector handlerMappingIntrospector () {
        return new HandlerMappingIntrospector();
}
}
