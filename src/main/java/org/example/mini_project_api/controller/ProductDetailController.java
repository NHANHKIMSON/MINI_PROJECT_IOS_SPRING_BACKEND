package org.example.mini_project_api.controller;


import org.example.mini_project_api.Entity.ProductDetail;
import org.example.mini_project_api.Entity.ProductEntity;
import org.example.mini_project_api.dto.response.ApiResponse;
import org.example.mini_project_api.repository.product.ProductDetailRepository;
import org.example.mini_project_api.service.ProductDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/product-dettails")
public class ProductDetailController {

}

