package com.apiufpso.tienda.util;

import lombok.Getter;

@Getter
public enum Constants {
    USER_NOT_FOUND("User not found"),
<<<<<<< HEAD
    USER_IS_NULL("User is null"),
    ADDRESS_NOT_FOUND("Address not found"),
    CREDENTIAL_INVALID("Credentials invalid!"),
    USER_EMAIL_EXISTS("The email is already registered");
=======
    ARTICLE_NOT_FOUND("Article not found"),
    CATEGORY_NOT_FOUND("Category not found"),
    CREDENTIAL_INVALID("Credentials invalid"),
    USER_EMAIL_EXIST("The email is already registered");
>>>>>>> dfe4cf768b2ad1b7379eb540dcffe72d74e35316

    private String message;
    Constants (String s){
        this.message=s;
    }
}
