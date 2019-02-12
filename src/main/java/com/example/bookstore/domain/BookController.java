package com.example.bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	//inject repo to controller
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private CategoryRepository catrepo;
	
	
	@RequestMapping(value="books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repo.findAll();
		
	}
	
	@RequestMapping(value="books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
		
		return repo.findById(id);
	}
	
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		
	
		model.addAttribute("books", repo.findAll());
		
		return "booklist";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String EditBook(@PathVariable("id") Long bookId, Model model) {
    	
	
		
		model.addAttribute("categories", catrepo.findAll());
		model.addAttribute("book",repo.findById(bookId));
    	
        return "editbook";
    }     
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
    	repo.deleteById(bookId);
    	
        return "redirect:../booklist";
    }     
	
	
	@RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", catrepo.findAll());
        return "addbook";
    }     
    
	
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repo.save(book);
        return "redirect:booklist";
    }    
}
