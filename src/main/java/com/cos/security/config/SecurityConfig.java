package com.cos.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.security.config.oauth.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨. 
@EnableGlobalMethodSecurity(securedEnabled = true) //secured 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PrincipalOauth2UserService principalOauth2UserService;
	
	
	@Bean //해당 메소드의 리턴되는 오브젝트를 Ioc에 등록해줌 
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();  //csrf 비활성화 
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated()
			.antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
			.antMatchers("/admin/**").access("hasRole('Role_ADMIN')")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/loginForm")
			.loginProcessingUrl("/login") // login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인 진행 해 줌.
			.defaultSuccessUrl("/")
			.and()
			.oauth2Login()
			.loginPage("/loginForm")
			.userInfoEndpoint()
			.userService(principalOauth2UserService);
			
	}
}
