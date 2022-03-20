package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dao.BookDaoImpl;
//service layer is just like brain of our application
//Cross cutting concern* tx , security, caching
public class BookServiceImpl implements BookService{

	private BookDao BookDao;
	
	
	public BookServiceImpl() {
		BookDao=new BookDaoImpl();
	}

	@Override
	public List<Book> getAll() {
		return BookDao.getAll();
	}

	public void addBook(Book book) {
		BookDao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		BookDao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		BookDao.updateBook(id, book);
	}

	@Override
	public Book findById(int id) {
		return BookDao.findById(id);
	}

}
