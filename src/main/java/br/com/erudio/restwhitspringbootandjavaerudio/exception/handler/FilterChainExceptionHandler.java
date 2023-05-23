package br.com.erudio.restwhitspringbootandjavaerudio.exception.handler;

import br.com.erudio.restwhitspringbootandjavaerudio.exception.InvalidJwtAuthenticationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class FilterChainExceptionHandler extends OncePerRequestFilter {

    final HandlerExceptionResolver resolver;

    public FilterChainExceptionHandler(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver){
        this.resolver = resolver;
    }

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  {
        try{
            filterChain.doFilter(request, response);
        }catch (Exception ex){
            log.error("Error: "+ex.getClass().getSimpleName()+" - "+ ex.getMessage());
            resolver.resolveException(request, response, null, new InvalidJwtAuthenticationException("Error: "+ex.getClass().getSimpleName()+" - "+ ex.getMessage()));
        }
    }
}
