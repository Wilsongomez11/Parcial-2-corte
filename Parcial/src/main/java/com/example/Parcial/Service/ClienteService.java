package com.example.Parcial.Service;

import com.example.Parcial.Model.Cliente;
import com.example.Parcial.Model.ResourceNotFoundException;
import com.example.Parcial.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Integer id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id " + id));
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setTelefono(clienteDetails.getTelefono());
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente no encontrado con id " + id);
        }
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}



