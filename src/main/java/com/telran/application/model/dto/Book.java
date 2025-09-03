package com.telran.application.model.dto;

import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @JsonProperty("isbn")
    private Long isbn;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("author")
    private String author;
    
    @JsonProperty("publishDate")
    private LocalDate publishDate;
    
    @JsonProperty("price")
    private Double price;

    public Long getISBN() {
        return isbn;
    }

    public static Book getRandomBook() {
        Random random = new Random();
        String[] titles = {"Java Programming", "Spring Boot Guide", "Database Design", "Web Development", "Software Architecture"};
        String[] authors = {"John Smith", "Jane Doe", "Bob Johnson", "Alice Brown", "Charlie Wilson"};
        
        Book book = new Book();
        book.isbn = random.nextLong(9999999999999L) + 1000000000000L; // 13-digit ISBN
        book.title = titles[random.nextInt(titles.length)];
        book.author = authors[random.nextInt(authors.length)];
        book.publishDate = LocalDate.now().minusDays(random.nextInt(3650)); 
        book.price = random.nextDouble() * 50 + 10; 
        return book;
    }
}
