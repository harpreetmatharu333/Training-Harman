package com.bookapp.model.dao;

import java.sql.*;
import java.util.*;

import com.bookapp.factory.ConnectionFactory;
import com.bookapp.model.exception.BookNotFoundException;

public class BookDaoImpl implements BookDao {

	private Connection connection;

	public BookDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Book> getAll() {
		Book tempEmp = null;
		List<Book> employees = new ArrayList<Book>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp3");

			while (rs.next()) {
				tempEmp = new Book(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getInt("age"));
				employees.add(tempEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void addBook(Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("insert into emp3(name, salary, age) values(?,?,?)");
			stmt.setString(1, book.getName());
			stmt.setDouble(2, book.getPrice());
			stmt.setInt(3, book.getAge());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int id) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("delete from emp3 where id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(int id, Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("update emp3 set salary = ? where id=?");
			stmt.setDouble(1, book.getPrice());
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book findById(int id) {
		Book tempBook = null;
		try {
			PreparedStatement stmt = 
					connection.prepareStatement("select * from emp3 where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				tempBook = 
						new Book(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tempBook==null)
			throw new BookNotFoundException("book with id "+ id +" is not found");
		return tempBook;
	}

}
