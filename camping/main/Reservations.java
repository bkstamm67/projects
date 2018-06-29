package com.campspot.app;

public class Reservations {
	
	private int campsiteId;
	private String startDate;
	private String endDate;
	
	/**
	 * Constructor, used for testing
	 * @param campsiteId
	 * @param startDate
	 * @param endDate
	 */
	public Reservations(int campsiteId, String startDate, String endDate) {
		this.campsiteId = campsiteId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * @return the campsiteId
	 */
	public int getCampsiteId() {
		return campsiteId;
	}
	
	/**
	 * @param campsiteId the campsiteId to set
	 */
	public void setCampsiteId(int campsiteId) {
		this.campsiteId = campsiteId;
	}
	
	/**
	 * @return the start
	 */
	public String getStart() {
		return startDate;
	}
	
	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.startDate = start;
	}
	
	/**
	 * @return the end
	 */
	public String getEnd() {
		return endDate;
	}
	
	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.endDate = end;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reservations [campsiteId=" + campsiteId + ", start=" + startDate + ", end=" + endDate + "]";
	}

}
