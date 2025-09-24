package org.example.mini_project_api.service;

import org.example.mini_project_api.Entity.CategoryEntity;
import org.example.mini_project_api.dto.request.product.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> categoryList();

    CategoryEntity getCategoryById(Integer id);

    CategoryEntity createCategory(CategoryRequest categoryRequest);

    CategoryEntity updateCategory(Integer id, CategoryRequest categoryRequest);

    CategoryEntity deleteCategory(Integer id);
}
