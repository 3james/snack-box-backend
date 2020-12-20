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
		log.debug("Get /api/articles");
    	List<Article> articleList = articleService.getArticleListByOrderByCreatedDateDesc();
		articleList.forEach(article -> {
			log.debug(article.getArticleId().toString());
			log.debug(article.getTitle());
			log.debug(article.getContent());
		});
		return ResponseEntity.ok(articleList);
	}	
	
	@PostMapping(value="/api/article")
	public ResponseEntity<?> createArticle(@RequestBody Article article) {
		log.debug("Post /api/article - article : {}", article);
		articleService.createArticle(article);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PutMapping(value="/api/article/{articleId}")
	public ResponseEntity<?> modifyArticle(@PathVariable("articleId") Long articleId,
										   @RequestBody Article article) {
		log.debug("Put /api/article/{} - article : {}", articleId, article);
		articleService.modifyArticle(articleId, article);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@DeleteMapping(value="/api/article/{articleId}")
	public ResponseEntity<?> removeArticle(@PathVariable("articleId") String articleId) {
		log.debug("Delete /api/article/{}", articleId);
		articleService.removeArticle(Long.parseLong(articleId));
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
