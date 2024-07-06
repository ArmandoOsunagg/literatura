package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GutendexService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        return libroRepository.findByTituloContaining(titulo);
    }

    public List<Libro> listarLibrosRegistrados() {
        return libroRepository.findAll();
    }

    public List<Autor> listarAutoresRegistrados() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosEnAnio(int anio) {
        return autorRepository.findByFechaDefuncionIsNullAndFechaNacimientoBefore(LocalDate.of(anio, 1, 1));
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

}
