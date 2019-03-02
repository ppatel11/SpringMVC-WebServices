package com.rest.sample.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.rest.sample.db.DBConnection;
import com.rest.sample.modal.User;

public class UserService {

	public static List<User> findByAll() throws SQLException {
		/*String sql = "SELECT * FROM USER1";*/
		String sql="{CALL GETUSERLIST(?)}";
		Connection con = null;
		ResultSet rs=null;
		List<User> users = new ArrayList<User>();
			con = DBConnection.getDBConnection();
			CallableStatement ps = con.prepareCall(sql);
			ps.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			ps.executeUpdate();
			rs=(ResultSet)ps.getObject(1);
			while(rs.next()){
				users.add(processRow(rs));
			}
			con.close();
			System.out.println("3");
		return users;
	}

	public static User findById(String loginName) throws SQLException {
		/*String sql = "SELECT * FROM USER1 WHERE userID = ?";*/
		String sql="{CALL GETUSER(?,?)}";
		Connection con = null;
		ResultSet rs=null;
		User user = new User();
		con = DBConnection.getDBConnection();
		CallableStatement ps = con.prepareCall(sql);
		ps.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
		ps.executeUpdate();
		
		rs=(ResultSet)ps.getObject(2);
		while(rs.next()){
			user=(processRow(rs));
		}
		con.close();
		
		
		return user;
	}

	

	private static User processRow(ResultSet rs) throws SQLException {

		User user = new User();
		
		user.setLoginName(rs.getString(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setStatusId(rs.getString(4));
		user.setLastLoginDate(rs.getDate(5));
		user.setCreatedDate(rs.getDate(6));
		user.setCreatedBy(rs.getInt(7));
		user.setModifiedDate(rs.getDate(8));
		user.setModifiedBy(rs.getInt(9));
		user.setEmail(rs.getString(10));
		user.setJobtitle(rs.getString(11));

		return user;
	}

}
