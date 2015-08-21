package com.tarena.tabs.entity;

public class Route implements java.io.Serializable {

	private Integer routeId;
	private Integer fromAirportId;
	private Integer toAirportId;
	private Integer routeDistance;
	private Airport fromAirport;
	private Airport toAirport;

	/** default constructor */
	public Route() {
	}

	/** full constructor */
	public Route(Integer fromAirportId, Integer toAirportId, Integer routeDistance) {
		this.fromAirportId = fromAirportId;
		this.toAirportId = toAirportId;
		this.routeDistance = routeDistance;
	}

	// Property accessors

	public Integer getRouteId() {
		return this.routeId;
	}

	public Airport getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(Airport fromAirport) {
		this.fromAirport = fromAirport;
	}

	public Airport getToAirport() {
		return toAirport;
	}

	public void setToAirport(Airport toAirport) {
		this.toAirport = toAirport;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getFromAirportId() {
		return this.fromAirportId;
	}

	public void setFromAirportId(Integer fromAirportId) {
		this.fromAirportId = fromAirportId;
	}

	public Integer getToAirportId() {
		return this.toAirportId;
	}

	public void setToAirportId(Integer toAirportId) {
		this.toAirportId = toAirportId;
	}

	public Integer getRouteDistance() {
		return this.routeDistance;
	}

	public void setRouteDistance(Integer routeDistance) {
		this.routeDistance = routeDistance;
	}

}