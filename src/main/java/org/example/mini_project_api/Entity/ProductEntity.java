package org.example.mini_project_api.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> imagesUrl;
    private Boolean isFavorite = false;
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    CategoryEntity category;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "detail_id")
    @JsonManagedReference
    private ProductDetail productDetail;
}