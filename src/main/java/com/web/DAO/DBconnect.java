package com.web.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
    protected Connection connection;

    public DBconnect() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/giasuweb", "root",
                    "Anhem@123");
            System.out.print("Ket noi thanh cong voi csdl");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.print("Ket noi that bai voi csdl");
            System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
            e.printStackTrace();
        }
    }
}
