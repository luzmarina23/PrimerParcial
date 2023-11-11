package com.apiufpso.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCategory;

    @NotNull(message = "nameCategory is required")
    @Size(min=3, max = 150, message = "nameCategory min 3 characters and max 150")
    private String nameCategory;

    @NotNull(message = "descriptionCategory is required")
    @Size(min = 3, max = 255, message = "descriptionCategory min 3 characters and max 255")
    private String descriptionCategory;
}
