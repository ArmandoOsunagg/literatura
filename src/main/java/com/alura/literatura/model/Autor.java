package com.alura.literatura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros;

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(LocalDate fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

}