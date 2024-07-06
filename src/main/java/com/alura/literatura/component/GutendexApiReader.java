package com.alura.literatura.component;

import com.alura.literatura.dto.AutorDto;
import com.alura.literatura.dto.GutendexResponse;
import com.alura.literatura.dto.LibroDto;
import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

public class GutendexApiReader {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books";

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void leerYGuardarDatos() {
        RestTemplate restTemplate = new RestTemplate();
        GutendexResponse response = restTemplate.getForObject(GUTENDEX_API_URL, GutendexResponse.class);

        if (response != null && response.getResults() != null) {
            for (LibroDto libroDto : response.getResults()) {
                Libro libro = new Libro();
                libro.setTitulo(libroDto.getTitulo());
                libro.setIdioma(libroDto.getIdiomas().get(0));  // Suponiendo que siempre hay al menos un idioma

                Set<Autor> autores = new HashSet<>();
                for (AutorDto authorDto : libroDto.getAutores()) {
                    Autor autor = autorRepository.findByNombre(authorDto.getNombre());
                    if (autor == null) {
                        autor = new Autor();
                        autor.setNombre(authorDto.getNombre());
                        autor = autorRepository.save(autor);
                    }
                    autores.add(autor);
                }
                libro.setAutores(autores);
                libroRepository.save(libro);
            }
        }
    }

}
