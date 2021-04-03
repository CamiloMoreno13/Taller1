package com.webDevelopment.solid.models;

public class Book {
    private String title;
    private String author;
    private Integer publishedYear;
    private Double price;
    private Integer paginas;

    public Book(String title, String author, Integer publishedYear, Double price, Integer paginas) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.paginas = paginas;
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
}