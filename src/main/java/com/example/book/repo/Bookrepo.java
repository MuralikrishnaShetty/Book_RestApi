package com.example.book.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.book.entity.Book;

public interface Bookrepo extends  CrudRepository<Book,Integer>{

}
