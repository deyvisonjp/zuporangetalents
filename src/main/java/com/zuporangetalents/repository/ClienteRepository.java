package com.zuporangetalents.repository;

import com.zuporangetalents.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Aqui podemos adicionar metódos extras
    // No nosso caso, queremos um rtetorno de cliente por e-mail
    Optional<Cliente> findOptionalByEmail(String email);
}
