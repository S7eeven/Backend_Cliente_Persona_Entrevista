package com.entrevista.cliente.persona.springboot_entrevista.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entrevista.cliente.persona.springboot_entrevista.entity.Cliente;
import com.entrevista.cliente.persona.springboot_entrevista.entity.Persona;
import com.entrevista.cliente.persona.springboot_entrevista.repository.ClienteRepository;
import com.entrevista.cliente.persona.springboot_entrevista.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public Cliente crearCliente(Cliente cliente) {
        // Verificar si la Persona ya existe
        Optional<Persona> personaExistente = personaRepository.findByIdentificacion(cliente.getPersona().getIdentificacion());
        if(personaExistente.isPresent()) {
            cliente.setPersona(personaExistente.get());
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
