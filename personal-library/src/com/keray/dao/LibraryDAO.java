package com.keray.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.keray.entity.Author;
import com.keray.entity.Book;

public interface LibraryDAO {
	
	public void saveBook(Book book);

	public List<Book> getBooks();
	
	public List<Author> getAuthors();

	public void deleteBook(int bookId);

	public Book getBook(int bookId);

	public void deleteAuthor(int authorId);

	public List<Book> getAuthorsBooks(int authorId);

	public Author getAuthor(int authorId);
	

}
