package product.service.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import product.service.domain.Product;
import product.service.utils.ProductQueries;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class ProductDAO {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public void insert(Product product) {

        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }

        product.setCreatedAt(LocalDateTime.now());

        entityManager
                .createNamedQuery(ProductQueries.INSERT_PRODUCT_NAME)
                .setParameter("id", product.getId())
                .setParameter("name", product.getName())
                .setParameter("brand", product.getBrand())
                .setParameter("created_at", product.getCreatedAt())
                .executeUpdate();
    }

    public boolean existsProduct(String name, String brand) {

        return (Boolean) entityManager
                .createNamedQuery(ProductQueries.EXISTS_PRODUCT_BY_NAME_NAME)
                .setParameter("name", name)
                .setParameter("brand", brand)
                .getSingleResult();
    }
}
