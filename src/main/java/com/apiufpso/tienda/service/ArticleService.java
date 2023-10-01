package com.apiufpso.tienda.service;


import com.apiufpso.tienda.model.Article;
import com.apiufpso.tienda.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article createArticle(Article articleReq){
        return  articleRepository.save(articleReq);
    }

    public Article getArticleById(Long id){
        return articleRepository.findById(id).get();
    }

    public List<Article> findAllArticles(){
        return (List<Article>) articleRepository.findAll();
    }

    public Article updateArticle(Article articleReq, Long id){
        Optional <Article> articleBd = articleRepository.findById(id);
        if(articleBd.isEmpty()){
            return null;
        }
        articleBd.get().setNameArticle(articleReq.getNameArticle());
        articleBd.get().setDescription(articleReq.getDescription());
        articleBd.get().setPrice(articleReq.getPrice());
        articleBd.get().setCategory(articleReq.getCategory());
        return articleRepository.save(articleBd.get());
    }


}
