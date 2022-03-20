package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.dao.Book;

public interface BookService {
	public List<Book> getAll();
	public static void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	public void deleteBook(int id);
	public void updateBook(int id, Book book);
	public Book findById(int id);
}
