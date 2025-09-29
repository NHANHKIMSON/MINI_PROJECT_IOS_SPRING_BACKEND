package org.example.mini_project_api.dto.request.product;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String image;
    private Double price;
    private Boolean isFavorite;
    private Integer categoryId;
}