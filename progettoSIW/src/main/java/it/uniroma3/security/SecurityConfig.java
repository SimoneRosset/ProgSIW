package it.uniroma3.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService customUserDetailsService;

		@Override
		protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
		}

		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers ("/assets/css/main.css").permitAll ()
		.antMatchers("/allievoForm", "/attivitaForm","/index", "/iscrizioneForm", "/showAllievo","/showAttivita", "/registrazioneForm").access("hasRole('RESPONSABILE')")
		.antMatchers("/centroDiFormazioneList","/showCentroDiFormazione","/centroDiFormazioneForm","/login").access("hasRole('ADMIN')")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/loginok")
		.failureUrl("/errorlog")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error403")
		.and()
		.logout()
		.deleteCookies("JSESSIONID")
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logoutok")
		.permitAll();
		}
		//argina il problema dell'indirizzamento al login
		@Override
		public void configure(WebSecurity web) throws Exception {
		    web.ignoring().antMatchers("/assets/css/font-awesome.min.css");
		}
}