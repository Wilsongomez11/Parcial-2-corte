package com.example.Parcial.Controller;

import com.example.Parcial.Model.Prestamo;
import com.example.Parcial.Service.PrestamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;



    @GetMapping("/no-devueltos")
    public List<Prestamo> obtenerPrestamosNoDevueltos() {
        return prestamoService.obtenerPrestamosNoDevueltos();
    }

    @GetMapping("/cliente/{clienteId}/fecha")
    public List<Prestamo> obtenerPrestamosPorClienteYFecha(@PathVariable Integer clienteId,
                                                           @RequestParam Date fechaPrestamo) {
        return prestamoService.obtenerPrestamosPorClienteYFecha(clienteId, fechaPrestamo);
    }
}



