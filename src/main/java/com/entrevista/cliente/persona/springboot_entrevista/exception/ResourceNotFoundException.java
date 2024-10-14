package com.entrevista.cliente.persona.springboot_entrevista.exception;

public class ResourceNotFoundException extends RuntimeException {
     public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
