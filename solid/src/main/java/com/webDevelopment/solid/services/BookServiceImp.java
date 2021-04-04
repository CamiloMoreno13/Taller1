package com.webDevelopment.solid.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService{

    private List<Book> libros;

    public BookServiceImp() {
        this.libros = new ArrayList<Book>();
        Book book = new Book("libro1","camilo",2000,200d,500);
        this.libros.add(book);
        book = new Book("libro2","camilo",2010,250d,200);
        this.libros.add(book);
        book = new Book("libro3","aldemar",2020,700d,1000);
        this.libros.add(book);

    }

    @Override
    @JsonCreator
    public Book agregar(Book book) {
        Book nuevo = new Book(book.getTitle(), book.getAuthor(), book.getPublishedYear(), book.getPrice(), book.getPaginas());
        this.libros.add(nuevo);
        return nuevo;
    }

    @Override
    public List<Book> listarAuthor() {
        return this.libros;
    }

    @Override
    public String detallar(Book book) {
        return null;
    }
}
