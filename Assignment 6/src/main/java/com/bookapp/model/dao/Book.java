package com.bookapp.model.dao;
//DTO: data transfer object
public class Book {
	private int id ;
	private String name;
	private double price;
	private int age;


	public Book(String name, double price, int age) {
		this.name = name;
		this.price = price;
		this.age = age;
	}

	
	
	public Book(int id, String name, double price, int age) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.age = age;
	}

	public Book() {}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setSalary(double salary) {
		this.price = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", salary=" + price + ", age=" + age + "]";
	}
	
	
}
