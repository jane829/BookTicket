package com.tarena.tabs.entity;

import java.io.Serializable;

public class Passanger implements Serializable{
	private int psgId;
	private String psgName;
	private String psgCertifType;
	private String CertifNum;
	private String psgEmail;
	private String psgPhone;

	public Passanger() {
	}

	public Passanger(int psgId, String psgName, String psgCertifType,
			String certifNum, String psgEmail, String psgPhone) {
		super();
		this.psgId = psgId;
		this.psgName = psgName;
		this.psgCertifType = psgCertifType;
		CertifNum = certifNum;
		this.psgEmail = psgEmail;
		this.psgPhone = psgPhone;
	}

	public int getPsgId() {
		return psgId;
	}

	public void setPsgId(int psgId) {
		this.psgId = psgId;
	}

	public String getPsgName() {
		return psgName;
	}

	public void setPsgName(String psgName) {
		this.psgName = psgName;
	}

	public String getPsgCertifType() {
		return psgCertifType;
	}

	public void setPsgCertifType(String psgCertifType) {
		this.psgCertifType = psgCertifType;
	}

	public String getCertifNum() {
		return CertifNum;
	}

	public void setCertifNum(String certifNum) {
		CertifNum = certifNum;
	}

	public String getPsgEmail() {
		return psgEmail;
	}

	public void setPsgEmail(String psgEmail) {
		this.psgEmail = psgEmail;
	}

	public String getPsgPhone() {
		return psgPhone;
	}

	public void setPsgPhone(String psgPhone) {
		this.psgPhone = psgPhone;
	}

	public String toString() {
		return this.psgName + "     " + this.psgCertifType + "     "
				+ this.CertifNum;
	}
}
