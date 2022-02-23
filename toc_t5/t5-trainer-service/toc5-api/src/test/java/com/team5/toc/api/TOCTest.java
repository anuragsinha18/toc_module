package com.team5.toc.api;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team5.toc.api.beans.TOC;
import com.team5.toc.api.controller.TOCController;
import com.team5.toc.api.exception.TOCNotFoundException;
import com.team5.toc.api.repo.TOCRepository;
import com.team5.toc.api.service.TOCService;

/**
 * 
 * Test cases for toc service
 * 
 * @author Anurag
 * 
 *
 */
@SpringBootTest
public class TOCTest {

	@Autowired
	private TOCService service;

	@Autowired
	private TOCController controller;

	@MockBean
	private TOCRepository repo;

	@BeforeEach
	public void setUp() {
		Optional<TOC> toc = Optional
				.of(new TOC(101, "python", 14, "expert in python", "basic knowledge of python", "begineer", 100));
		List<TOC> list = Arrays
				.asList(new TOC(101, "python", 14, "expert in python", "basic knowledge of python", "begineer", 100));
		Optional<TOC> emptyToc = Optional.empty();
		// mocked object
		when(repo.findById(101)).thenReturn(toc);
		when(repo.findById(102)).thenReturn(emptyToc);
		when(repo.findAll()).thenReturn(list);
		when(repo.insert(toc.get())).thenReturn(toc.get());

	}

	@Test
	@DisplayName("When toc id is given return valid object")
	public void whenTocIdIsGivenThenReturnObjectIfExists() throws TOCNotFoundException {

		// checking the service method
		assertEquals(101, service.getTocById(101).get().getId());

		// checking the controller method
		assertEquals(101, controller.getTocById(101).getId());

	}

	@Test
	@DisplayName("when toc id is given return valid toc object")
	public void whenTocIdIsGivenThenReturnTocObjectIfExist() {
		if (repo.findById(101).isPresent()) {
			assertEquals(101, service.getTocByIdAsObject(101).getId());
		}
	}

	@Test
	@DisplayName("when toc id is given return null if not found")
	public void whenTocIdIsGivenThenReturnNullIfNotExist() throws TOCNotFoundException {
		// checking the service method
		if (repo.findById(102).isEmpty()) {
			assertNull(service.getTocByIdAsObject(102));
		}

		// checking the controller method
		assertThrows(TOCNotFoundException.class, () -> controller.getTocById(102));

	}

	@Test
	@DisplayName("get all the tocs and list should give you an array of 1 toc")
	public void getAllTocs() {
		// checking the service method
		assertEquals(1, service.getAllTocs().size());

		// checking the controller method
		assertEquals(1, controller.getTocs().size());
	}

	@Test
	@DisplayName("save the valid toc and acknowledge the same")
	public void saveTocToTheServer() {
		TOC toc = new TOC(101, "python", 14, "expert in python", "basic knowledge of python", "begineer", 100);
		
		//checking the service method
		TOC toc1 = service.saveTOC(toc);
		assertNotNull(toc1);
		
		//checking the controller method
		 assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(toc),controller.saveTOC(toc));
		 
	}
	
	@Test
	@DisplayName("check connection")
	public void checkConnection() {
		assertEquals("Service Running", controller .sayHello()); 
	}

}
