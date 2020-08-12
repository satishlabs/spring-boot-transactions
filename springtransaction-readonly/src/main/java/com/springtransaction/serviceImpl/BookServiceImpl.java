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
	

	//we will see @Transactional(readOnly = true/false) example using spring boot.
	@Transactional(readOnly = true)
	public void saveBook(Book book) throws Exception {
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		
	}
}