package com.tarena.tabs.entity;

import java.sql.Timestamp;

public class Information implements java.io.Serializable {

	private Integer infoId;
	private String infoTitle;
	private String infoContent;
	private Timestamp infoTime;

	/** default constructor */
	public Information() {
	}

	/** minimal constructor */
	public Information(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	/** full constructor */
	public Information(String infoTitle, String infoContent, Timestamp infoTime) {
		this.infoTitle = infoTitle;
		this.infoContent = infoContent;
		this.infoTime = infoTime;
	}

	// Property accessors

	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoTitle() {
		return this.infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfoContent() {
		return this.infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public Timestamp getInfoTime() {
		return this.infoTime;
	}

	public void setInfoTime(Timestamp infoTime) {
		this.infoTime = infoTime;
	}

}