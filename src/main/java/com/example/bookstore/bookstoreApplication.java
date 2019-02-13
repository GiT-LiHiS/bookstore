package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class bookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(bookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catrepo) {
	return (args) -> {
		catrepo.save(new Category("IT"));
		catrepo.save(new Category("Business"));
		catrepo.save(new Category("Fantasy"));
		
	
	
	
	};
	}
}

