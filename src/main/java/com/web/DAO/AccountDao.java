package com.web.DAO;

import com.web.Model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDao extends DBconnect {

    public Account checklogin(String username, String pass) {
        try {

            String query = "select * from account where username =? and password=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String encode = resultSet.getString("encode");

                return new Account(id, username, password, role, encode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createAccount(Account account) throws SQLException {
        String query = "INSERT INTO Account (username, password, role, encode) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getRole());
            statement.setString(4, account.getEncode());

            statement.executeUpdate();
        }
    }

    public Account getAccountByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Account WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    String encode = resultSet.getString("encode");

                    return new Account(id, username, password, role, encode);
                }
            }
        }

        return null;
    }

    public void updateAccount(Account account) throws SQLException {
        String query = "UPDATE Account SET password = ?, role = ?, encode = ? WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getPassword());
            statement.setString(2, account.getRole());
            statement.setString(3, account.getEncode());
            statement.setString(4, account.getUsername());

            statement.executeUpdate();
        }
    }

    public void deleteAccount(String username) throws SQLException {
        String query = "DELETE FROM Account WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }
    }

}
