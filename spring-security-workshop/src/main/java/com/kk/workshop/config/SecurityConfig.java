package com.kk.workshop.config;

import com.kk.workshop.config.enums.UserPermission;
import com.kk.workshop.config.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/")
                        .permitAll()
                    .antMatchers("/api/v1/students/**")
                        .hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/api/v1/person")
                        //.hasRole("ADMIN")
                        .hasAuthority(UserPermission.PERSON_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin(); // basic auth icin popup yerine login ekranina yonlendirir

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userAdmin = User.builder()
                .username("Koray")
                .password(passwordEncoder.encode("12"))
                .roles("ADMIN")
                .build();

        UserDetails userPerson = User.builder()
                .username("Person")
                .password(passwordEncoder.encode("12"))
                //.roles("PERSON")
                .authorities(UserRole.PERSON_ADMIN.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(userAdmin, userPerson);
    }


}
