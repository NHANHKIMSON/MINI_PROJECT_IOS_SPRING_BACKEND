package org.example.mini_project_api.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_detail")
@Data
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String condition;
    private String brand;
    private String model;

    @ElementCollection
    @CollectionTable(
            name = "product_images",                       // new table name
            joinColumns = @JoinColumn(name = "product_detail_id")  // FK to product_detail
    )
    @Column(name = "image_url")                         // column name for each string
    private List<String> images = new ArrayList<>();
    private String color;
    private String year;
    private String size;
    private String type;
    private String description;

    @OneToOne(mappedBy = "productDetail", cascade = CascadeType.ALL)
    @JsonBackReference
    private ProductEntity productEntity;
}
