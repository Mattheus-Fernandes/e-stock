package product.service.domain;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import product.service.utils.ProductQueries;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@NamedNativeQueries(
        @NamedNativeQuery(
                name = ProductQueries.INSERT_PRODUCT_NAME,
                query = ProductQueries.INSERT_PRODUCT_QUERY
        )
)
public class Product {

    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "brand", nullable = false)
    private String brand;
    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Product() {}

    public Product(UUID id, String name, String brand, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
