package com.example.librarymanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @NotBlank(message = "Enter book title")
    private String title;

    @Min(value = 1,message = "price must be greater than 0")
    private int price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;


}
