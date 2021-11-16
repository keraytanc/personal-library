package com.keray.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keray.entity.Author;
import com.keray.entity.Book;
import com.keray.service.LibraryService;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		
		List<Book> allBooks = libraryService.getBooks();
		
		theModel.addAttribute("books", allBooks);
		
		return "list-books";
	}
	
	@RequestMapping("/details")
	public String addBook(Model theModel) {
		
		Book newBook = new Book();
		
		Author newAuthor = new Author();
		newBook.add(newAuthor);
		
		theModel.addAttribute("book", newBook);
		
		return "book-details";
	}
	
	@RequestMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {
		
		libraryService.saveBook(book);
		return "redirect:/library/list";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int bookId, Model theModel) {
		
		libraryService.deleteBook(bookId);
		return "redirect:/library/list";
	}
	
	@RequestMapping("/showDetails")
	public String showDetails(@RequestParam("bookId") int bookId, Model theModel) {
		
		Book theBook = libraryService.getBook(bookId);

		theModel.addAttribute("book", theBook);
		
		return "book-details";
	}
	
	@RequestMapping("/author")
	public String showAuthor(@RequestParam("authorId") int authorId, Model theModel) {
		
		List<Book> authorsBooks = libraryService.getAuthorsBooks(authorId);
		
		Author theAuthor = libraryService.getAuthor(authorId);
		
		theModel.addAttribute("theAuthor", theAuthor);
		theModel.addAttribute("authorsBooks", authorsBooks);
		
		return "author-details";
	}
	
	

}
