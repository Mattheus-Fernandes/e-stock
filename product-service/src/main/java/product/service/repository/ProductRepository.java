package product.service.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import product.service.dao.ProductDAO;
import product.service.domain.Product;

@ApplicationScoped
public class ProductRepository {

    @Inject
    private ProductDAO productDAO;

    public void save(Product product) {
        productDAO.insert(product);
    }

    public boolean findProductByName(String name, String brand) {
        return productDAO.existsProduct(name, brand);
    }
}
