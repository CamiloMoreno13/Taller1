package com.webDevelopment.solid.controllers;

import      com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> agregarBook(@RequestBody Book book){
    HttpStatus codigo = HttpStatus.ACCEPTED;
        try {
            this.bookService.agregar(book);
        }catch (Exception e){
            LOGGER.error("BookController.agregarBook Causa: " + e.getMessage());
            codigo = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(codigo).body(book);
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap<String,String>>> getLibrosAuthor(@RequestBody String autor){
        List<HashMap<String,String>> books = null;
        HttpStatus codigo = HttpStatus.ACCEPTED;
        try {
            books = this.bookService.listarAuthor(autor);
        } catch (Exception e){
            LOGGER.error("BookController.getLibrosAuthor Causa: " + e.getMessage());
            codigo = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping(value = "/detallar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> detallarlibro(@RequestBody String libro){
        String detalle = null;
        HttpStatus codigo = HttpStatus.OK;
        try{
            detalle = this.bookService.detallar(libro);
        } catch (Exception e){
            LOGGER.error("BookController.getLibrosAuthor Causa: " + e.getMessage());
            codigo = HttpStatus.BAD_REQUEST;
            detalle = "No existe el libro que quiere detallar o excede las 1500 paginas";
        }
        return ResponseEntity.status(codigo).body(detalle);
    }
}
