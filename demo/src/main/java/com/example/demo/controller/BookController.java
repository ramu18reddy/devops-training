package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Book;
import com.example.demo.repository.BookRepo;

// Annotation
@RestController

// Class
public class BookController {

	@Autowired
	private BookRepo repo;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book){
		System.out.println("ssss");
		repo.save(book);
	
		return "Added Successfully";
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
	
		return repo.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Book getBook(@PathVariable int id) {
	
		return repo.findById(id).get();
	}
	
    @PutMapping("/{id}")
    public String update(@RequestBody Book book, @PathVariable int id) {
    	
    	Book dbbook = getBook(id);
    	
    	
    	dbbook.setAuthorName(book.getAuthorName());
    	dbbook.setBookName(book.getBookName());
    	
    	
    	 repo.save(dbbook);
    	 return "updated book succesfully....";
    }
    
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id){
		repo.deleteById(id);
	
		return "Deleted Successfully";
	}

}
