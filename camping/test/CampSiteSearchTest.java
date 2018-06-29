package com.campspot.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CampSiteSearchTest {
	private Search testSearch;
	private List<CampSite> testCampsites;
	private List<Reservations> testReservations;
	
	private int one = 1;
	private int two = 2;
	private String nameOne = "nameOne";
	private String nameTwo = "nameTwo";
	
	
	@Before
	public void initialize() {
		String end = "end";
		String start = "start";

		
		this.testSearch = new Search(start, end);
		
		this.testCampsites = new ArrayList<CampSite>();
		testCampsites.add(new CampSite(nameOne,one));
		testCampsites.add(new CampSite(nameTwo,two));
		
		this.testReservations = new ArrayList<Reservations>();
		testReservations.add(new Reservations(one,start,end));
		testReservations.add(new Reservations(two,end,start));
	}
	
	@Test
	public void testConstructor() {
		CampSiteSearch testCampSiteSearch = new CampSiteSearch(testSearch,testCampsites,testReservations);
		assertEquals(testCampSiteSearch.getListOfPossible(),testCampsites);
		assertEquals(testCampSiteSearch.getReservations(),testReservations);
		assertEquals(testCampSiteSearch.getSearch(),testSearch);
	}
	
	@Test
	public void testGetCampgroundName() {
		CampSiteSearch testCampSiteSearch = new CampSiteSearch(testSearch,testCampsites,testReservations);
		
		assertEquals(testCampSiteSearch.getCampGroundName(one),nameOne);
		assertEquals(testCampSiteSearch.getCampGroundName(two),nameTwo);
	}
}
