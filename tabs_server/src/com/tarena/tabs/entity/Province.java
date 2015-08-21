package com.tarena.tabs.entity;

public class Province implements java.io.Serializable {

	private Integer provinceId;
	private String provinceName;
	private String provinceSimpleName;
	private String provinceSpellName;

	/** default constructor */
	public Province() {
	}

	/** full constructor */
	public Province(String provinceName, String provinceSimpleName, String provinceSpellName) {
		this.provinceName = provinceName;
		this.provinceSimpleName = provinceSimpleName;
		this.provinceSpellName = provinceSpellName;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceSimpleName() {
		return this.provinceSimpleName;
	}

	public void setProvinceSimpleName(String provinceSimpleName) {
		this.provinceSimpleName = provinceSimpleName;
	}

	public String getProvinceSpellName() {
		return this.provinceSpellName;
	}

	public void setProvinceSpellName(String provinceSpellName) {
		this.provinceSpellName = provinceSpellName;
	}

}