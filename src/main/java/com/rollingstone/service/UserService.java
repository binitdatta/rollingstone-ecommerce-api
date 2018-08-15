package com.rollingstone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.UserRepository;
import com.rollingstone.domain.User;

@Service
public class UserService {

	Logger logger  = LoggerFactory.getLogger("UserService");
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	/*public UserService() {
		super();
		
	}*/
	
	public User save(User user) {
		User userSaved = userRepository.save(user);
		
		return userSaved;
	}
	
	public Page<User> getUserByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("firstName").descending());
		
		
		return userRepository.findAll(pageable);		
		
	}
	
	public Optional<User> getUser(Long userId) {
		logger.info(" Inside service received id is :"+userId);
		
		if (userRepository == null) {
			logger.info(" userRepository null :");
		}
		
		return userRepository.findById(userId);
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
}
