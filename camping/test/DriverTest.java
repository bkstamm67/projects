package com.campspot.app;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {
	
	private CampSiteSearch campSiteSearch;
	private Driver testDriver;
	
	private Search testSearch;
	private String testStartDate = "2018-05-01";
	private String testEndDate = "2018-05-04";
	private LocalDate testStartDateLocalDate;
	private LocalDate testEndDateLocalDate;
	
	List<Reservations> testListReservations;
	private String testReservationGoodStartDate = "2018-06-01";
	private String testReservationGoodEndDate = "2018-06-09";
	private String testReservationOverLappingStartDate = "2018-05-03";
	private String testReservationOverLappingEndDate = "2018-05-11";
	private String testReservationGapBeforeStartDate = "2018-04-26";
	private String testReservationGapBeforeEndDate = "2018-04-29";
	private String testReservationGapAfterStartDate = "2018-05-06";
	private String testReservationGapAfterEndDate = "2018-05-09";
	private Reservations goodReservations;
	private Reservations overLappingReservations;
	private Reservations gapBeforeReservations;
	private Reservations gapAfterReservations;
	
	List<CampSite> testListCampSite;
	private CampSite firstCampSite;
	private int firstId = 34;
	private String firstName = "Kaldi";
	private CampSite secondCampSite;
	private int secondId = 72;
	private String secondName = "Saba";
	
	private String answer;
	
	@Before
	public void initialize() {
		testSearch = new Search(testStartDate,testEndDate);
		
		testListReservations = new ArrayList<Reservations>();
		goodReservations = new Reservations(firstId,testReservationGoodStartDate,testReservationGoodEndDate);
		overLappingReservations = new Reservations(secondId,testReservationOverLappingStartDate,testReservationOverLappingEndDate);
		gapBeforeReservations = new Reservations(firstId,testReservationGapBeforeStartDate,testReservationGapBeforeEndDate);
		gapAfterReservations = new Reservations(secondId,testReservationGapAfterStartDate,testReservationGapAfterEndDate);
		testListReservations.add(goodReservations);
		testListReservations.add(overLappingReservations);
		testListReservations.add(gapBeforeReservations);
		
		testListCampSite = new ArrayList<CampSite>();
		firstCampSite = new CampSite(firstName,firstId);
		secondCampSite = new CampSite(secondName,secondId);
		testListCampSite.add(firstCampSite);
		testListCampSite.add(secondCampSite);
		
		campSiteSearch = new CampSiteSearch(testSearch,testListCampSite,testListReservations);
		
		testStartDateLocalDate = LocalDate.parse(campSiteSearch.getSearch().getStartDate());
		testEndDateLocalDate = LocalDate.parse(campSiteSearch.getSearch().getEndDate());
		
		answer = firstName;
	}
	
	@Test
	public void testDateCheck_noConflict() {
		testDriver = new Driver(campSiteSearch);
		
		assertEquals(testDriver.dateCheck(testStartDateLocalDate, testEndDateLocalDate, goodReservations),true);
		
	}
	
	@Test
	public void testDateCheck_conflictOverlapping() {
		testDriver = new Driver(campSiteSearch);
		
		assertEquals(testDriver.dateCheck(testStartDateLocalDate, testEndDateLocalDate, overLappingReservations),false);
	}
	
	@Test
	public void testDateCheck_conflictGapDay() {
		testDriver = new Driver(campSiteSearch);
		
		assertEquals(testDriver.dateCheck(testStartDateLocalDate, testEndDateLocalDate, gapBeforeReservations),false);
		assertEquals(testDriver.dateCheck(testStartDateLocalDate, testEndDateLocalDate, gapAfterReservations),false);
		
	}
	

	
}
