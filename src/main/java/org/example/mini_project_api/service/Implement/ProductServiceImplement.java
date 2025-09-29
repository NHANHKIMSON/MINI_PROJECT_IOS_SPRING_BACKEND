package org.example.mini_project_api.service.Implement;

import org.example.mini_project_api.Entity.CategoryEntity;
import org.example.mini_project_api.Entity.ProductDetail;
import org.example.mini_project_api.Entity.ProductEntity;
import org.example.mini_project_api.dto.request.product.ProductFavoriteRequest;
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
        productEntity.setImagesUrl(productRequest.getImagesUrl());
        productEntity.setIsFavorite(productRequest.getIsFavorite());
        CategoryEntity category = categoryService.getCategoryById(productRequest.getCategoryId());
        productEntity.setCategory(category);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setCondition(productRequest.getProductDetail().getCondition());
        productDetail.setBrand(productRequest.getProductDetail().getBrand());
        productDetail.setModel(productRequest.getProductDetail().getModel());
        productDetail.setColor(productRequest.getProductDetail().getColor());
        productDetail.setYear(productRequest.getProductDetail().getYear());
        productDetail.setSize(productRequest.getProductDetail().getSize());
        productDetail.setType(productRequest.getProductDetail().getType());
        productDetail.setDescription(productRequest.getProductDetail().getDescription());
        productEntity.setProductDetail(productDetail);
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product Not Found"));
    }

    @Override
    public ProductEntity updateProduct(Integer id, ProductRequest productRequest) {
        ProductEntity productEntity = getProductById(id);
        productEntity.setName(productRequest.getName());
        productEntity.setImagesUrl(productRequest.getImagesUrl());
        productEntity.setIsFavorite(productRequest.getIsFavorite());
        CategoryEntity category = categoryService.getCategoryById(productRequest.getCategoryId());
        productEntity.setCategory(category);
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity deleteProduct(Integer id) {
        ProductEntity productEntity = getProductById(id);
        productRepository.delete(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity updateProductStatus(Integer id, ProductFavoriteRequest productFavoriteRequest) {
        ProductEntity productEntity = getProductById(id);
        productEntity.setIsFavorite(productFavoriteRequest.getIsFavorite());
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getProductByCategoryId(Long categoryId) {
        System.out.println(categoryId);
        List<ProductEntity> productEntities = productRepository.getAllProductByCategory_Id(categoryId);
        if (productEntities.size() == 0) {
            throw new NotFoundException("Product Not Found");
        }
        return productEntities;
    }
}