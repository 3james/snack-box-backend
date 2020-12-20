package com.rose.snackbox.sns.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.snackbox.sns.article.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findAllByOrderByCreatedDateDesc();

}
