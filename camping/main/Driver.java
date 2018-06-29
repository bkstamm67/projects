package com.campspot.app;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The main driver of the application, taking the json object in
 * and completing the required tasks
 * @author Brian Stamm
 *
 */
public class Driver {

	private final CampSiteSearch campSiteSearchJson;
	private final LocalDate reservationStartDate;
	private final LocalDate reservationEndDate;
	private final List<Reservations> currentReservation;
	private final List<CampSite> campSiteList;
	
	/**
	 * Constructor, used in testing
	 * @param campSiteSearchJson json object
	 */
	public Driver(CampSiteSearch campSiteSearchJson) {
		this.campSiteSearchJson = campSiteSearchJson;
		this.reservationStartDate = LocalDate.parse(campSiteSearchJson.getSearch().getStartDate());
		this.reservationEndDate = LocalDate.parse(campSiteSearchJson.getSearch().getEndDate());
		this.currentReservation = campSiteSearchJson.getReservations();
		this.campSiteList = campSiteSearchJson.getListOfPossible();
	}
	
	/**
	 * The primary method, creates a hash map of the campsite's id and boolean values.  It 
	 * then checks each current reservation to see the requested dates do not overlap.  If 
	 * they do, the campsite's id is marked invalid (false) in the hash map. It then builds
	 * a string of campsites that can reserved.
	 */
	public void run() {

		HashMap<Integer, Boolean> hash = createHashMap(campSiteList);

		for(Reservations r : currentReservation) {
			if (!dateCheck(reservationStartDate,reservationEndDate,r)){
				hash.put(r.getCampsiteId(), false);
			}
		}

		String answer = buildResponse(hash, campSiteSearchJson);

		System.out.println(answer);


	}

/**
 * Takes in the hash map, iterating through its values.  If the boolean value is still
 * true, it adds it to a StringBuilder object
 * @param hash a hash map of Integer, which is the camp id, and Boolean, which is if the
 * reservation dates are valid
 * @param campSiteJson - the CampSiteSearch used to look up the string name of the campsite
 * @return String of CampSite names
 */
public static String buildResponse(HashMap<Integer, Boolean> hash, CampSiteSearch campSiteJson) {
	StringBuilder sb = new StringBuilder();
	Iterator iter = hash.entrySet().iterator();

	while(iter.hasNext()) {
		Map.Entry pair = (Map.Entry)iter.next();
		if((Boolean)(pair.getValue())) {
			sb.append(campSiteJson.getCampGroundName((Integer)pair.getKey()));
			sb.append("\n");
		}
	}

	return sb.toString();
}

/**
 * Method to check if the dates of the reservation are valid for a given campsite, using three
 * helper methods
 * @param start LocalDate the start date of the reservation
 * @param end LocalDate the end date of the reservation
 * @param r Reservations, containing the campsite id and start/end date
 * @return boolean true if the reservation dates work for the campsite, false if not
 */
public static  boolean dateCheck(LocalDate start, LocalDate end, Reservations r) {
	return (checkStart(start, r) && checkEnd(end,r) && checkRange(start,r) && checkRange(end,r));

}

/**
 * Helper method, checking the start date
 * @param start LocalDate the start date of the reserveration
 * @param r Reservations the reservation which is already booked, which contains the
 * campsite id, start and end date
 * @return boolean true if the start date is valid and does not allow a gap day, false
 * if it is invalid
 */
public static  boolean checkStart(LocalDate start, Reservations r) {
	boolean answer = false;
	if(start.isBefore(LocalDate.parse(r.getStart()))  || 
			(start.isAfter(LocalDate.parse(r.getEnd())))){
		answer = true;
		if(start.isAfter(LocalDate.parse(r.getEnd())) 
				&& start.isEqual(LocalDate.parse(r.getEnd()).plusDays(2))) {
			answer = false;
		}
	}

	return answer;
}

/**
 * Helper method, checking the end date
 * @param end LocalDate the start date of the reserveration
 * @param r Reservations the reservation which is already booked, which contains the
 * campsite id, start and end date
 * @return boolean true if the end date is valid and does not allow a gap day, false
 * if it is invalid
 */
public static  boolean checkEnd(LocalDate end, Reservations r) {
	boolean answer = false;

	if(end.isAfter(LocalDate.parse(r.getStart())) ||
			end.isBefore(LocalDate.parse(r.getEnd()))){
		answer = true;
		if(end.isBefore(LocalDate.parse(r.getStart())) && 
				end.isEqual(LocalDate.parse(r.getStart()).minusDays(2))) {
			answer = false;
		}
	}

	return answer;
}

/**
 * Helper method to check if the date overlaps the current reservation
 * @param date LocalDate, can be start or end
 * @param r Reservations the reservation which is already booked, which contains the
 * campsite id, start and end date
 * @return boolean true if the date is valid and does not overlap, false
 * if it is invalid
 */
public static  boolean checkRange(LocalDate date, Reservations r) {
	boolean answer = true;

	if(date.isAfter(LocalDate.parse(r.getStart())) &&
			date.isBefore(LocalDate.parse(r.getEnd()))){
		answer = false;
	}

	return answer;
}

/**
 * Returns a hash map with campsite id number and boolean value of true
 * @param campList CampSite list with the relevant campsites
 * @return hash map
 */
public static  HashMap<Integer, Boolean> createHashMap(List<CampSite> campList) {
	HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();

	for(CampSite cs: campList) {
		hash.put(cs.getId(), true);
	}

	return hash;
}
}
