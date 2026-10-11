package product.service.exceptions;

public class NotNullException extends RuntimeException {
    public NotNullException(String message) {
        super(message);
    }
}
