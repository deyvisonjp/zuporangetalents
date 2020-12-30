package com.zuporangetalents.controller.exceptions.type;

public class DataIntegrationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrationException(String ex) {
        super(ex);
    }
}