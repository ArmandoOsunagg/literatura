package com.alura.literatura.repository;


import com.alura.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;



public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByFechaDefuncionIsNullAndFechaNacimientoBefore(LocalDate fecha);
    Autor findByNombre(String nombre);
}