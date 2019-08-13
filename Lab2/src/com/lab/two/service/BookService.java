package com.lab.two.service;

import java.util.List;

import com.lab.two.dao.BookDao;
import com.lab.two.dao.BookDaoI;
import com.lab.two.entities.Book;


public class BookService implements BookServiceI {

	private BookDaoI dao;

	public BookService() {
		dao = new BookDao();
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return dao.getBookByTitle(title);
	}

	@Override
	public Long getBookCount() {
		return dao.getBookCount();
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		return dao.getAuthorBooks(author);
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}
	
	@Override
	public List<Book> getBooksInPriceRange(double low, double high){
		return dao.getBooksInPriceRange(low, high);
	}
}

