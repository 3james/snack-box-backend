package com.rose.snackbox.sns.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.snackbox.sns.article.entity.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

}
