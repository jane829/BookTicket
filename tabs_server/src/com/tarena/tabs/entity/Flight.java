package com.tarena.tabs.entity;

import java.io.Serializable;

public class Flight implements Serializable {

	private String id;
	private String flightId;
	private String flightNum;
	private String planFromDate;
	private String planToDate;
	private String fromTime;
	private String toTime;
	private String plane;
	private String price;
	private String fromAirport;
	private String toAirport;
	private String days;
	private String fromCity;
	private String toCity;
	private double currentPrice;
	private double tax1Price;
	private double tax2Price;

	public Flight() {
		super();
	}

	public Flight(String id, String flightId, String planFromDate, String planToDate, String fromTime, String toTime,
			String plane, String price, String fromAirport, String toAirport, String days, String fromCity,
			String toCity) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.planFromDate = planFromDate;
		this.planToDate = planToDate;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.plane = plane;
		this.price = price;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
		this.days = days;
		this.fromCity = fromCity;
		this.toCity = toCity;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getTax1Price() {
		return tax1Price;
	}

	public void setTax1Price(double tax1Price) {
		this.tax1Price = tax1Price;
	}

	public double getTax2Price() {
		return tax2Price;
	}

	public void setTax2Price(double tax2Price) {
		this.tax2Price = tax2Price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getPlanFromDate() {
		return planFromDate;
	}

	public void setPlanFromDate(String planFromDate) {
		this.planFromDate = planFromDate;
	}

	public String getPlanToDate() {
		return planToDate;
	}

	public void setPlanToDate(String planToDate) {
		this.planToDate = planToDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}

	public String getToAirport() {
		return toAirport;
	}

	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	@Override
	public String toString() {
		return "Flight [\nid=" + id + ", \nflightId=" + flightId + ", \nplanFromDate=" + planFromDate
				+ ", \nplanToDate=" + planToDate + ", \nfromTime=" + fromTime + ", \ntoTime=" + toTime + ", \nplane="
				+ plane + ", \nprice=" + price + ", \nfromAirport=" + fromAirport + ", \ntoAirport=" + toAirport
				+ ", \ndays=" + days + ", \nfromCity=" + fromCity + ", \ntoCity=" + toCity + "]";
	}

	public String getTitle() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(this.planFromDate + "   "+this.plane + "   " +this.flightNum);
		return sbf.toString();
	}

	public CharSequence getFromInfo() {
		return planFromDate+"   "+ fromTime + "   "+fromAirport;
	}

	public CharSequence getToInfo() {
		return planToDate+"   "+toTime+"   "+toAirport;
	}

}
