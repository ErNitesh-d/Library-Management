package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.service.bookImpl.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController{

    private AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }
    @PostMapping("/addAuthor")
    public Author addAuthor(@Valid @RequestBody Author author) {
        return authorService.addAuthor(author);
    }


    @GetMapping("/getAuthorById/{id}")
    public Author getAuthor(@RequestParam("id") int id) {
        return authorService.getAuthorById(id);
    }

}
