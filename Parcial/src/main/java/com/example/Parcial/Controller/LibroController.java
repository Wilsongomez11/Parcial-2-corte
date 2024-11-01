package com.example.Parcial.Controller;

import com.example.Parcial.Model.Libro;
import com.example.Parcial.Service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro, @RequestParam Integer autorId, @RequestParam Integer generoId) {
        return libroService.save(libro, autorId, generoId);
    }


    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Integer id, @RequestBody Libro libroDetails, @RequestParam Integer autorId, @RequestParam Integer generoId) {
        return libroService.update(id, libroDetails, autorId, generoId);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Integer id) {
        libroService.delete(id);
    }

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroService.findAll();
    }

    @GetMapping("/disponibles")
    public List<Libro> obtenerLibrosDisponibles() {
        return libroService.findLibrosDisponibles();
    }
}



