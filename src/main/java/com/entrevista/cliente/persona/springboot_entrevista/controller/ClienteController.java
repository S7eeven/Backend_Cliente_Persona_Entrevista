package com.entrevista.cliente.persona.springboot_entrevista.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entrevista.cliente.persona.springboot_entrevista.dto.ClienteDTO;
import com.entrevista.cliente.persona.springboot_entrevista.entity.Cliente;
import com.entrevista.cliente.persona.springboot_entrevista.exception.ResourceNotFoundException;
import com.entrevista.cliente.persona.springboot_entrevista.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
     @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        try {
            Cliente creado = clienteService.crearCliente(cliente);
            return ResponseEntity.ok(creado);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}/dto")
    public ResponseEntity<ClienteDTO> obtenerClienteDTO(@PathVariable Long id) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setClienteid(cliente.getClienteid());
        clienteDTO.setNombre(cliente.getPersona().getNombre());
        return ResponseEntity.ok(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalles) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));

        cliente.setContraseña(clienteDetalles.getContraseña());
        cliente.setEstado(clienteDetalles.getEstado());
        // Actualizar Persona si es necesario
        if(clienteDetalles.getPersona() != null) {
            cliente.setPersona(clienteDetalles.getPersona());
        }

        Cliente actualizado = clienteService.actualizarCliente(cliente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
