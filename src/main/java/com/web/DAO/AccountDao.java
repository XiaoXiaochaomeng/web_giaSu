package com.web.DAO;

import com.web.Model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDao extends DBconnect {

	public Account checklogin(String user, String pass) {
		try {

			String query = "select * from account where username =? and password=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account( rs.getString(1), rs.getString(2), rs.getString(3));
				return a;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Account account) throws SQLException {
		String query = "INSERT INTO account (username, password, position) VALUES (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, account.getUsername());
		statement.setString(2, account.getPassword());
		statement.setString(3, account.getPosition());
		statement.executeUpdate();
	}

	public Account getByUsername(String username) throws SQLException {
		String query = "SELECT * FROM account WHERE username = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String password = resultSet.getString("password");
			String position = resultSet.getString("position");
			return new Account(username, password, position);
		}
		return null;
	}

}
