package com.tarena.tabs.entity;

import java.sql.Timestamp;


public class Ticket implements java.io.Serializable {


	private Long ticketId;
	private Long orderId;
	private String flightNum;
	private Integer routeId;
	private Timestamp departureDatetime;
	private Timestamp arrivalDatatime;
	private Integer psgId;
	private Timestamp ticketDate;
	private Double ticketPrice;
	private Double tax1Price;
	private Double tax2Price;
	private Double totalPrice;


	/** default constructor */
	public Ticket() {
	}

	/** minimal constructor */
	public Ticket(Long ticketId, String flightNum, Integer routeId, Timestamp departureDatetime,
			Timestamp arrivalDatatime, Timestamp ticketDate, Double ticketPrice, Double tax1Price, Double tax2Price,
			Double totalPrice) {
		this.ticketId = ticketId;
		this.flightNum = flightNum;
		this.routeId = routeId;
		this.departureDatetime = departureDatetime;
		this.arrivalDatatime = arrivalDatatime;
		this.ticketDate = ticketDate;
		this.ticketPrice = ticketPrice;
		this.tax1Price = tax1Price;
		this.tax2Price = tax2Price;
		this.totalPrice = totalPrice;
	}

	/** full constructor */
	public Ticket(Long ticketId, Long orderId, String flightNum, Integer routeId, Timestamp departureDatetime,
			Timestamp arrivalDatatime, Integer psgId, Timestamp ticketDate, Double ticketPrice, Double tax1Price,
			Double tax2Price, Double totalPrice) {
		this.ticketId = ticketId;
		this.orderId = orderId;
		this.flightNum = flightNum;
		this.routeId = routeId;
		this.departureDatetime = departureDatetime;
		this.arrivalDatatime = arrivalDatatime;
		this.psgId = psgId;
		this.ticketDate = ticketDate;
		this.ticketPrice = ticketPrice;
		this.tax1Price = tax1Price;
		this.tax2Price = tax2Price;
		this.totalPrice = totalPrice;
	}

	// Property accessors

	public Long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFlightNum() {
		return this.flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public Integer getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Timestamp getDepartureDatetime() {
		return this.departureDatetime;
	}

	public void setDepartureDatetime(Timestamp departureDatetime) {
		this.departureDatetime = departureDatetime;
	}

	public Timestamp getArrivalDatatime() {
		return this.arrivalDatatime;
	}

	public void setArrivalDatatime(Timestamp arrivalDatatime) {
		this.arrivalDatatime = arrivalDatatime;
	}

	public Integer getPsgId() {
		return this.psgId;
	}

	public void setPsgId(Integer psgId) {
		this.psgId = psgId;
	}

	public Timestamp getTicketDate() {
		return this.ticketDate;
	}

	public void setTicketDate(Timestamp ticketDate) {
		this.ticketDate = ticketDate;
	}

	public Double getTicketPrice() {
		return this.ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Double getTax1Price() {
		return this.tax1Price;
	}

	public void setTax1Price(Double tax1Price) {
		this.tax1Price = tax1Price;
	}

	public Double getTax2Price() {
		return this.tax2Price;
	}

	public void setTax2Price(Double tax2Price) {
		this.tax2Price = tax2Price;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}