package com.waleed.training.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.waleed.training.model.BookCatalogueItem;

@Service
public class BookService {
	
	ArrayList<BookCatalogueItem> bookCatalogue = new ArrayList<>(
			Arrays.asList(
					new BookCatalogueItem("Alchemist", "A Book about life", 4),
					new BookCatalogueItem("Who moved my Cheese", "Embracing Change", 5),
					new BookCatalogueItem(".Net Refresher", "A Book about .Net technology", 3)
					)
			);
	
	public List<BookCatalogueItem> getBookCatalogById(Integer id) {
		
		return bookCatalogue;
	}	
	
	public String addNewBookItem(BookCatalogueItem item) {
		bookCatalogue.add(item);
		return "New Book item Added to Catalogue!";
	}
	
}
