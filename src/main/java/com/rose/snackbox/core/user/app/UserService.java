package com.rose.snackbox.core.user.app;

import com.rose.snackbox.core.user.entity.User;
import com.rose.snackbox.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	
	public Optional<User> getUser(String email) {
		return userRepository.findById(email);
	}
	
	public List<User> getUserList() {
		return userRepository.findAll();
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public void modifyUser(String email, User user) {
		userRepository.findById(email).ifPresent(_user -> {
			_user.setPassword(user.getPassword());
			_user.setNickname(user.getNickname());
			_user.setSex(user.getSex());
			_user.setAge(user.getAge());
			userRepository.save(_user);
		});
	}
	
	public void removeUser(String email) {
		userRepository.findById(email).ifPresent(_user -> userRepository.deleteById(_user.getEmail()));
	}
	
}
