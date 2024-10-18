package com.entrevista.cliente.persona.springboot_entrevista.dto;

public class ClienteDTO {
    private Long clienteid;
    private String nombre;

    public Long getClienteid() {
        return clienteid;
    }
    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
