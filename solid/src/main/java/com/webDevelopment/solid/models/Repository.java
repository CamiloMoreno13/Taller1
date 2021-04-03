package com.webDevelopment.solid.models;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Book> books;

    public Repository() {
    }

    public void agregar(Book book){
        this.books.add(book);
    }
}
