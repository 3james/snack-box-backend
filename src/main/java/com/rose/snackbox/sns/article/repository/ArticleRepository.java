package com.rose.snackbox.sns.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.snackbox.sns.article.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * article 전체 목록을 생성일자를 기준으로 오름차순으로 정렬하여 조회한다.
     * @return article list
     */
    public List<Article> findAllByOrderByCreatedDateDesc();

}
