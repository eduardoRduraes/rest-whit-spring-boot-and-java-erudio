package br.com.erudio.restwhitspringbootandjavaerudio.exception.handler;


import br.com.erudio.restwhitspringbootandjavaerudio.exception.ExceptionResponse;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.InvalidJwtAuthenticationException;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.RequireObjectIsNullException;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest wr) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest wr) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequireObjectIsNullException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest wr) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidJWTAuthenticateException(Exception ex, WebRequest wr) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), wr.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }
}


