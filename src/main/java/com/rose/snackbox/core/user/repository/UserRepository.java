package com.rose.snackbox.core.user.repository;

import com.rose.snackbox.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByNickname(String nickname);

}
