package com.webDevelopment.solid.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.models.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImp implements BookService{

    private Repository repository;

    public BookServiceImp() {
        this.repository = new Repository();
    }

    @Override
    public Book agregar(Book book) throws Exception{
        if(!book.validate(book)){
            throw new Exception("BookServiceImp.agregar Cause: ");
        }
        this.repository.agregar(book);
        return book;
    }

    @Override
    public List<HashMap<String,String>> listarAuthor(String autor) throws Exception{
        HashMap<String,String> libros = new HashMap<String,String>();
        List<HashMap<String,String>> respuesta = new ArrayList<HashMap<String,String>>();
        if(this.repository.listar().isEmpty()) throw new Exception("BookServiceImp.listarAuthor Cause: No hay libros");
        for (Book valor: this.repository.listar()) {
            libros = valor.busquedaLibroXAutor(autor);
            if(libros != null){
                respuesta.add(libros);
            }
        }
        if(respuesta.isEmpty()){
            throw new Exception("BookServiceImp.listarAuthor Cause: No hay ningun autor con ese nombre");
        }
        return respuesta;
    }

    @Override
    public String detallar(String libro) throws Exception{
        for (Book valor: this.repository.listar()) {
            String val = valor.detallar(libro);
            if(val != null) return val;
        }
        throw new Exception("BookServiceImp.detallar Cause: No existe el libro que quiere detallar");
    }
}
