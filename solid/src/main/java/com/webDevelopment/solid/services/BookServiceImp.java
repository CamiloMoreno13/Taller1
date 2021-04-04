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
    public List<String> listarAuthor(String autor) throws Exception{
        List<String> libros = new ArrayList<String>();
        if(this.repository.listar().isEmpty()) throw new Exception("BookServiceImp.listarAuthor Cause: No hay libros");
        for (Book valor: this.repository.listar()) {
            String val = valor.comprobar(autor);
            if(val != null){
                libros.add(val);
            }
        }
        return libros;
    }

    @Override
    public String detallar(String libro) {
        for (Book valor: this.repository.listar()) {
            String val = valor.detallar(libro);
            if(val != null) return val;
        }
        return null;
    }
}
