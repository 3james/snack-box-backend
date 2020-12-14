package com.rose.snackbox.sns.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article extends BaseTimeEntity {

	@Id
	@GeneratedValue
	private Long articleId;
	
	private String title;

	@Column(length = Integer.MAX_VALUE)
	private String content;
	
}
