package com.example.Parcial.Controller;

import com.example.Parcial.Model.Genero;
import com.example.Parcial.Service.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public Genero crearGenero(@RequestBody Genero genero) {
        return generoService.save(genero);
    }

    @PutMapping("/{id}")
    public Genero actualizarGenero(@PathVariable Integer id, @RequestBody Genero generoDetails) {
        return generoService.update(id, generoDetails);
    }

    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable Integer id) {
        generoService.delete(id);
    }

    @GetMapping
    public List<Genero> obtenerGeneros() {
        return generoService.findAll();
    }
}


