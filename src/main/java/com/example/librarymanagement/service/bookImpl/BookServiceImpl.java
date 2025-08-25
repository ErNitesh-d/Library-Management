package com.example.librarymanagement.service.bookImpl;

import com.example.librarymanagement.exception.BookNotFoundException;
import com.example.librarymanagement.model.Books;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books addBook(@RequestBody Books book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Books> booksWithAuthor() {

        return bookRepository.booksWithAuthor();
    }

    @Override
    public void updateBook(int id, String title, int price, int author_id) {

        if(bookRepository.existsById((long) id)){
            bookRepository.updateBookById(id,title,price,author_id);
        }else {
            throw new BookNotFoundException("Book not found with id "+id+" ");
        }
    }

    @Override
    public void deleteBookById(Long id) {
        if( bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }
        else {
            throw new BookNotFoundException("Book already deleted with id "+id+" ");
        }
    }

    @Override
    public Page<Books> getBooksWithPages(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


}
