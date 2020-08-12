package com.springtransaction.service;

import org.springframework.stereotype.Component;

import com.springtransaction.entity.Book;

@Component
public interface BookService {
	public Book findByBookId(int bookId);
	public Book saveBook(Book book);
	
	
}
