package com.campspot.app;

import java.util.List;

public class CampSiteSearch {
	
	private Search search;
	private List<CampSite> campsites;
	private List<Reservations> reservations;
	
	public CampSiteSearch(Search search,List<CampSite> campsites,List<Reservations> reservations) {
		this.search = search;
		this.campsites = campsites;
		this.reservations = reservations;
	}
	
	/**
	 * @return the listOfPossible
	 */
	public List<CampSite> getListOfPossible() {
		return campsites;
	}
	/**
	 * @param listOfPossible the listOfPossible to set
	 */
	public void setListOfPossible(List<CampSite> campsites) {
		this.campsites = campsites;
	}
	/**
	 * @return the reservations
	 */
	public List<Reservations> getReservations() {
		return reservations;
	}
	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	
	public String getCampGroundName(int id) {
		String answer = "";
		for(CampSite s: campsites) {
			if(s.getId() == id) {
				answer += s.getName();
			}
		}
		
		return answer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CampSiteSearch [search=" + search + ", campsites=" + campsites + ", reservations=" + reservations + "]";
	}

}
