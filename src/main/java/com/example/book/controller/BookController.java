package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.entity.Book;
import com.example.book.exception.CanNotDelete;
import com.example.book.exception.NotFound;
import com.example.book.service.BookService;
//import com.infosys.entities.Course;
//import com.infosys.exceptions.CourseCannotBeDeletedException;
//import com.infosys.exceptions.CourseNotFoundException;

@RestController
@RequestMapping("/book.example.com")
public class BookController {

    @Autowired
    BookService bb;

    @PostMapping(value="/Book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bb.addBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> allBooks() {
        List<Book> bookList = bb.allBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/Book/{bookNumber}")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookNumber) throws NotFound {
        Book book = bb.getBook(bookNumber);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            throw new NotFound();
        }
    }

    @PutMapping("/Book/{bookNumber}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookNumber, @RequestBody Book book) {
        Book updatedBook = bb.updateBook(bookNumber, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/book/{bookNumber}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookNumber) {
        try {
            bb.deleteBook(bookNumber);
            return new ResponseEntity<>("The book is deleted successfully", HttpStatus.OK);
        } catch (CanNotDelete e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
