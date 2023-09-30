package com.apiufpso.tienda.controller;
import com.apiufpso.tienda.model.Category;
import com.apiufpso.tienda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("categories")                                                   //EndPoint POST para "Enviar valores"
    public ResponseEntity<Category> create(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }
    @GetMapping("categories/{idCategory}")                                       //EndPoint GET para "Obtener por ID"
    public ResponseEntity<Category> getCategoryById(@PathVariable Long idCategory){
        return ResponseEntity.ok(categoryService.getCategoryById(idCategory));
    }
    @PutMapping("categories/{idCategory}")                                      //EndPoint PUT para "Actualizar por ID"
    public ResponseEntity<Category> update(@RequestBody Category category,@PathVariable Long idCategory){
        return new ResponseEntity<>(categoryService.updateCategory(category, idCategory), HttpStatus.OK);
    }
    @DeleteMapping("categories/{idCategory}")                                  //EndPoint DELETE para "Borrar por ID"
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity(categoryService.deleteCategory(id), HttpStatus.NO_CONTENT);
    }
    @GetMapping("Categories")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }}
