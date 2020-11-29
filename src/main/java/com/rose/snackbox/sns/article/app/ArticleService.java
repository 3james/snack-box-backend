package com.rose.snackbox.sns.article.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rose.snackbox.sns.article.entity.ArticleEntity;
import com.rose.snackbox.sns.article.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	public Optional<ArticleEntity> getArticle(Long articleId) {
		return articleRepository.findById(articleId);
	}
	
	public List<ArticleEntity> getArticleList() {
		return articleRepository.findAll();
	}
	
	public ArticleEntity createArticle(ArticleEntity articleEntity) {
		return articleRepository.save(articleEntity);
	}
	
	public ArticleEntity modifyArticle(ArticleEntity articleEntity) {
		if (articleRepository.existsById(articleEntity.getArticleId())) {
			return articleRepository.save(articleEntity);
		} else {
			throw new RuntimeException("Fail : There is no data !!");
		}
	}
	
	public void removeArticle(Long articleId) {
		if (articleRepository.existsById(articleId)) {
			articleRepository.deleteById(articleId);
		} else {
			throw new RuntimeException("Fail : There is no data !!");
		}
	}
	
}
