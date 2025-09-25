package org.example.mini_project_api.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Boolean isFavorite = false;
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    CategoryEntity category;

    @OneToOne()
    @JoinColumn(name = "detail_id")
    @JsonManagedReference
    private ProductDetail productDetail;
}