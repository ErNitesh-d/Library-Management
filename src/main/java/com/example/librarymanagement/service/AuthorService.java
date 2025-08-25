package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Author;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthorService {

    Author addAuthor(@RequestBody Author author);

    Author getAuthorById(@RequestParam("id") int id);

}
