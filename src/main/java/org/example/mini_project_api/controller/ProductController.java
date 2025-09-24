package org.example.mini_project_api.controller;


import org.example.mini_project_api.Entity.ProductEntity;
import org.example.mini_project_api.dto.request.product.ProductRequest;
import org.example.mini_project_api.dto.response.ApiResponse;
import org.example.mini_project_api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ApiResponse<List<ProductEntity>> getAllProducts() {
        ApiResponse<List<ProductEntity>> productResponseEntity;
        productResponseEntity = ApiResponse.<List<ProductEntity>>builder()
                .message("Get Products Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.getAllProducts())
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }
    @PostMapping
    public ApiResponse<ProductEntity> createProduct(@RequestBody ProductRequest productRequest) {
        ApiResponse<ProductEntity> productResponseEntity;
        productResponseEntity = ApiResponse.<ProductEntity>builder()
                .message("Create Product Successfully!")
                .status(HttpStatus.CREATED)
                .payload(productService.createProduct(productRequest))
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }


    @GetMapping("/{id}")
    public ApiResponse<ProductEntity> getProductById(@PathVariable Integer id) {
        ApiResponse<ProductEntity> productResponseEntity;
        productResponseEntity  = ApiResponse.<ProductEntity>builder()
                .message("Get Product Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.getProductById(id))
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductEntity> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductRequest productRequest) {
        ApiResponse<ProductEntity> productResponseEntity;
        productResponseEntity = ApiResponse.<ProductEntity>builder()
                .message("Update Product Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.updateProduct(id, productRequest))
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }
    @DeleteMapping("/{id}")
    public ApiResponse<ProductEntity> deleteProduct(@PathVariable("id") Integer id) {
        ApiResponse<ProductEntity> productResponseEntity;
        productResponseEntity = ApiResponse.<ProductEntity>builder()
                .message("Delete Product Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.deleteProduct(id))
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }
}
