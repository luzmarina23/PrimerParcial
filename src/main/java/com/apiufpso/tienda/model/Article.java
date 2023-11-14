package com.apiufpso.tienda.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Article {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull(message = "nameArticulo is required")
    @Size(min=3, max=150, message = "nameArticulo min 3 characters max 150 ")
    private String nameArticle;

    @NotNull(message = "description is required")
    @Size(min=5, max=200, message = "Description min 5 characters max 200")
    private String description;

    @NotNull(message = "price is required")
    private Double price;

    @NotNull(message = "stock is required")
    private int stock;
    
    //muchos articulos, una categoria
    @ManyToOne()
    //realizar la union
    @JoinColumn(name = "idCategory",referencedColumnName = "idCategory")
    private Category category;
}
