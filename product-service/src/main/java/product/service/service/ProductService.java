package product.service.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import product.service.domain.Product;
import product.service.exceptions.NotNullException;
import product.service.exceptions.ProductAlReadyExistsException;
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
        if(product.getName() == null || product.getName().isBlank() ) {
            throw new NotNullException("O nome é obrigatório");
        }

        if(product.getBrand() == null || product.getBrand().isBlank() ) {
            throw new NotNullException("A marca é obrigatória");
        }

        boolean existsProduct = productRepository.findProductByName(product.getName(), product.getBrand());

        if(existsProduct) {
            throw new ProductAlReadyExistsException("Produto já cadastrado");
        }
    }
}
