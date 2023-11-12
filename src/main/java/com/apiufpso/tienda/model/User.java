package com.apiufpso.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull(message = "firstname is required")
    @Size(min = 3,max = 255, message = "firstname max 255 characters")
    private String firstName;

    @NotNull(message = "lastname is required")
    @Size(min = 3, max = 255, message = "firstname max 255 characters")
    private String lastname;

    @NotNull(message = "document is required")
    @Size(min = 5, max = 15, message = "document min 5 characters and max 15")
    private String document;

    private String phone;

    @NotNull(message = "email is required")
    @Email(message = "email not valid")
    private String email;

    @JsonIgnore
    @NotNull(message = "password is required")
    @Size(min = 8, max = 15, message = "password min 8 characters and max 15")
    private String password;

}
