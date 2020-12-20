package com.rose.snackbox.sns.article.app;

import com.rose.snackbox.sns.article.entity.Article;
import com.rose.snackbox.sns.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

	private final ArticleRepository articleRepository;

	
	public Optional<Article> getArticle(Long articleId) {
		return articleRepository.findById(articleId);
	}
	
	public List<Article> getArticleList() {
		return articleRepository.findAll();
	}

	public List<Article> getArticleListByOrderByCreatedDateDesc() {
		return articleRepository.findAllByOrderByCreatedDateDesc();
	}
	
	public void createArticle(Article article) {
		articleRepository.save(article);
	}
	
	public void modifyArticle(Long articleId, Article article) {
		articleRepository.findById(articleId).ifPresent(_article -> {
			_article.setTitle(article.getTitle());
			_article.setContent(article.getContent());
			articleRepository.save(_article);
		});
	}
	
	public void removeArticle(Long articleId) {
		articleRepository.findById(articleId).ifPresent(_article -> {
			articleRepository.deleteById(_article.getArticleId());
		});
	}
	
}
