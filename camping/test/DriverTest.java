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
	private String testReservationOneStartDate = "2018-06-01";
	private String testReservationOneEndDate = "2018-06-09";
	private String testReservationTwoStartDate = "2018-05-03";
	private String testReservationTwoEndDate = "2018-05-11";
	private Reservations oneReservations;
	private Reservations twoReservations;
	
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
		oneReservations = new Reservations(firstId,testReservationOneStartDate,testReservationOneEndDate);
		twoReservations = new Reservations(secondId,testReservationTwoStartDate,testReservationTwoEndDate);
		testListReservations.add(oneReservations);
		testListReservations.add(twoReservations);
		
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
	public void testConstructor() {
		testDriver = new Driver(campSiteSearch);
		
		assertEquals(testDriver.dateCheck(testStartDateLocalDate, testEndDateLocalDate, oneReservations),true);
		assertEquals(testDriver.dateCheck(testStartDateLocalDate, testEndDateLocalDate, twoReservations),false);
	}

	
}
