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
	 As the name suggests (noRollBackFor), if we don’t want our transaction to be get rollbacked for any 
	 specific RuntimeException, we can use @Transactional noRollBackFor attribute.

	Generally, if we are using @Transactional annotation with the method and 
	some RuntimeException(for eg – NullPointerException, ClassCastException) comes, 
	the transaction will get rollbacked(See @Transactional rollBackFor example for more details). 
	This is the default behavior, if we don’t use noRollBackFor attribute.
	 * */
	
	@Transactional(noRollbackFor = {NullPointerException.class})
	public void saveBook(Book book) throws Exception {
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		String s1 = null;
		System.out.println(s1.hashCode());
	}
}