package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Long> {


    @Query(value = "select  b.book_id,b.price,a.author_id,b.title, a.author_name from Books as b " +
            "join author as a on b.author_id=a.author_id;",nativeQuery = true)
    List<Books> booksWithAuthor();

    @Transactional
    @Modifying
    @Query(value = "Update Books set title=:title,price=:price, author_id=:author_id " +
            "Where book_id=:id",nativeQuery = true)

    void updateBookById(@Param("id") int id,
                        @Param("title") String name,
                        @Param("price") int price, int author_id);


    Page<Books> findAll(Pageable pageable);
}
