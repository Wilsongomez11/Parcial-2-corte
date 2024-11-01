package com.example.Parcial.Service;

import com.example.Parcial.Model.Prestamo;
import com.example.Parcial.Repository.PrestamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;



    public List<Prestamo> obtenerPrestamosNoDevueltos() {
        return prestamoRepository.findPrestamosNoDevueltos();
    }

    public List<Prestamo> obtenerPrestamosPorClienteYFecha(Integer clienteId, Date fechaPrestamo) {
        return prestamoRepository.findPrestamosByClienteAndFecha(clienteId, fechaPrestamo);
    }
}


