package org.example.mini_project_api.repository.product;

import org.example.mini_project_api.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query("select p from ProductEntity p join  fetch p.category")
    List<ProductEntity> getAllProducts();

    ProductEntity findByCategory_Id(Long categoryId);

    List<ProductEntity> getAllProductByCategory_Id(Long categoryId);

    @Query("SELECT p FROM ProductEntity p WHERE p.isFavorite = true")
    List<ProductEntity> getAllFavoriteProducts();

    List<ProductEntity> getTopByPrice(Double price);

    @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE %?1%")
    List<ProductEntity> findByTitleContainingIgnoreCase(String title);
}
