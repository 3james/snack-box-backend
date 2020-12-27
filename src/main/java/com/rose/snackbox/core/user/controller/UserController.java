package com.rose.snackbox.core.user.controller;

import com.rose.snackbox.core.user.app.UserService;
import com.rose.snackbox.core.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;
	
	@GetMapping(value="/api/users")
	public ResponseEntity<?> getUserList() {
		log.debug("Get /api/users");
    	List<User> userList = userService.getUserList();
		userList.forEach(user -> {
			log.debug(user.getEmail());
			log.debug(user.getNickname());
			log.debug(user.getSex());
			log.debug(user.getAge());
		});
		return ResponseEntity.ok(userList);
	}	
	
	@PostMapping(value="/api/user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		log.debug("Post /api/user - user : {}", user);
		userService.createUser(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PutMapping(value="/api/user/{email}")
	public ResponseEntity<?> modifyUser(@PathVariable("email") String email,
										@RequestBody User user) {
		log.debug("Put /api/user/{} - user : {}", email, user);
		userService.modifyUser(email, user);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@DeleteMapping(value="/api/user/{email}")
	public ResponseEntity<?> removeUser(@PathVariable("email") String email) {
		log.debug("Delete /api/user/{}", email);
		userService.removeUser(email);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
