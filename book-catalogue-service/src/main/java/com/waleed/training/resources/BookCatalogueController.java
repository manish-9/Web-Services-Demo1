package com.waleed.training.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waleed.training.model.BookCatalogueItem;
import com.waleed.training.service.BookService;

@RestController
public class BookCatalogueController {
	
	@Autowired
	BookService service;

	@RequestMapping("/catalog/{id}")
	List<BookCatalogueItem> getBookCatalogById(@PathVariable Integer id){
		
		return service.getBookCatalogById(id);
	
	}
	
	@PostMapping("/catalog/new-book")
	String addNewBookItem(@RequestBody BookCatalogueItem item) {
		return service.addNewBookItem(item);
	}
	
}
