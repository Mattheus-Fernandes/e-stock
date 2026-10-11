package product.service.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import product.service.dto.ResponseError;

@Provider
public class NotNullExceptionMapper implements ExceptionMapper<NotNullException> {

    @Override
    public Response toResponse(NotNullException e) {
        return Response
                .status(Response.Status.BAD_REQUEST.getStatusCode())
                .entity(new ResponseError(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage()))
                .build();
    }
}
