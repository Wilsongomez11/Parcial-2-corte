package com.example.Parcial.Repository;

import com.example.Parcial.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {


    @Query(value = "SELECT * FROM prestamo WHERE devuelto = false", nativeQuery = true)
    List<Prestamo> findPrestamosNoDevueltos();


    @Query(value = "SELECT * FROM prestamo WHERE cliente_id = :clienteId AND fecha_prestamo = :fechaPrestamo", nativeQuery = true)
    List<Prestamo> findPrestamosByClienteAndFecha(Integer clienteId, Date fechaPrestamo);
}
