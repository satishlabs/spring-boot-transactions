package com.springtransaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtransaction.entity.Book;
import com.springtransaction.repository.BookRepository;
import com.springtransaction.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	public Book findByBookId(int bookId) {
		Book book = bookRepository.findByBookId(bookId);
		return book;
	}
	@Transactional
	public Book saveBook(Book book) {
		Book book1 = bookRepository.save(book);
		
		int a = 10/0;
		System.out.println(a);
		
		return book1;
	}
}