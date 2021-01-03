package com.rose.snackbox.core.user.entity;

import com.rose.snackbox.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(indexes = @Index(columnList = "nickname"))
public class User extends BaseTimeEntity {

	@Id
	private String email;

	private String password;

	private String nickname;

	private String sex;

	private String age;
	
}
