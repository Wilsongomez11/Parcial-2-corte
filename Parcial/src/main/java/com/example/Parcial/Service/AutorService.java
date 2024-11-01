package com.example.Parcial.Service;

import com.example.Parcial.Model.Autor;
import com.example.Parcial.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public void delete(Integer id) {
        autorRepository.deleteById(id);
    }


    public List<Autor> findByNombre(String nombre) {
        return autorRepository.findByNombre(nombre);
    }


    public Autor update(Integer id, Autor autorDetails) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        if (optionalAutor.isPresent()) {
            Autor autor = optionalAutor.get();
            autor.setNombre(autorDetails.getNombre());
            return autorRepository.save(autor);
        }
        return null;
    }


    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
}





