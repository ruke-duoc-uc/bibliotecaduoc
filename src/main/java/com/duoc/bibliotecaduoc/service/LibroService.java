package com.duoc.bibliotecaduoc.service;

import com.duoc.bibliotecaduoc.model.Libro;
import com.duoc.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService{
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "producto eliminado";
    }
    public int totalLibrosV1(){
        return libroRepository.obtenerLibros().size();
    }
    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }
    public Libro buscarPorIsbn(String isbn) {
        return libroRepository.buscarPorIsbn(isbn);
    }
    public Libro buscarPorFecha(int fecha){return libroRepository.buscarPorFecha(fecha);}
    public Libro buscarPorAutor(String autor){return libroRepository.buscarPorAutor(autor);}
    public ArrayList<Libro> buscarAntesFecha(int antes){return libroRepository.buscarAntesFecha(antes);}
    public ArrayList<Libro> buscarDespuesFecha(int despues){return libroRepository.buscarDespuesFecha(despues);}

}