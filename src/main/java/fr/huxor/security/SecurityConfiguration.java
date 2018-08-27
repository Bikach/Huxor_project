package fr.huxor.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/huxor").permitAll()
		.antMatchers("/availableCars").permitAll()
//		.antMatchers("/consulterCompte").hasAnyRole("USER", "ADMIN")
//		.antMatchers("/saveOperation").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
		http.csrf().disable();

	}
	
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {


    }
	








}