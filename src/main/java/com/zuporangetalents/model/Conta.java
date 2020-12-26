package com.zuporangetalents.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConta")
    private Integer idConta;

    @Column(name="saldo")
    private Double saldo;

    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
}
