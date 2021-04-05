package com.webDevelopment.solid.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class Book implements Serializable {
    private String title;
    private String author;
    private Integer publishedYear;
    private Double price;
    private Integer paginas;
    private String descripcion;

    @JsonCreator
    public Book(String title, String author, Integer publishedYear, Double price, Integer paginas, String descripcion) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.paginas = paginas;
        this.descripcion = descripcion;
    }

    public boolean validate(Book book) throws Exception {
        if(this.title.isEmpty()){
            throw new Exception("Titulo Invalido - No existe");
        }

        if(this.descripcion.length() > 200){
            throw new Exception("La descripción no puede tener mas de 200 caracteres");
        }

        if(this.price < 10000){
            throw new Exception("El precio debe ser mayor a 10000");
        }

        String str = String.valueOf(this.price);
        int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));
        if(decNumberInt > 0){
            throw new Exception("El precio contiene centavos");
        }

        if(!this.author.contains(" ")){
            throw new Exception("El autor no contiene apellido");
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        if(this.publishedYear > year){
            throw new Exception("El año de publicación es mayor al año actual");
        }

        String publishYear = Integer.toString(this.publishedYear);
        if(publishYear.length() < 4){
            throw new Exception("El año de publicación tiene menos de 4 digitos");
        }
        return true;
    }

    public HashMap<String,String> busquedaLibroXAutor(String autor){
        if(this.author.equals(autor)){
            HashMap<String,String> valor = new HashMap<String,String>();
            valor.put("title",this.title);
            valor.put("author",this.author);
            return valor;
        }
        return null;
    }

    public String detallar(String libro){
        if(this.title.equals(libro) && this.paginas <= 1500) return "Descripcion: "+ this.descripcion + " Este libro tiene un precio de:  "+ this.price + ", fue publicado en: "+this.publishedYear + " y cuenta con "+this.paginas + " paginas.";
        return null;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getPublishedYear() {
        return publishedYear;
    }
    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getPaginas() {
        return paginas;
    }
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
