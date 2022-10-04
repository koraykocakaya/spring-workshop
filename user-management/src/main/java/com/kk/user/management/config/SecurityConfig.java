package com.kk.user.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kk.user.management.security.CustomPasswordEncoderFactories;
import com.kk.user.management.security.RestHeaderAuthFilter;
import com.kk.user.management.security.RestParamAuthFilter;

/**
 * 
 * @author korayk
 *
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}
	
	
	public RestHeaderAuthFilter restHeaderAuthFilter(AuthenticationManager manager) throws Exception {
		RestHeaderAuthFilter filter = new RestHeaderAuthFilter(new AntPathRequestMatcher("/loginCustomAuth/**"));
		filter.setAuthenticationManager(manager);
		return filter;
	}
	
	public RestParamAuthFilter restParamAuthFilter(AuthenticationManager manager) throws Exception {
		RestParamAuthFilter filter = new RestParamAuthFilter(new AntPathRequestMatcher("/loginCustomAuth/**"));
		filter.setAuthenticationManager(manager);
		return filter;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return CustomPasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(restHeaderAuthFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(restParamAuthFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		System.out.println("Filter Chain ");
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
		http.authorizeRequests(authorize -> {
			authorize.antMatchers("/hello").permitAll()
					 .antMatchers("/h2-console/**").permitAll()
					 .mvcMatchers(HttpMethod.GET, "/hello-auth").permitAll()
//					 .mvcMatchers(HttpMethod.GET, "/hello-login-admin").hasRole("ADMIN")
//					 .mvcMatchers(HttpMethod.GET, "/hello-login-admin-customer").hasAnyRole("ADMIN", "CUSTOMER")
					 .mvcMatchers(HttpMethod.GET, "/loginCustomAuth/**").permitAll();
			
		}).authorizeRequests().anyRequest().authenticated().and().formLogin()
		.and().httpBasic()
		.and().csrf().ignoringAntMatchers("/h2-console/**", "/multiExampleUser");
		
		// persistent
//		.and().rememberMe()
//        .tokenRepository(persistentTokenRepository)
//        .userDetailsService(userDetailsService);

		// hash based
        //.rememberMe()
        //.key("sfg-key")
        //.userDetailsService(userDetailsService);
		
		 http.headers().frameOptions().sameOrigin();
	}
	
	
	
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//		http.addFilterBefore(restHeaderAuthFilter(), UsernamePasswordAuthenticationFilter.class);
//		System.out.println("Filter Chain ");
////		http.authorizeRequests()
////			.anyRequest().authenticated()
////			.and()
////			.formLogin()
////			.and()
////			.httpBasic();
//		http.authorizeRequests(authorize -> {
//			authorize.antMatchers("/hello").permitAll()
//					 .mvcMatchers(HttpMethod.GET, "/hello-auth").permitAll();
//		}).authorizeRequests()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.and()
//		.httpBasic();
//
//	    return http.build();
//	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		System.out.println("User details called");
//		UserDetails user1 = User.withUsername("Koray").password("{ldap}{SSHA}PXU6F6h+35H4Pw7V+v3cjGtVZvKo9G8WPsFMLQ==") // LDAP
//																														// 12
//				.roles("ADMIN").build();
//
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("1234").roles("ADMIN").build();
//
//		UserDetails user3 = User.withUsername("KorayB")
//				.password("{hard-bcrypt}$2a$10$NPNBDd8gqOsVCx4KvXbKzu8lP9RSF1GpVKu.ZQlaxVgKb0m/QfyOm") // bcrypt 12,
//																										// koray custom
//																										// tanmilandi
//				.roles("ADMIN").build();
//		// $2a$15$gY1aOGRstnC.BKt2ew6O7uxvhT8oWaDUXe6Dj3wFc80bVDpDjbFGK
//		return new InMemoryUserDetailsManager(user1, user2, user3);
//	}
	
	
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("spring")
//                .password("{bcrypt}$2a$10$7tYAvVL2/KwcQTcQywHIleKueg4ZK7y7d44hKyngjTwHCDlesxdla")
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password("{sha256}1296cefceb47413d3fb91ac7586a4625c33937b4d3109f5a4dd96c79c46193a029db713b96006ded")
//                .roles("USER");
//
//        auth.inMemoryAuthentication().withUser("scott").password("{bcrypt15}$2a$15$baOmQtw8UqWZRDQhMFPFj.xhkkWveCTQHe4OBdr8yw8QshejiSbI6").roles("CUSTOMER");
//    }

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		System.out.println("Filter Chain 2");
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
//		
//	    return http.build();
//	}

}
