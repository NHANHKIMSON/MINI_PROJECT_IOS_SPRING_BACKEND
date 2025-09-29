package org.example.mini_project_api.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.mini_project_api.Entity.ProductEntity;
import org.example.mini_project_api.dto.request.product.ProductFavoriteRequest;
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
    @Operation(summary = "Get All Products")
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
    @Operation(summary = "Create New Product")
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
    @Operation(summary = "Get Product By Id")
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
    @Operation(summary = "Update Product By Id")
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
    @Operation(summary = "Delete Product By Id")
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
    @PatchMapping("/{id}")
    @Operation(summary = "Update Product Status By Id")
    public ApiResponse<ProductEntity> updateProductStatus(@PathVariable("id") Integer id, @RequestBody ProductFavoriteRequest productFavoriteRequest) {
        ApiResponse<ProductEntity> productResponseEntity;
        productResponseEntity = ApiResponse.<ProductEntity>builder()
                .message("Update Product Status Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.updateProductStatus(id, productFavoriteRequest))
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }

    @GetMapping("/{categoryId}")
    public ApiResponse<List<ProductEntity>> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        ApiResponse<List<ProductEntity>> productResponseEntity;
        productResponseEntity = ApiResponse.<List<ProductEntity>>builder()
                .message("Get Products Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.getProductByCategoryId(categoryId))
                .build();
        return productResponseEntity;
    }

    @GetMapping("isFavorite")
    @Operation(summary = "Get All Product Favorite")
    public ApiResponse<List<ProductEntity>> getSaveProducts() {
        ApiResponse<List<ProductEntity>> productResponseEntity;
        productResponseEntity = ApiResponse.<List<ProductEntity>>builder()
                .message("Get Products Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.getSaveProduct())
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }

    @GetMapping("top/{max}")
    public ApiResponse<List<ProductEntity>> getTopProducts(@PathVariable Double max) {
        ApiResponse<List<ProductEntity>> productResponseEntity;
        productResponseEntity = ApiResponse.<List<ProductEntity>>builder()
                .message("Get Products Successfully!")
                .status(HttpStatus.OK)
                .payload(productService.getTopProducts(max))
                .time(LocalDateTime.now())
                .build();
        return productResponseEntity;
    }
}
