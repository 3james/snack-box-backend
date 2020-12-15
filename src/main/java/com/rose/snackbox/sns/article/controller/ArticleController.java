package com.rose.snackbox.sns.article.controller;

import com.rose.snackbox.sns.article.app.ArticleService;
import com.rose.snackbox.sns.article.entity.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		for (Article article : articleList) {
			log.debug(article.getArticleId().toString());
			log.debug(article.getTitle());
			log.debug(article.getContent());
		}

		log.debug("Get Article List Ended !!");
    	
		return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
	}	
	
	@PostMapping(value="/api/article")
	public ResponseEntity<?> createArticle(
			@RequestParam("title") String title,
			@RequestParam("content") String content) {

		log.debug("Create Article Started !!");
		
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		Article returnArticleEntity = articleService.createArticle(article);

		log.debug("Create Article Ended !!");
		
		return new ResponseEntity<Article>(returnArticleEntity, HttpStatus.OK);
	}

	@DeleteMapping(value="/api/article/{articleId}")
	public ResponseEntity<?> removeArticle(
			@PathVariable("articleId") String articleId) {

		log.debug("Remove Article Started !!");

		articleService.removeArticle(Long.parseLong(articleId));

		log.debug("Remove Article Ended !!");

		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
