package com.alura.literatura.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AutorDto {
    @JsonProperty("name")
    private String nombre;

    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
