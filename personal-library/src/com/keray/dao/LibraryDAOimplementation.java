package com.keray.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keray.entity.Author;
import com.keray.entity.Book;

@Repository
public class LibraryDAOimplementation implements LibraryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveBook(Book book) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(book.getAuthor());
		currentSession.saveOrUpdate(book);
	}

	@Override
	public List<Book> getBooks() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Book> getBooksFromDbQuery = currentSession.createQuery("from Book order by status", Book.class);
		
		List<Book> bookList = getBooksFromDbQuery.getResultList();
		
		return bookList;
	}

	@Override
	public List<Author> getAuthors() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Author> getAuthorsFromDbQuery = currentSession.createQuery("from Author", Author.class);
		
		List<Author> authorsList = getAuthorsFromDbQuery.getResultList();
		
		return authorsList;
	}

	@Override
	public void deleteBook(int bookId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Book> deleteBookQuery = currentSession.createQuery("delete from Book where id=:theId");
		deleteBookQuery.setParameter("theId", bookId);
		deleteBookQuery.executeUpdate();
	}

	@Override
	public Book getBook(int bookId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Book.class, bookId);
	}

	@Override
	public void deleteAuthor(int authorId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Book> deleteAuthorQuery = currentSession.createQuery("delete from Author where id=:theId");
		deleteAuthorQuery.setParameter("theId", authorId);
		deleteAuthorQuery.executeUpdate();
		
	}


	@Override
	public List<Book> getAuthorsBooks(int authorId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Book> getAuthorsBooksQuery = currentSession.createQuery("from Book where author.id=:theId");
		getAuthorsBooksQuery.setParameter("theId", authorId);
		
		List<Book> authorsBooks = getAuthorsBooksQuery.getResultList();
		
		return authorsBooks;
	}

	@Override
	public Author getAuthor(int authorId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Author.class, authorId);
	}

}
