package com.zuporangetalents.repository;

import com.zuporangetalents.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Aqui poderíamos adicionar metódos extras
}
