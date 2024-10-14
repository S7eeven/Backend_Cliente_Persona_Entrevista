package com.entrevista.cliente.persona.springboot_entrevista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entrevista.cliente.persona.springboot_entrevista.entity.Persona;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByIdentificacion(String identificacion);
}
