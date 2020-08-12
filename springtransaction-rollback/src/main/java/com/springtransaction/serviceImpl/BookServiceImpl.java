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
	
	//@Transactional(rollbackFor = {RuntimeException.class})
	/*
	 even we are using above @Transactional annotation with rollbackFor = RuntimeException.class, we will have one book record in DB. 
	 Why? Because we are throwing checked exception in BookServiceImpl.java 
	 but we are saying to spring hey spring rollback the transaction for 
	 only RuntimeException/unchecked exception not for the checked exception.
	 * */
	
	//We are telling to spring just rollback the transaction for any exception.
	@Transactional(rollbackFor = {Exception.class})
	public void saveBook(Book book) throws Exception {
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		
		throw new Exception("this is checked exception throwing intentinally");
	}
}