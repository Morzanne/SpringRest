package com.wildcodeschool.book.controllers;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import com.wildcodeschool.book.models.book;
import com.wildcodeschool.book.repositories.BookRepository;


@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;


    //READ
    @GetMapping("/books")
    public List<book> index(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public book show(@PathVariable int id){
        return bookRepository.findById(id).get();
    }

    //CREATE
    @PostMapping("/books/search")
    public List<book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrAuthorContaining(searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public book create(@RequestBody book livre){
        return bookRepository.save(livre);
    }

    //UPDATE
    @PutMapping("/books/{id}")
    public book update(@PathVariable int id, @RequestBody book livre){
        // getting book
        book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(livre.getTitle());
        bookToUpdate.setAuthor(livre.getAuthor());
        bookToUpdate.setDescription(livre.getDescription());
        return bookRepository.save(bookToUpdate);
    }

    //DELETE
    @DeleteMapping("/books/{id}")
    public boolean delete(@PathVariable int id){
        bookRepository.deleteById(id);
        return true;
    }
}
