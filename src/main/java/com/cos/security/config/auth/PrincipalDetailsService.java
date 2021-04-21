package com.cos.security.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.security.model.User;
import com.cos.security.repository.UserRepository;

//시큐리티 설정에서 loginProcessingUrl("/login")으로 했기때문에, 
// "/login" 요청이 들어오면, 자동으로 UserDetailsService타입으로 IOC 되어있는 loadUserByUsername 함수가 실행됨. 

@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User userEntity = userRepository.findByUsername(username);
		
		if(userEntity != null) {
			return new PrincipalDetails(userEntity);
		}
		
		return null;
	}
	
}
