package com.tarena.tabs.entity;

import java.sql.Timestamp;

public class TicketOrder implements java.io.Serializable {

	private Long orderId;
	private Integer userId;
	private Double orderMoney;
	private Timestamp orderDate;
	private String orderState;
	private String flightId;

	/** default constructor */
	public TicketOrder() {
	}

	/** minimal constructor */
	public TicketOrder(Long orderId, Integer userId, Double orderMoney, Timestamp orderDate, String flightId) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderMoney = orderMoney;
		this.orderDate = orderDate;
		this.flightId = flightId;
	}

	/** full constructor */
	public TicketOrder(Long orderId, Integer userId, Double orderMoney, Timestamp orderDate, String orderState,
			String flightId) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderMoney = orderMoney;
		this.orderDate = orderDate;
		this.orderState = orderState;
		this.flightId = flightId;
	}

	// Property accessors

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getOrderMoney() {
		return this.orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getFlightId() {
		return this.flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

}