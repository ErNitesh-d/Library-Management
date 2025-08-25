package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {

    Books addBook(@RequestBody Books book);

    List<Books> booksWithAuthor();

    void updateBook(int id,String title,int price,int author_id);

    void deleteBookById(Long id);

    Page<Books> getBooksWithPages(Pageable pageable);
}
