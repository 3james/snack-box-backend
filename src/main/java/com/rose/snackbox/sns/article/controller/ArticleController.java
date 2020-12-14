package com.rose.snackbox.sns.article.controller;

import com.rose.snackbox.sns.article.app.ArticleService;
import com.rose.snackbox.sns.article.entity.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArticleController {

	private final ArticleService articleService;
	
	@GetMapping(value="/api/articles")
	public ResponseEntity<?> getArticleList() {

    	log.debug("Get Article List Started !!");
		
    	List<Article> articleList = articleService.getArticleList();
		for (Article entity : articleList) {
			log.debug(entity.getArticleId().toString());
			log.debug(entity.getTitle());
			log.debug(entity.getContent());
		}

		log.debug("Get Article List Ended !!");
    	
		return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
	}	
	
	@PostMapping(value="/api/article")
	public Article createArticle(
			@RequestParam("title") String title,
			@RequestParam("content") String content	) {

		log.debug("Create Article Started !!");
		
		Article articleEntity = new Article();
		articleEntity.setTitle(title);
		articleEntity.setContent(content);
		Article returnArticleEntity = articleService.createArticle(articleEntity);

		log.debug("Create Article Ended !!");
		
		return returnArticleEntity;
	}
	
}
