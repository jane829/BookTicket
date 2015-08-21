package com.tarena.tabs.entity;

public class Branch {
	private int branchId;
	private String branchName;
	private int cityId;
	private String branchTelephone;
	private String branchFax;
	private String branchAddress;
	private String branchState;
	private String cityName;


	public Branch() {
		// TODO Auto-generated constructor stub
	}

	public Branch(int branchId, String branchName, int cityId, String branchTelephone, String branchFax,
			String branchAddress, String branchState) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.cityId = cityId;
		this.branchTelephone = branchTelephone;
		this.branchFax = branchFax;
		this.branchAddress = branchAddress;
		this.branchState = branchState;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getBranchTelephone() {
		return branchTelephone;
	}

	public void setBranchTelephone(String branchTelephone) {
		this.branchTelephone = branchTelephone;
	}

	public String getBranchFax() {
		return branchFax;
	}

	public void setBranchFax(String branchFax) {
		this.branchFax = branchFax;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBranchState() {
		return branchState;
	}

	public void setBranchState(String branchState) {
		this.branchState = branchState;
	}

	@Override
	public String toString() {
		return "Branch [\nid=" + this.branchId + ", \nname=" + this.branchName + ", \naddress=" + this.branchAddress
				+ ", \ntel=" + this.branchTelephone + ", \nfax=" + this.branchFax + ", \ncity=" + this.cityName + "\n]";
	}

}
