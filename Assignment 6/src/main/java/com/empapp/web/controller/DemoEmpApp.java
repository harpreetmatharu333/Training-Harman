package com.empapp.web.controller;
import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

public class DemoEmpApp {

	public static void main(String[] args) {
		

		Book book =new Book("Harpreet", 3232323, 21);
//		employeeService.addEmployee(employee);
		
		BookService.addBook(book);
	}
}
