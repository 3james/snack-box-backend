package com.rose.snack.sns.article.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rose.snack.sns.article.entity.ArticleEntity;
import com.rose.snack.sns.article.app.ArticleService;

@RestController
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;	
	
	@RequestMapping(value="/api/articles", method=RequestMethod.GET)
	public ResponseEntity<?> getArticleList() {
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Get Article List Started !!");
    	}
		
    	List<ArticleEntity> articleList = articleService.getArticleList();
		for (ArticleEntity entity: articleList) {
			if (logger.isDebugEnabled()) {
				logger.debug(entity.getArticleId().toString());
				logger.debug(entity.getTitle());
				logger.debug(entity.getArticle());
			}
		}
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Get Article List Ended !!");
    	}		
    	
		return new ResponseEntity<List<ArticleEntity>>(articleList, HttpStatus.OK); 
	}	
	
	@RequestMapping(value="/api/article", method=RequestMethod.POST)
	public ArticleEntity createArticle(
			@RequestParam("title") String title,
			@RequestParam("article") String article	) {
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Create Article Started !!");
    	}		
		
		ArticleEntity articleEntity = new ArticleEntity();
		articleEntity.setTitle(title);
		articleEntity.setArticle(article);	
		ArticleEntity returnArticleEntity = articleService.createArticle(articleEntity);
		
    	if (logger.isDebugEnabled()) {
    		logger.debug("Create Article Ended !!");
    	}			
		
		return returnArticleEntity;
	}
	
}
