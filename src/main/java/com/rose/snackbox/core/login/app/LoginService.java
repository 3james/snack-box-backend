package com.rose.snackbox.core.login.app;

import com.rose.snackbox.core.user.entity.User;
import com.rose.snackbox.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {

	private final UserRepository userRepository;
	
	public void login(User user) {
		Optional<User> returnedUser = userRepository.findById(user.getEmail());
		if (user.getPassword().equals(returnedUser.get().getPassword())) {
			log.info("Login Success !!!");
		} else {
			throw new RuntimeException("Login Failed !!!");
		}
	}
	

	
}
