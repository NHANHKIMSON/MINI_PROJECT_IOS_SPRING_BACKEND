package org.example.mini_project_api.service.Implement;

import org.example.mini_project_api.Entity.CategoryEntity;
import org.example.mini_project_api.Entity.ProductEntity;
import org.example.mini_project_api.dto.request.product.ProductRequest;
import org.example.mini_project_api.exception.NotFoundException;
import org.example.mini_project_api.repository.product.ProductRepository;
import org.example.mini_project_api.service.CategoryService;
import org.example.mini_project_api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImplement(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }
    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public ProductEntity createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productRequest.getName());
        CategoryEntity category = categoryService.getCategoryById(productRequest.getCategoryId());
        productEntity.setCategory(category);
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product Not Found"));
    }
}