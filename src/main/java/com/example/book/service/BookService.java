package com.example.book.service;

import java.util.List;

import com.example.book.entity.Book;
import com.example.book.exception.CanNotDelete;
import com.example.book.exception.NotFound;

public interface BookService {
	public String getdescription(Integer bookNumber);

	public Book getBook(Integer book) throws NotFound;

	public Book addBook(Book book);

	public Book updateBook(Integer bookNumber, Book book);

	public void deleteBook(Integer bookNumber) throws CanNotDelete;

	public List<Book> allBooks();

}
