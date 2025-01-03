package org.example;

import java.sql.*;

public class Main {
    public static int index = 1;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "123456";

        Connection con = DriverManager.getConnection(url, user, pass);

        System.out.println("Connection Successful");


        read(con);

        create(con);

        updateData(con);

        delete(con);

        read(con);

        con.close();
        System.out.println("Connection Closed");
    }

    public static void read(Connection con) throws SQLException {

        Statement stmt = con.createStatement();
        String query = "SELECT * FROM student order by id asc";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.print(rs.getInt(3));
            System.out.println();

        }
    }

    public static void create(Connection con) throws SQLException {

        String query = "INSERT INTO student VALUES(?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, 11);
        stmt.setString(2, "John");
        stmt.setInt(3, 90);

        stmt.execute();
    }

    public static void updateData(Connection con) throws SQLException {
        String query = "UPDATE student SET marks = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, 90);
        stmt.setInt(2, 1);

        stmt.execute();
    }

    public static void delete(Connection con) throws SQLException {
        String query = "DELETE FROM student WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setInt(1, 6);

        stmt.execute();
    }
}