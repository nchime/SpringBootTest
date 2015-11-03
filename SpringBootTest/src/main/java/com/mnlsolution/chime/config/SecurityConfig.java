package com.mnlsolution.chime.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String REMEMBER_ME_KEY = "chimeKey";

	@Autowired 
	DataSource dataSource; 
	
/*	@Autowired
	UserDetailsService userDetailsService;
*/	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

/*		auth.inMemoryAuthentication()
			.withUser("user").password("1234").roles("USER").and()
			.withUser("admin").password("1234").roles("USER", "ADMIN");
*/
		auth.jdbcAuthentication().dataSource(dataSource); 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/**").permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
                .defaultSuccessUrl("/admin")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")  				
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true);    
		
		// 403 페이지 핸들링
		http
			.exceptionHandling()
			.accessDeniedPage("/403");
		
		
/*		http
			.rememberMe()
				.key(REMEMBER_ME_KEY); 
*///				.key(REMEMBER_ME_KEY).rememberMeServices(persistentTokenBasedRememberMeServices());		
	}
	
	
/*	@Bean
	public TokenBasedRememberMeServices tokenBasedRememberMeServices(){
		TokenBasedRememberMeServices tokenBasedRememberMeServices =
				new TokenBasedRememberMeServices(REMEMBER_ME_KEY, userDetailsService);
		tokenBasedRememberMeServices.setCookieName("chimeCookie");
		return tokenBasedRememberMeServices;
	}
*/	
	

}
