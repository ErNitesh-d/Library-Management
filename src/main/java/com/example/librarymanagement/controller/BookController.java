package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Books;
import com.example.librarymanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    /**
     * Implemented CRUD APIs:
     * a. Add Author
     * b. Add Book under an Author
     * c. Get all books of an Author
     * d. Update/Delete Book
     */
    private final BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("addBook")
    public Books addBook(@Valid @RequestBody Books book) {
        return bookService.addBook(book);

    }
    @GetMapping("/getBookWithAuthor")
    public List<Books> getBookWithAuthor() {
        return bookService.booksWithAuthor();
    }

    @PutMapping("/updateBook/{id}")
    public String updateBook(@PathVariable int id,@Valid @RequestBody Books book) {
          bookService.updateBook(id,book.getTitle(),book.getPrice(), book.getAuthorId().getAuthorId());
        return "Book Updated successfully with ID of "+id;
    }

    @DeleteMapping("/deleteBookById/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBookById(id);
        return "Book Deleted successfully with ID of "+id;
    }

    /**
     * Added Pagination when fetching all books.
     */

    /*http://localhost:8080/book/getBooksWithPages?size=2&page=0/1/2... */

    @GetMapping("/getBooksWithPages")
    public List<Books> getBooksWithPages(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size
                                      ){
        Pageable pageable = PageRequest.of(page, size);
        return bookService.getBooksWithPages(pageable).getContent();
    }






}
