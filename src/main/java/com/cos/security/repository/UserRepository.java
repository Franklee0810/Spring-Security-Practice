package com.cos.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.security.model.User;


//JpaRepository 는 CRUD를 가지고 있음 
//이제 UserRepository autowired해서 다른 곳에서 자유롭게 쓸 수가 있음 Ioc컨테이너에 di 했기 때문. 
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//Select * from user where username = 1? 
	public User findByUsername(String username);
	
}
