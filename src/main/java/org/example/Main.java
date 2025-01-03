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

        Statement stmt = con.createStatement();
        read(stmt);

        addData(stmt);

        updateData(stmt);

        delete(stmt);

        read(stmt);

        con.close();
        System.out.println("Connection Closed");
    }

    public static void read(Statement stmt) throws SQLException {

        String query = "SELECT * FROM student order by id asc";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.print(rs.getInt(3));
            System.out.println();

        }
    }

    public static void addData(Statement stmt) throws SQLException {
        String query = "INSERT INTO student VALUES(7, 'Çakıl', 5)";
        stmt.execute(query);
    }

    public static void updateData(Statement stmt) throws SQLException {
        String query = "UPDATE student SET marks = 100 WHERE id = 5";
        stmt.execute(query);
    }

    public static void delete(Statement stmt) throws SQLException {
        String query = "DELETE FROM student WHERE id = 4";
        stmt.execute(query);
    }
}