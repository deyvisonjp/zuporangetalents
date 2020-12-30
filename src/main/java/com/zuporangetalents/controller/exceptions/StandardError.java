package com.zuporangetalents.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError  implements Serializable {
    private Integer value;
    private String message;
    private long currentTimeMillis;
}