package com.apiufpso.tienda.service;

import com.apiufpso.tienda.model.Category;
import com.apiufpso.tienda.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category createCategory(Category categoryReq){
        return categoryRepository.save(categoryReq);
    }
    public  Category getCategoryById(Long idCategory){
        return categoryRepository.findById(idCategory).get();
    }
    public Category updateCategory(Category categoryReq, Long idCategory){
        Optional<Category> categoryBd = categoryRepository.findById(idCategory);
        if(categoryBd.isEmpty()){
            return null;
        }
        categoryBd.get().setNameCategory(categoryReq.getNameCategory());
        categoryBd.get().setDescriptionCategory(categoryReq.getDescriptionCategory());
        return categoryRepository.save(categoryBd.get());
    }
    public boolean deleteCategory(Long idCategory){
        Optional<Category> categoryBd = categoryRepository.findById(idCategory);
        if(categoryBd.isEmpty()){
            return false;
        }
        categoryRepository.delete(categoryBd.get());
        return true;
    }
    public List<Category> findAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
}
