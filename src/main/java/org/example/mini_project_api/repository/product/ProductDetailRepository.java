package org.example.mini_project_api.repository.product;

import org.example.mini_project_api.Entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}
