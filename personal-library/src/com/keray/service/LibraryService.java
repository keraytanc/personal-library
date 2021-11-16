package com.keray.service;

import java.util.List;

import com.keray.entity.Author;
import com.keray.entity.Book;

public interface LibraryService {
	
	public void saveBook(Book theBook);

	public List<Book> getBooks();

	public void deleteBook(int bookId);

	public Book getBook(int bookId);

	public List<Book> getAuthorsBooks(int authorId);

	public Author getAuthor(int authorId);

}
