package com.apiufpso.tienda.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Article {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY )
    private Long id;
    private String nameArticle;
    private String description;
    private Double price;
    //realizar la union
    @JoinColumn(name = "idCategory",referencedColumnName = "idCategory")
    private Category category;
}
