package com.alura.literatura.controller;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

import java.util.List;



@Controller
public class MainController {

    @Autowired
    private GutendexService gutendexService;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    List<Libro> librosPorTitulo = gutendexService.buscarLibrosPorTitulo(titulo);
                    librosPorTitulo.forEach(System.out::println);
                    break;
                case 2:
                    List<Libro> libros = gutendexService.listarLibrosRegistrados();
                    libros.forEach(System.out::println);
                    break;
                case 3:
                    List<Autor> autores = gutendexService.listarAutoresRegistrados();
                    autores.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de línea
                    List<Autor> autoresVivos = gutendexService.listarAutoresVivosEnAnio(anio);
                    autoresVivos.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String idioma = scanner.nextLine();
                    List<Libro> librosPorIdioma = gutendexService.listarLibrosPorIdioma(idioma);
                    librosPorIdioma.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
