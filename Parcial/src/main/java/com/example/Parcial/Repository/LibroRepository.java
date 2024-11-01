package com.example.Parcial.Repository;

import com.example.Parcial.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    @Query("SELECT l FROM Libro l WHERE l.disponibilidad = true")
    List<Libro> findLibrosDisponibles();
}

