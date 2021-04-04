package com.webDevelopment.solid.models;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Book> libros;

    public Repository() {
        this.libros = new ArrayList<Book>();
        Book book = new Book("libro1","camilo",2000,200d,500,"perras");
        this.libros.add(book);
        book = new Book("libro2","camilo",2010,250d,200,"hola a todos");
        this.libros.add(book);
        book = new Book("libro3","aldemar",2020,700d,1000,"que paso hermanito");
        this.libros.add(book);
    }

    public void agregar(Book book){
        this.libros.add(book);
    }

    public ArrayList<Book> listar(){
        return this.libros;
    }
}
