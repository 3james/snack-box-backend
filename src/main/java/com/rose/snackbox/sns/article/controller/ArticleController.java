package com.rose.snackbox.sns.article.controller;

import com.rose.snackbox.sns.article.app.ArticleService;
import com.rose.snackbox.sns.article.entity.ArticleEntity;
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
		
    	List<ArticleEntity> articleList = articleService.getArticleList();
		for (ArticleEntity entity : articleList) {
			log.debug(entity.getArticleId().toString());
			log.debug(entity.getTitle());
			log.debug(entity.getArticle());
		}

		log.debug("Get Article List Ended !!");
    	
		return new ResponseEntity<List<ArticleEntity>>(articleList, HttpStatus.OK); 
	}	
	
	@PostMapping(value="/api/article")
	public ArticleEntity createArticle(
			@RequestParam("title") String title,
			@RequestParam("article") String article	) {

		log.debug("Create Article Started !!");
		
		ArticleEntity articleEntity = new ArticleEntity();
		articleEntity.setTitle(title);
		articleEntity.setArticle(article);	
		ArticleEntity returnArticleEntity = articleService.createArticle(articleEntity);

		log.debug("Create Article Ended !!");
		
		return returnArticleEntity;
	}
	
}
