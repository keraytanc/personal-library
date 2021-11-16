package com.keray.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keray.dao.LibraryDAO;
import com.keray.entity.Author;
import com.keray.entity.Book;

@Service
public class LibraryServiceImplementation implements LibraryService {
	
	@Autowired
	private LibraryDAO libraryDAO;

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		
		this.preventNewAuthorRecordIfAlreadyExists(theBook);
		libraryDAO.saveBook(theBook);
	}

	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return libraryDAO.getBooks();
	}

	@Override
	@Transactional
	public void deleteBook(int bookId) {		
		int authorId = this.getBook(bookId).getAuthor().getId();		
		libraryDAO.deleteBook(bookId);
		this.deleteAuthorIfNoBooksBinded(authorId);
	}

	@Override
	@Transactional
	public Book getBook(int bookId) {
		
		return libraryDAO.getBook(bookId);
	}
	
	@Override
	@Transactional
	public List<Book> getAuthorsBooks(int authorId) {
		return libraryDAO.getAuthorsBooks(authorId);
	}
	
	@Override
	@Transactional
	public Author getAuthor(int authorId) {
		return libraryDAO.getAuthor(authorId);
	}
	
	private void preventNewAuthorRecordIfAlreadyExists(Book theBook) {
		
		List<Author> existingAuthors = libraryDAO.getAuthors();
		
		for (Author authorToCompare: existingAuthors) {
			
			if (theBook.getAuthor().getName().trim().equalsIgnoreCase(authorToCompare.getName().trim())) {
				theBook.setAuthor(authorToCompare);
				return;
			}	
		}
		theBook.getAuthor().setName(theBook.getAuthor().getName().trim());
	}
	
	private void deleteAuthorIfNoBooksBinded(int authorId) {
		
		List<Book> books = libraryDAO.getBooks();
		
		for (Book thisBook: books) {
			if (thisBook.getAuthor().getId() == authorId) {
				return;
			}
		}
		libraryDAO.deleteAuthor(authorId);
	}
}
