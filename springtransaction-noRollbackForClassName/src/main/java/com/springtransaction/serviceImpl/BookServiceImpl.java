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
	 Even we have NullPointerException in our code, we have one record in the database. 
	 If you remove noRollbackForClassName = {“NullpointerException”}) from @Transactional annotation, 
	 it will not save any record, our transaction will get rollbacked.
	 * */
	
	@Transactional(noRollbackForClassName = {"NullpointerException"})
	public void saveBook(Book book) throws Exception {
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		 
		String s1 = null;
		System.out.println(s1.hashCode());
	}
}