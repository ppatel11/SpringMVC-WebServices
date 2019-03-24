package com.rest.sample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rest.sample.db.DBConnection;
import com.rest.sample.modal.Investment;
import com.rest.sample.modal.Investor;

public class InvestmentService {
	
	public static boolean saveInvestment(Investment investment) {

		try {
			int investmentId = saveInvestmentToTable(investment);
			if (investment.getInvestors() != null) {
				for (Investor investor : investment.getInvestors()) {
					saveInvestorToTable(investor, investmentId);
				}
			}
		} catch (SQLException e) {
			return false;
		}

		return true;
	}
	
	private static int saveInvestmentToTable(Investment investment) throws SQLException {

		int returnId = 0;
		Connection dbConnection = null;
		PreparedStatement ps = null;

		String insertTableSQL = "INSERT INTO INVESTMENT"
				+ "(NAME , LEGAL_CLOSE_DATE, TAX_ID, COMMITMENT_AMOUNT, RELATIONSHIP_CLIENT, PORTFOLIO_TYPE, SYNDICATOR) "
				+ "VALUES" + "(?,?,?,?,?,?,?)";

		try {
			dbConnection = DBConnection.getDBConnection();

			System.out.println(insertTableSQL);
			
			ps  = dbConnection.prepareStatement(insertTableSQL, new String[] { "ID" });

			SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date date = new Date();
			try {
				date = dateFormatter.parse(investment.getLegalCloseDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
			
			ps.setString(1, investment.getName());
			ps.setDate(2, sqlStartDate);
			ps.setString(3, investment.getTaxId());
			ps.setDouble(4, investment.getCommitmentAmount() );
			ps.setString(5, investment.getRelationshipClient());
			ps.setString(6, investment.getPortfolioType());
			ps.setString(7, investment.getSyndicator());
			
			if(ps.executeUpdate() > 0) {
				
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					returnId = generatedKeys.getInt(1);
				}

			};

		} catch (SQLException e) {
			System.out.println(e);
		} finally {

			if (ps != null) {
				ps.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
		return returnId;
	}
	
	private static void saveInvestorToTable(Investor investor, int investmentId) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;

		String insertTableSQL = "INSERT INTO INVESTOR"
				+ "(NAME, OWNERSHIP , BLA_ONE, INVESTMENT_ID) "
				+ "VALUES" + "(?,?,?,?)";

		try {
			dbConnection = DBConnection.getDBConnection();
			ps  = dbConnection.prepareStatement(insertTableSQL);
			
			ps.setString(1, investor.getName());
			ps.setString(2, investor.getOwnership());
			ps.setString(3, investor.getBlaOne());
			ps.setInt(4, investmentId);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (ps != null) {
				ps.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}
	

}
