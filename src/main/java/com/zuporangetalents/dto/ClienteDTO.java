package com.zuporangetalents.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String name;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
}
