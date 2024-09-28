package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static String Load_Driver = "Com.mysql.cj.jdbc.Driver";
    public static String URl = "jdbc:mysql://localhost:3306/TruckManagement";
    public static String pass = "6208gct";
    public static String Username = "root";

    public static Connection getConnection() throws SQLException {

        return  DriverManager.getConnection(URl,Username,pass);
    }
}
