package com.tarena.tabs.entity;

public class Airport implements java.io.Serializable {

	private Integer airportId;
	private String airportName;
	private Integer provinceId;
	private Province province;
	private Integer cityId;
	private City city;
	private String airportFullName;

	/** default constructor */
	public Airport() {
	}

	/** minimal constructor */
	public Airport(Integer provinceId, Integer cityId, String airportFullName) {
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.airportFullName = airportFullName;
	}

	/** full constructor */
	public Airport(String airportName, Integer provinceId, Integer cityId, String airportFullName) {
		this.airportName = airportName;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.airportFullName = airportFullName;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getAirportId() {
		return this.airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return this.airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getAirportFullName() {
		return this.airportFullName;
	}

	public void setAirportFullName(String airportFullName) {
		this.airportFullName = airportFullName;
	}

}