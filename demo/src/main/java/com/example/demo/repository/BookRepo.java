package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.document.Book;
 
public interface BookRepo
    extends MongoRepository<Book, Integer> {

}