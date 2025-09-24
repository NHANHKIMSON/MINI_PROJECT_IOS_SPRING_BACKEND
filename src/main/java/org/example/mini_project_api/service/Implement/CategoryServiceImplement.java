package org.example.mini_project_api.service.Implement;

import org.example.mini_project_api.Entity.CategoryEntity;
import org.example.mini_project_api.dto.request.product.CategoryRequest;
import org.example.mini_project_api.exception.NotFoundException;
import org.example.mini_project_api.repository.product.CategoryRepository;
import org.example.mini_project_api.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImplement implements CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryServiceImplement(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryEntity> categoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryById(Integer id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            throw new NotFoundException("Category not found");
        }
        return category;
    }

    @Override
    public CategoryEntity createCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryRequest.getName());
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(Integer id, CategoryRequest categoryRequest) {
        CategoryEntity category = getCategoryById(id);
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }
    @Override
    public CategoryEntity deleteCategory(Integer id) {
        CategoryEntity category = getCategoryById(id);
        if (category != null) {
            categoryRepository.delete(category);
        }
        return category;
    }
}
