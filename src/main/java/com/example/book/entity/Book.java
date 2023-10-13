package com.example.book.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer bookNumber;
	public String bookName;
	public String bookDescription;
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", bookDescription=" + bookDescription
				+ "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer bookNumber, String bookName, String bookDescription) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
	}
	
	
	

}
