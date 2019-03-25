package com.rest.sample.modal;

public class Investor {
	
	public Investor() {
		
	}
	
	public Investor(String name, String ownership, String blaOne,  int investmentID) {
		this.name = name;
		this.ownership = ownership;
		this.blaOne = blaOne;
		this. investmentID= investmentID;
	}

	private String name;
	
	private String ownership;
	
	private String blaOne;
	
	private int investmentID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getBlaOne() {
		return blaOne;
	}

	public void setBlaOne(String blaOne) {
		this.blaOne = blaOne;
	}

	public int getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(int investmentID) {
		this.investmentID = investmentID;
	}
	
	
	
}
