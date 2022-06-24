package com.doranco.security.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}1234 ").roles("USER");
		*/
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal ,password, active as credentials from app_user where username=?")
		.authoritiesByUsernameQuery("select app_user_username as principal , roles_role_name as role from app_user_roles "+ "where app_user_username=?")
		.passwordEncoder(bCryptPasswordEncoder)
		.rolePrefix("ROLE_");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		//afficher un formulaire de login
		http.csrf().disable();
		// ne pas autorisé les testes (yarc postman)
		http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll(); // pages autorisé mm si vous n'êtes pas connecté
		// login et register sont autorisé pour tout le monde
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/produit/**").hasRole("ADMIN"); // antMatcher=> url et
																							// methode =?
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/produit").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		// anyRequest=> n'importe quelle user peut accéder .authentificated (il doit se
		// connecter avant tout)

	}
}
