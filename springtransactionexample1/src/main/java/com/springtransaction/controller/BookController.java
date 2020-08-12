package com.springtransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springtransaction.entity.Book;
import com.springtransaction.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping(value = "/getBook/{bookId}")
	public Book getBookDetails(@PathVariable int bookId) {
		Book bookResponse = bookService.findByBookId(bookId);		
		return bookResponse;
	}

	@PostMapping(value = "/savebook")
	public Book saveBook(@RequestBody Book book) {
		Book bookResponse = bookService.saveBook(book);		
		return bookResponse;
	}		
}

