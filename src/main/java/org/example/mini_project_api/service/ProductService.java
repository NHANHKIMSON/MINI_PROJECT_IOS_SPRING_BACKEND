package org.example.mini_project_api.service;

import org.example.mini_project_api.Entity.ProductEntity;
import org.example.mini_project_api.dto.request.product.ProductRequest;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProducts();
    ProductEntity createProduct(ProductRequest productRequest);
    ProductEntity getProductById(Integer id);
}
