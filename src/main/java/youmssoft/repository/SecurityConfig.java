package youmssoft.repository;


import javax.security.auth.login.FailedLoginException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true) //Pour sécuriser les méthodes de votre application
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//Voila les utilisateurs qui ont le droit
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource)  throws Exception{
		/*
		auth.inMemoryAuthentication().withUser("Blaise").password("{noop}123").roles("ADMIN","SECRETAIRE","CAISSIER(E)","MAGAZINIER(E)_EMB","MAGAZINIER(E)_PROD");
		auth.inMemoryAuthentication().withUser("Megane").password("{noop}123").roles("SECRETAIRE");
		auth.inMemoryAuthentication().withUser("Browndon").password("{noop}123").roles("MAGAZINIER(E)_EMB","MAGAZINIER(E)_PROD");
		auth.inMemoryAuthentication().withUser("Micheline").password("{noop}123").roles("CAISSIER(E)");
		*/
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, CONCAT('{noop}',password) as credentials, true from users where username = ?")
			.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from users_roles where user_username = ?")
			.rolePrefix("ROLE_");
		
	}
	
	//Quelles sont les ressources qui seront mis à diposition des utlisateurs.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		//regles de securité
		http
		.csrf().disable()//on comprendra pourquoi plus tard.
		.authorizeRequests().antMatchers("/login/**").permitAll()
			.anyRequest() // Toutes les requêtes...
				.authenticated()// ...doivent être sécurisées.
					.and()// Et...
		.formLogin()//...redirigées vers la page login.
			.loginPage("/login")
				.permitAll()//on lui donne l'accès à toutes les ressources
					.defaultSuccessUrl("/index.html");//page qui s'affiche par defaut
						
				
				
	}
}
