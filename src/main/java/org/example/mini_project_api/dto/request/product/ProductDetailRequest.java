package org.example.mini_project_api.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailRequest {
    private String condition;
    private String brand;
    private String model;
    private String color;
    private String year;
    private String size;
    private String type;
    private String description;
}
