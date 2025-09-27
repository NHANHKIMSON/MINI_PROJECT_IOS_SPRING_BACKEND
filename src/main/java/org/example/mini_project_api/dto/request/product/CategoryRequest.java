package org.example.mini_project_api.dto.request.product;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;
    private String icon;
}