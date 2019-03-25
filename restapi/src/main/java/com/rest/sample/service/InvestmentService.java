package com.rest.sample.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.rest.sample.db.DBConnection;
import com.rest.sample.modal.Investment;
import com.rest.sample.modal.Investor;

public class InvestmentService {
	
	public static boolean saveInvestment(Investment investment) {

		try {
			saveInvestmentToTable(investment);
			if (investment.getInvestors() != null) {
				for (Investor investor : investment.getInvestors()) {
					saveInvestorToTable(investor);
				}
			}
		} catch (SQLException e) {
			return false;
		}

		return true;
	}
	
	private static void saveInvestmentToTable(Investment investment) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL = "INSERT INTO INVESTMENT"
				+ "(NAME, LEGAL_CLOSE_DATE , TAX_ID, COMMITMENT_AMOUNT, RELATIONSHIP_CLIENT, PORTFOLIO_TYPE, SYNDICATOR) "
				+ "VALUES" + "('" + investment.getName() + "', " + "to_date('" + investment.getLegalCloseDate()
				+ "', 'MM/dd/yyyy'), '" + investment.getTaxId() + "', '"
				+ investment.getCommitmentAmount() + "'" + ", '" + investment.getRelationshipClient() + "', '"
				+ investment.getPortfolioType() + "', '" + investment.getSyndicator() + "' )";

		try {
			dbConnection = DBConnection.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL stetement
			statement.executeUpdate(insertTableSQL);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}
	
	private static void saveInvestorToTable(Investor investor) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL = "INSERT INTO INVESTOR"
				+ "(NAME, OWNERSHIP , BLA_ONE) "
				+ "VALUES" + "('" + investor.getName() + "', '"+investor.getOwnership()+"', '"+investor.getBlaOne()+"')";

		try {
			dbConnection = DBConnection.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(insertTableSQL);
			
			statement.executeUpdate(insertTableSQL);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}
	

}
