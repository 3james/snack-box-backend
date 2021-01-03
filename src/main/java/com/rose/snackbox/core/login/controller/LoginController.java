package com.rose.snackbox.core.login.controller;

import com.rose.snackbox.core.login.app.LoginService;
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
public class LoginController {

	private final LoginService loginService;

	@PostMapping(value="/api/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		log.debug("Post /api/login - user : {}", user);
		loginService.login(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
