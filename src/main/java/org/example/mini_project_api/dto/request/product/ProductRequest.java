package org.example.mini_project_api.dto.request.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
    private String name;
    private List<String> imagesUrl;
    private Double price;
    private Boolean isFavorite;
    private Integer categoryId;
    private ProductDetailRequest productDetail;
}