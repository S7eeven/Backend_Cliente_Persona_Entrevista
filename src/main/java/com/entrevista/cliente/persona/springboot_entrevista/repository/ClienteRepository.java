package com.entrevista.cliente.persona.springboot_entrevista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entrevista.cliente.persona.springboot_entrevista.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
