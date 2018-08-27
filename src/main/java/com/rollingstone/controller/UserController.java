package com.rollingstone.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.User;
import com.rollingstone.service.UserService;

@RestController
public class UserController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("UserController");
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("solcommerce/pdp-service/account/user/")
	@ResponseBody
	public User createUser(@RequestBody User user) {
		User userSaved  = userService.save(user);
		
		logger.info("User Saved :"+ userSaved.getUserName());
		return user;
	}
	
	@GetMapping("solcommerce/pdp-service/account/user/{id}")
	public User get(@PathVariable("id") Long id) {
		logger.info("Received ID is :"+id);
		
		if (userService == null) {
			logger.info("userService null");
		}
		Optional<User> userRetrieved  = userService.getUser(id);
		
		
		User user = userRetrieved.get();
		
		if (user == null) {
			logger.info("Received null");
		}
		return user;
	}
	
	@GetMapping("solcommerce/pdp-service/account/user/bypage")
	Page<User> getUsersByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return userService.getUserByPage(pageNumber, pageSize);
	}
	
	@PutMapping("solcommerce/pdp-service/account/user/{id}")
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		User userSaved  = userService.save(user);
		
		logger.info("User Updated :"+ userSaved.getUserName());
		return user;
	}
	
	 /*---Delete a User by id---*/
	   @DeleteMapping("solcommerce/pdp-service/account/user/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   userService.deleteUser(id);
	      return ResponseEntity.ok().body("User has been deleted successfully.");
	   }
}
