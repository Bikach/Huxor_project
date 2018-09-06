package fr.huxor.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
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
			.authoritiesByUsernameQuery("select username , role  from user_role  natural join role r  where username=?")
			.rolePrefix("ROLE_")
			.passwordEncoder(new BCryptPasswordEncoder());
    	
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.formLogin().loginPage("/login");
    	http.authorizeRequests()
    		.antMatchers("/", "/availableCars","/contactForm", "/services").permitAll()
    		.antMatchers("/confirmBooking", "/userAccount", "/myReservations").hasAnyRole("USER")
    		.antMatchers("/manager/**").hasRole("MANAGER")
    		.antMatchers("/admin/**").hasRole("ADMIN")
    		.and()
    		.sessionManagement().maximumSessions(1)
    		.sessionRegistry(sessionRegistry());
        http.csrf().disable();
    	
    }

    
    /**
     * Is closed, we need to have this custom sessionRegistry
     */
    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
	








}