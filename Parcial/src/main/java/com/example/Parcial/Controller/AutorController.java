package com.example.Parcial.Controller;

import com.example.Parcial.Model.Autor;
import com.example.Parcial.Service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @PutMapping("/{id}")
    public Autor actualizarAutor(@PathVariable Integer id, @RequestBody Autor autorDetails) {
        return autorService.update(id, autorDetails);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Integer id) {
        autorService.delete(id);
    }

    @GetMapping
    public List<Autor> obtenerAutores() {
        return autorService.findAll();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Autor> obtenerAutoresPorNombre(@PathVariable String nombre) {
        return autorService.findByNombre(nombre);
    }
}



