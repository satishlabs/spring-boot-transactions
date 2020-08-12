package com.springtransaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springtransaction.entity.Book;
import com.springtransaction.entity.Story;
import com.springtransaction.repository.BookRepository;
import com.springtransaction.service.BookService;
import com.springtransaction.service.StoryService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private StoryService storyService;
	
	public Book findByBookId(int bookId) {
		Book book = bookRepository.findByBookId(bookId);
		return book;
	}
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void saveBook(Book book) throws Exception {
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		

		Story story = new Story();
		story.setStoryName("story name3");
		// save story
		storyService.saveStory(story);
		
		throw new RuntimeException("this exception in throwing intentionally");
	}
}

/*
 We have the book as well as story record in the database. 
 Yes, we don’t have any problem in code, no exception occurs, so 
 the record is inserted in database and transaction completed. 
 What will happen if we have some problem in saveBook() and saveStory() logic is fine? Let’s see
 
 add code 
 throw new RuntimeException("this exception in throwing intentionally");
 
 We have an exception in response which is expected behavior. 
 In this case book entity will not save in the database but the story will save in the database.
 * */
