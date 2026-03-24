package com.duoc.bibliotecaduoc.controller;

import com.duoc.bibliotecaduoc.model.Libro;
import com.duoc.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        // el id lo usaremos mas adelante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }
    @GetMapping("/total")
    public int totalLibrosV2() {
        return libroService.totalLibrosV2();
    }
    @GetMapping("/isbn/{isbn}")
    public Libro buscarPorIsbn(@PathVariable String isbn){
        return libroService.buscarPorIsbn(isbn);
    }
    @GetMapping("/fecha/{fecha}")
    public Libro buscarPorFecha(@PathVariable int fecha){
        return libroService.buscarPorFecha(fecha);
    }
    @GetMapping("/autor/{autor}")
    public Libro buscarPorAutor(@PathVariable String autor){return libroService.buscarPorAutor(autor);}
    @GetMapping("/antes/{antes}")
    public ArrayList<Libro> buscarAntesFecha(@PathVariable int antes){return libroService.buscarAntesFecha(antes);}
    @GetMapping("/despues/{despues}")
    public ArrayList<Libro> buscarDespuesFecha(@PathVariable int despues){return libroService.buscarDespuesFecha(despues);}
}