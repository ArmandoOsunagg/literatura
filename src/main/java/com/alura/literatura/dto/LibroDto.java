package com.alura.literatura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.alura.literatura.dto.AutorDto;
import java.util.List;

public class LibroDto {
    @JsonProperty("title")
    private String titulo;

    @JsonProperty("languages")
    private List<String> idiomas;

    @JsonProperty("authors")
    private List<AutorDto> autores;

    // getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public List<AutorDto> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDto> autores) {
        this.autores = autores;
    }
}
