package product.service.exceptions;

public class ProductAlReadyExistsException extends RuntimeException {
    public ProductAlReadyExistsException(String message) {
        super(message);
    }
}
