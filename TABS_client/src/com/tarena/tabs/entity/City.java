package com.tarena.tabs.entity;

public class City {
	private int id;
	private String cityName;
	private int provinceId;
	private String citySpellName;

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(int id, String cityName, int provinceId, String citySpellName) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.provinceId = provinceId;
		this.citySpellName = citySpellName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getCitySpellName() {
		return citySpellName;
	}

	public void setCitySpellName(String citySpellName) {
		this.citySpellName = citySpellName;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + cityName + "]";
	}

}
