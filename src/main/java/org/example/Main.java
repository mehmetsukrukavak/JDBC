package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "123456";
        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Connection Successful");

    }

}