package product.service.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import product.service.domain.Product;
import product.service.repository.ProductRepository;


@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    @Transactional
    public void addNewProduct(Product product) {
        validateProduct(product);

        productRepository.save(product);
    }

    private void validateProduct(Product product) {
        boolean existsProduct = productRepository.findProductByName(product.getName(), product.getBrand());

        if(existsProduct) {
            throw new RuntimeException("Produto já cadastrado");
        }
    }
}
