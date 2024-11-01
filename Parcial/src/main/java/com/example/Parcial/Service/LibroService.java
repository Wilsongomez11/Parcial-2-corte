package com.example.Parcial.Service;

import com.example.Parcial.Model.Autor;
import com.example.Parcial.Model.Genero;
import com.example.Parcial.Model.Libro;
import com.example.Parcial.Model.ResourceNotFoundException;
import com.example.Parcial.Repository.AutorRepository;
import com.example.Parcial.Repository.GeneroRepository;
import com.example.Parcial.Repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public Libro save(Libro libro, Integer autorId, Integer generoId) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado con id " + autorId));
        Genero genero = generoRepository.findById(generoId)
                .orElseThrow(() -> new ResourceNotFoundException("Género no encontrado con id " + generoId));

        libro.setAutor(autor);
        libro.setGenero(genero);

        return libroRepository.save(libro);
    }

    public Libro update(Integer id, Libro libroDetails, Integer autorId, Integer generoId) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con id " + id));

        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado con id " + autorId));
        Genero genero = generoRepository.findById(generoId)
                .orElseThrow(() -> new ResourceNotFoundException("Género no encontrado con id " + generoId));

        libro.setTitulo(libroDetails.getTitulo());
        libro.setDisponibilidad(libroDetails.getDisponiblilidad());
        libro.setAutor(autor);
        libro.setGenero(genero);

        return libroRepository.save(libro);
    }

    public void delete(Integer id) {
        if (!libroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Libro no encontrado con id " + id);
        }
        libroRepository.deleteById(id);
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public List<Libro> findLibrosDisponibles() {
        return libroRepository.findLibrosDisponibles();
    }
}

