package br.com.erudio.restwhitspringbootandjavaerudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.core.AuthenticationException;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException  implements Serializable {

    private static final long serialVersionUID = 1L;

    public InvalidJwtAuthenticationException(String ex) {
        super(ex);
    }
}
