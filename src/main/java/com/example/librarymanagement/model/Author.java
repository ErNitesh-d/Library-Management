package com.example.librarymanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;


    @Email(message = "Enter Valid Email")
    @Column(unique = true, nullable = false)
    private String email;


}
