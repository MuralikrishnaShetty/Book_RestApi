package com.example.book.service;

import java.util.List;
import java.util.Optional;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.entity.Book;
import com.example.book.exception.CanNotDelete;
import com.example.book.exception.NotFound;
import com.example.book.repo.Bookrepo;
//import com.infosys.entities.Course;
//import com.infosys.exceptions.CourseCannotBeDeletedException;
//import com.infosys.entities.Course;
//import com.infosys.exceptions.CourseNotFoundException;
import com.example.book.entity.*;

@Service
public class Bookserviceimpli implements BookService{
	
	@Autowired
	Bookrepo repos;

	@Override
	public String getdescription(Integer bookNumber) {
		// TODO Auto-generated method stub
		Optional<Book> op= repos.findById(bookNumber);
		Book des=op.get();
		String description=des.getBookDescription();
		return description;
	}

	@Override
	public Book getBook(Integer bookNumber) throws NotFound {
		Optional<Book> op=repos.findById(bookNumber);
		Book b =op.orElseThrow(()->new NotFound());
		return b;
	}

	@Override
	public Book addBook(Book book) {
		
		
		return repos.save(book);
	}

	@Override
	public Book updateBook(Integer bookNumber, Book book) {
		Book c=null;

		Optional<Book> opCourse=  repos.findById(bookNumber);

		if(opCourse.isPresent()) {
			c=	repos.save(book);
		}
		return c;
	}

	@Override
	public void deleteBook(Integer bookNumber) throws CanNotDelete  {
		// TODO Auto-generated method stub
		Optional<Book> c=null;
		c=repos.findById(bookNumber);
		Book book=c.orElseThrow(()->new CanNotDelete());
		repos.delete(book);
		
	}

	@Override
	public List<Book> allBooks() {
		List<Book> courseList=(List<Book>)repos.findAll();
		return courseList;
	}

}
