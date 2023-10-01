package com.apiufpso.tienda.controller;

import com.apiufpso.tienda.model.Article;
import com.apiufpso.tienda.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("articles")
    public ResponseEntity<Article> create(@RequestBody Article article){
        return  new ResponseEntity<>(articleService.createArticle(article), HttpStatus.CREATED);
    }

    @GetMapping("articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id){
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @GetMapping("articles")
    public ResponseEntity<List<Article>> findAll(){

        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @PutMapping("articles/{id}")
    public ResponseEntity<Article> update(@RequestBody Article article, @PathVariable Long id){
            return new ResponseEntity<>(articleService.updateArticle(article, id), HttpStatus.OK);
    }
}
