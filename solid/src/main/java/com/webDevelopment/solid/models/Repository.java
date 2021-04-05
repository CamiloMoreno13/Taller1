package com.webDevelopment.solid.models;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Book> libros;

    public Repository() {
        this.libros = new ArrayList<Book>();
        Book book = new Book("El alquimista","Paulo Coelho",2010,45000d,500,"Morbi pulvinar metus vel pharetra imperdiet. Cras sed purus maximus, elementum nunc at, imperdiet sem. Proin blandit sed mi at malesuada. Quisque nec tempor augue. Mauris scelerisque lacus ac diam.");
        this.libros.add(book);
        book = new Book("Veronica decide morir","Paulo Coelho",2010,35000d,900,"Morbi pulvinar metus vel pharetra imperdiet. Cras sed purus maximus, elementum nunc at, imperdiet sem. Proin blandit sed mi at malesuada. Quisque nec tempor augue. Mauris scelerisque lacus ac diam.");
        this.libros.add(book);
        book = new Book("Brida","Paulo Coelho",2021,10000d,2500,"Morbi pulvinar metus vel pharetra imperdiet. Cras sed purus maximus, elementum nunc at, imperdiet sem. Proin blandit sed mi at malesuada. Quisque nec tempor augue. Mauris scelerisque lacus ac diam.");
        this.libros.add(book);
        book = new Book("Harry Potter y la piedra filosofal","J. K. Rowling",1997,50000d,2500,"ut rutrum felis ipsum sit amet arcu. Nulla eget consectetur diam. Praesent at congue diam. Cras cursus neque gravida.");
        this.libros.add(book);
        book = new Book("Animales fantásticos y dónde encontrarlos","J. K. Rowling",1960,11000d,1500,"Morbi pulvinar metus vel pharetra imperdiet. Cras sed purus maximus, elementum nunc at, imperdiet sem. Proin blandit sed mi at malesuada. Quisque nec tempor augue. Mauris scelerisque lacus ac diam.");
        this.libros.add(book);
        book = new Book("Los cuentos de Beedle el Bardo","J. K. Rowling",1999,10999d,3500,"Morbi pulvinar metus vel pharetra imperdiet. Cras sed purus maximus, elementum nunc at, imperdiet sem. Proin blandit sed mi at malesuada. Quisque nec tempor augue. Mauris scelerisque lacus ac diam.");
        this.libros.add(book);
        book = new Book("Harry Potter y el prisionero de Azkaban","J. K. Rowling",2003,105000d,450,"Morbi pulvinar metus vel pharetra imperdiet. Cras sed purus maximus, elementum nunc at, imperdiet sem. Proin blandit sed mi at malesuada. Quisque nec tempor augue. Mauris scelerisque lacus ac diam.");
        this.libros.add(book);
    }

    public void agregar(Book book){
        this.libros.add(book);
    }

    public ArrayList<Book> listar(){
        return this.libros;
    }
}
