package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudentCourse {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "hepsi";

        String query =
                "UPDATE students SET branch = ? WHERE id = ?";

        try (
                Scanner sc = new Scanner(System.in);
                Connection con = DriverManager.getConnection(
                        url, username, password);
                PreparedStatement ps = con.prepareStatement(query)
        ) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new branch: ");
            String branch = sc.nextLine();

            ps.setString(1, branch);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Branch updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
