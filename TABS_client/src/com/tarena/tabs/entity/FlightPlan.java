package com.tarena.tabs.entity;

import java.util.Date;

public class FlightPlan implements java.io.Serializable {


	private Integer fpId;
	private String flightNum;
	private Date fpStartDate;
	private Date fpEndDate;
	private Integer routeId;
	private String fpDepartureTime;
	private String fpArrivalTime;


	/** default constructor */
	public FlightPlan() {
	}

	/** full constructor */
	public FlightPlan(String flightNum, Date fpStartDate, Date fpEndDate, Integer routeId, String fpDepartureTime,
			String fpArrivalTime) {
		this.flightNum = flightNum;
		this.fpStartDate = fpStartDate;
		this.fpEndDate = fpEndDate;
		this.routeId = routeId;
		this.fpDepartureTime = fpDepartureTime;
		this.fpArrivalTime = fpArrivalTime;
	}

	// Property accessors

	public Integer getFpId() {
		return this.fpId;
	}

	public void setFpId(Integer fpId) {
		this.fpId = fpId;
	}

	public String getFlightNum() {
		return this.flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public Date getFpStartDate() {
		return this.fpStartDate;
	}

	public void setFpStartDate(Date fpStartDate) {
		this.fpStartDate = fpStartDate;
	}

	public Date getFpEndDate() {
		return this.fpEndDate;
	}

	public void setFpEndDate(Date fpEndDate) {
		this.fpEndDate = fpEndDate;
	}

	public Integer getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getFpDepartureTime() {
		return this.fpDepartureTime;
	}

	public void setFpDepartureTime(String fpDepartureTime) {
		this.fpDepartureTime = fpDepartureTime;
	}

	public String getFpArrivalTime() {
		return this.fpArrivalTime;
	}

	public void setFpArrivalTime(String fpArrivalTime) {
		this.fpArrivalTime = fpArrivalTime;
	}

}