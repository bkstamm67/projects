package com.campspot.app;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Driver {

	private final CampSiteSearch campSiteSearchJson;
	private final LocalDate reservationStartDate;
	private final LocalDate reservationEndDate;
	private final List<Reservations> currentReservation;
	private final List<CampSite> campSiteList;
	

	public Driver(CampSiteSearch campSiteSearchJson) {
		this.campSiteSearchJson = campSiteSearchJson;
		this.reservationStartDate = LocalDate.parse(campSiteSearchJson.getSearch().getStartDate());
		this.reservationEndDate = LocalDate.parse(campSiteSearchJson.getSearch().getEndDate());
		this.currentReservation = campSiteSearchJson.getReservations();
		this.campSiteList = campSiteSearchJson.getListOfPossible();
	}

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
 * 
 * @param hash
 * @param campSiteJson
 * @return
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
 * 
 * @param start
 * @param end
 * @param r
 * @return
 */
public static  boolean dateCheck(LocalDate start, LocalDate end, Reservations r) {
	return (checkStart(start, r) && checkEnd(end,r) && checkRange(start,r) && checkRange(end,r));

}

/**
 * 
 * @param start
 * @param r
 * @return
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
 * 
 * @param end
 * @param r
 * @return
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

public static  boolean checkRange(LocalDate date, Reservations r) {
	boolean answer = true;

	if(date.isAfter(LocalDate.parse(r.getStart())) &&
			date.isBefore(LocalDate.parse(r.getEnd()))){
		answer = false;
	}

	return answer;
}

/**
 * 
 * @param campList
 * @return
 */
public static  HashMap<Integer, Boolean> createHashMap(List<CampSite> campList) {
	HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();

	for(CampSite cs: campList) {
		hash.put(cs.getId(), true);
	}

	return hash;
}
}
