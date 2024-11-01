package com.example.Parcial.Service;

import com.example.Parcial.Model.Genero;
import com.example.Parcial.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public void delete(Integer id) {
        generoRepository.deleteById(id);
    }

    public Genero update(Integer id, Genero generoDetails) {
        Optional<Genero> optionalGenero = generoRepository.findById(id);
        if (optionalGenero.isPresent()) {
            Genero genero = optionalGenero.get();
            genero.setNombre(generoDetails.getNombre());
            return generoRepository.save(genero);
        }
        return null;
    }
}




