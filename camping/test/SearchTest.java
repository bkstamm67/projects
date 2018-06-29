package com.campspot.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SearchTest {
	
	private String start;
	private String end;
	
	/**
	* Initialize all the variables for testing
	*/
	@Before
	public void initialize() {
		this.start = "StartDate";
		this.end = "EndDate";
	}
	
	@Test
	public void testConstructor() {
		Search testSearch = new Search(start,end);
		assertEquals(testSearch.getStartDate(),start);
		assertEquals(testSearch.getEndDate(),end);
	}

}
