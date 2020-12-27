package com.rose.snackbox.core.user.repository;

import com.rose.snackbox.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
