package com.rest.sample.modal;

import java.util.List;

import javax.ws.rs.FormParam;

public class Investment {
	
	public Investment() {
		
	}
	
	public Investment(String name, String legalCloseDate, String taxId, double commitmentAmount,
			String relationshipClient, String portfolioType, String syndicator) {
		
		this.name = name;
		this.legalCloseDate = legalCloseDate;
		this.taxId = taxId;
		this.commitmentAmount = commitmentAmount;
		this.relationshipClient = relationshipClient;
		this.portfolioType = portfolioType;
		this.syndicator = syndicator;
		//this.investors = investors;
	}
	
	@FormParam("name")
	private String name;
	
	@FormParam("legalCloseDate")
	private String legalCloseDate;
	
	@FormParam("taxId")
	private String taxId;
	
	@FormParam("commitmentAmount")
	private double commitmentAmount;
	
	@FormParam("relationshipClient")
	private String relationshipClient;
	
	@FormParam("portfolioType")
	private String portfolioType;
	
	@FormParam("syndicator")
	private String syndicator;
	
	private List<Investor> investors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegalCloseDate() {
		return legalCloseDate;
	}

	public void setLegalCloseDate(String legalCloseDate) {
		this.legalCloseDate = legalCloseDate;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public double getCommitmentAmount() {
		return commitmentAmount;
	}

	public void setCommitmentAmount(double commitmentAmount) {
		this.commitmentAmount = commitmentAmount;
	}

	public String getRelationshipClient() {
		return relationshipClient;
	}

	public void setRelationshipClient(String relationshipClient) {
		this.relationshipClient = relationshipClient;
	}

	public String getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(String portfolioType) {
		this.portfolioType = portfolioType;
	}

	public String getSyndicator() {
		return syndicator;
	}

	public void setSyndicator(String syndicator) {
		this.syndicator = syndicator;
	}

	public List<Investor> getInvestors() {
		return investors;
	}

	public void setInvestors(List<Investor> investors) {
		this.investors = investors;
	}
	
}
