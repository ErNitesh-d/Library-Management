package com.example.librarymanagement.service.bookImpl;

import com.example.librarymanagement.exception.AuthorNotFoundException;
import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(int id) {
        if (authorRepository.existsById((long) id)){
            return authorRepository.getAuthorByAuthorId(id);
        }
        else{
            throw new AuthorNotFoundException("author not found with id :"+id);
        }

    }
}
