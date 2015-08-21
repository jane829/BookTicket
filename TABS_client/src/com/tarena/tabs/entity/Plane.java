package com.tarena.tabs.entity;

public class Plane implements java.io.Serializable {

	private Integer planeId;
	private String planeNum;
	private String planeModel;
	private String planeManufacturer;

	/** default constructor */
	public Plane() {
	}

	/** minimal constructor */
	public Plane(String planeNum, String planeModel) {
		this.planeNum = planeNum;
		this.planeModel = planeModel;
	}

	/** full constructor */
	public Plane(String planeNum, String planeModel, String planeManufacturer) {
		this.planeNum = planeNum;
		this.planeModel = planeModel;
		this.planeManufacturer = planeManufacturer;
	}

	// Property accessors

	public Integer getPlaneId() {
		return this.planeId;
	}

	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}

	public String getPlaneNum() {
		return this.planeNum;
	}

	public void setPlaneNum(String planeNum) {
		this.planeNum = planeNum;
	}

	public String getPlaneModel() {
		return this.planeModel;
	}

	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}

	public String getPlaneManufacturer() {
		return this.planeManufacturer;
	}

	public void setPlaneManufacturer(String planeManufacturer) {
		this.planeManufacturer = planeManufacturer;
	}

}