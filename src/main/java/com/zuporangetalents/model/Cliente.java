package com.zuporangetalents.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "email", unique = true)
    @Email(message = "Email inválido")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O campo 'CPF' não pode estar vazio.")
    @Size(min = 11, max = 11, message = "CPF inválido.")
    @org.hibernate.validator.constraints.br.CPF
    private String CPF;

    @Column(nullable = false, name="data_nascimento")
    @NotBlank(message = "O campo data de nascimento não pode estar vazio!")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonIgnore //As contas não serão serializados
    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas = new ArrayList<>();
}
