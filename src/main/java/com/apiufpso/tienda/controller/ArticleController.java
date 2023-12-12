package com.apiufpso.tienda.controller;

import com.apiufpso.tienda.model.Article;
import com.apiufpso.tienda.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("articles")
    public ResponseEntity<Article> create(@Valid @RequestBody Article article){
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
    public ResponseEntity<Article> update(@Valid @RequestBody Article article, @PathVariable Long id){
            return new ResponseEntity<>(articleService.updateArticle(article, id), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
