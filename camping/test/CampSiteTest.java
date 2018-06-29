package com.campspot.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CampSiteTest {
	
	private String name;
	private int id;
	
	@Before
	public void initialize() {
		this.id = 6;
		this.name = "Kaldi";
	}
	
	@Test
	public void testConstructor() {
		CampSite testCampSite = new CampSite(name, id);
		assertEquals(testCampSite.getId(),id);
		assertEquals(testCampSite.getName(),name);
		
	}
}
