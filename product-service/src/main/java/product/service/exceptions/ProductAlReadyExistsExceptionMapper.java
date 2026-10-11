package product.service.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import product.service.dto.ResponseError;

@Provider
public class ProductAlReadyExistsExceptionMapper implements ExceptionMapper<ProductAlReadyExistsException> {

    @Override
    public Response toResponse(ProductAlReadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT.getStatusCode())
                .entity(new ResponseError(Response.Status.CONFLICT.getStatusCode(), e.getMessage()))
                .build();
    }
}
