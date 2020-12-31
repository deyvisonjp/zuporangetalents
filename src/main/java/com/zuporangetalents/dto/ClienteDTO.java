package com.zuporangetalents.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
}
