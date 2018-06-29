package com.campspot.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReservationsTest {
	private int idNumber;
	private String start;
	private String end;
	
	@Before
	public void initialize() {
		this.idNumber = 13;
		this.start = "startString";
		this.end = "endString";
	}
	
	@Test
	public void testConstructor() {
		Reservations testReservation = new Reservations(idNumber, start, end);
		assertEquals(testReservation.getCampsiteId(),idNumber);
		assertEquals(testReservation.getStart(),start);
		assertEquals(testReservation.getEnd(),end);
	}
}
