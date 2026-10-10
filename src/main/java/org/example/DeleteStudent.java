package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "hepsi";

        String query = "DELETE FROM students WHERE id = ?";

        try (
                Scanner sc = new Scanner(System.in);
                Connection con = DriverManager.getConnection(
                        url, username, password);
                PreparedStatement ps = con.prepareStatement(query)
        ) {
            System.out.print("Enter student ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
