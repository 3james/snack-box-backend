package com.rose.snackbox.core.user.entity;

import com.rose.snackbox.common.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends AbstractEntity {

	private String email;
	private String password;
	private String nickname;
	private String sex;
	private String age;
	
}
