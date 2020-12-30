package com.zuporangetalents.controller.exceptions;

import com.zuporangetalents.controller.exceptions.type.DataIntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DataIntegrationException.class)
    public ResponseEntity<StandardError> dataError(DataIntegrationException e, HttpServletRequest request) {
        // Monta um objeto do tipo StandardError informando os dados da Exception
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}