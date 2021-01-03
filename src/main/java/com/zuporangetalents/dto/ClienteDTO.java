package com.zuporangetalents.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nome;
    private String email;
    private String cpf;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;
}
