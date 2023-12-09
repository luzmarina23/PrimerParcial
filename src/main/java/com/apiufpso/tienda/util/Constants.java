package com.apiufpso.tienda.util;

import com.apiufpso.tienda.model.Category;
import lombok.Getter;

@Getter
public enum Constants {
    USER_NOT_FOUND("User not found"),
    ARTICLE_NOT_FOUND("Article not found"),
    CATEGORY_NOT_FOUND("Category not found"),
    CREDENTIAL_INVALID("Credentials invalid"),
    USER_EMAIL_EXIST("The email is already registered");

    private String message;
    Constants (String s){
        this.message=s;
    }
}
