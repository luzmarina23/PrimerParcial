package com.apiufpso.tienda.repository;

import com.apiufpso.tienda.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
