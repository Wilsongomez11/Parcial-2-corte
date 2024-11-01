package com.example.Parcial.Repository;

import com.example.Parcial.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    List<Autor> findByNombre(String nombre);
}

