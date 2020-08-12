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
	
	/*
	 We have specified rollbackForClassName = {“NullpointerException”}), 
	 means transaction should get to rollbacked for NullpointerException. 
	 We should not have any record in the database.
	 * */
	
	@Transactional(rollbackForClassName = {"NullpointerException"})
	public void saveBook(Book book) throws Exception {
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		 
		String s1 = null;
		System.out.println(s1.hashCode());
	}
}