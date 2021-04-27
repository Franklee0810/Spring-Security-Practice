package com.cos.security.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.security.model.User;

 
public class PrincipalDetails implements UserDetails, OAuth2User{
	
	private Map<String, Object> attributes; 
	
	public User user;
	
	//일반 로그인 
	public PrincipalDetails(User user) {
		this.user = user;
	}
 
	//OAuth 로그인
	public PrincipalDetails(Map<String, Object> attributes, User user) {
	 
		this.attributes = attributes;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	//해당 User의 권한을 리턴하는 곳 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				 
				return user.getRole();
			}
		});
		return collect;
	}

	//패스워드 리턴하는 메소드 
	@Override
	public String getPassword() { 
		return user.getPassword();
	}
	
	//username 리턴하는 메소드 
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정 만료안되었는지? 
	@Override
	public boolean isAccountNonExpired() { 
		return true;
	}

	//계정 잠겨있지 않았는지? 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호 기간이 만료되지 않았는지?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정 활성화 되었는지?
	@Override
	public boolean isEnabled() { 
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() { 
		return null;
	}
	
}
