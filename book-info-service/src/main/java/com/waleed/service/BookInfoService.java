package com.waleed.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.waleed.dto.Book;

@Service
public class BookInfoService {

	@Autowired
	RestTemplate template;

	public Book getBookById(Integer id) {
		return new Book(56, "Java - Complete Reference");
	}

	public List<Object> getEntireBookCatalogue(Integer userId) {
//		return template.getForObject("http://localhost:8081/catalog/789", String.class);

//		OR

		Object[] dataFromAnotherService = template.getForObject("http://localhost:8081/catalog/789", Object[].class);

		return Arrays.asList(dataFromAnotherService);
	}

	public String addNewBookCatalogue() {
		
		 String requestJson = "{\"name\":\"The Hound Of Baskerville\", \"description\":\"Mystery and thriller of the blood hound\", \"rating\":4.5}";
		 HttpHeaders header = new HttpHeaders();
		 header.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity = new HttpEntity<>(requestJson,header);
		 
		 return template.postForObject("http://localhost:8081/catalog/new-book", entity, String.class);
	}

}
