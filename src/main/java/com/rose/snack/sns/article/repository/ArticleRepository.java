package com.rose.snack.sns.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.snack.sns.article.entity.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

}
