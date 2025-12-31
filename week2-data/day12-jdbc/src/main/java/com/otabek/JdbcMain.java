package com.otabek;

import java.sql.*;

public class JdbcMain {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "macbook";
        String password = "";

        System.out.println("Connecting to database...");
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            String insertSQL = "INSERT INTO users (username, email, age, is_active) VALUES (?, ?, ?, ?)";

            try (var pStmt = con.prepareStatement(insertSQL)) {
                pStmt.setString(1, "new_year_coder");
                pStmt.setString(2, "2025@java.com");
                pStmt.setInt(3, 2025);
                pStmt.setBoolean(4, true);

                int rowsAffected = pStmt.executeUpdate();
                System.out.println("🎉 Inserted " + rowsAffected + " new user for 2025!");
            }

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM users";

            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("User list : ");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String email = resultSet.getString("email");

                System.out.println("ID: "+ id+" User : "+ name + " Email "+ email);
            }

        } catch (SQLException e) {
            System.out.println("Connection failed ");
            System.out.println("Error massage : " + e.getMessage());
        }
    }
}