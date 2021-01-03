package com.zuporangetalents.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zuporangetalents.dto.ClienteDTO;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;

    @JsonIgnore //As contas não serão serializados
    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas = new ArrayList<>();

    @Transient
    public ClienteDTO clienteDTO(){
        return new ClienteDTO(nome, email, cpf, dataNascimento);
    }

}
