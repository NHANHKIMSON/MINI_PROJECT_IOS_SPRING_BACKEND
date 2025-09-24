package org.example.mini_project_api.controller;


import jakarta.validation.Valid;
import org.example.mini_project_api.Entity.CategoryEntity;
import org.example.mini_project_api.dto.request.product.CategoryRequest;
import org.example.mini_project_api.dto.response.ApiResponse;
import org.example.mini_project_api.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryEntity>>> categoryList() {
        ApiResponse<List<CategoryEntity>> categoryResponse = ApiResponse.<List<CategoryEntity>>builder()
                .message("Get category successfully")
                .status(HttpStatus.OK)
                .payload(categoryService.categoryList())
                .time(LocalDateTime.MAX)
                .build();

        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryEntity>> getCategoryById(@PathVariable Integer id) {
        ApiResponse<CategoryEntity> categoryEntityApiResponse = ApiResponse.<CategoryEntity>builder()
                .message("Get category by id has successfully")
                .status(HttpStatus.OK)
                .time(LocalDateTime.MAX)
                .payload(categoryService.getCategoryById(id))
                .build();
        return ResponseEntity.ok(categoryEntityApiResponse);
    }

    @PostMapping
    public ApiResponse<CategoryEntity> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        ApiResponse<CategoryEntity> categoryEntityApiResponse;
        categoryEntityApiResponse = ApiResponse.<CategoryEntity>builder()
                .message("Create category has successfully")
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .payload(categoryService.createCategory(categoryRequest))
                .build();
        return categoryEntityApiResponse;
    }
    @PutMapping("/{id}")
    public ApiResponse<CategoryEntity> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryRequest categoryRequest) {
        ApiResponse<CategoryEntity> categoryEntityApiResponse;
        categoryEntityApiResponse = ApiResponse.<CategoryEntity>builder()
                .message("Update category has successfully")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .payload(categoryService.updateCategory(id, categoryRequest))
                .build();
        return categoryEntityApiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<CategoryEntity> deleteCategory(@PathVariable("id") Integer id) {
        ApiResponse<CategoryEntity> categoryEntityApiResponse;
        categoryEntityApiResponse = ApiResponse.<CategoryEntity>builder()
                .message("Delete category has successfully")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .payload(categoryService.deleteCategory(id))
                .build();
        return categoryEntityApiResponse;
    }
}
