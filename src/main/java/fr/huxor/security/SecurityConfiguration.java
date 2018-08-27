package fr.huxor.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

    
	 
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication()
    		.dataSource(dataSource)
    		.usersByUsernameQuery("select username as principale, password as credentials, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username as principale, role_id as role from user_role where username=?")
			.rolePrefix("ROLE_")
			.passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.formLogin().loginPage("/login");
    	http.authorizeRequests().antMatchers("/reserver").hasAnyRole("USER", "MANAGER")
    	.antMatchers("/backOffice").hasRole("ADMIN");
    	http.exceptionHandling().accessDeniedPage("/403");
    	http.csrf().disable();
    	
    }
	








}