package com.campspot.app;

public class Search {
	
	private String startDate;
	private String endDate;
	
	/**
	 * Constructor
	 * @param start String startDate
	 * @param end String endDate
	 */
	public Search(String start, String end) {
		this.startDate = start;
		this.endDate = end;
	}
	
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Search [startDate=" + startDate.toString() + ", endDate=" + endDate.toString() + "]";
	}
	
	

}
