package com.apiufpso.tienda.util;

import lombok.Getter;

@Getter
public enum Constants {
    USER_NOT_FOUND("User not found"),
    ARTICLE_NOT_FOUND("Article not found");

    private String message;
    Constants (String s){
        this.message=s;
    }
}
