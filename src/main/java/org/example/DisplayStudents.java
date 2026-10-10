package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DisplayStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "hepsi";

        String query = "SELECT * FROM students";

        try (
                Connection con = DriverManager.getConnection(
                        url, username, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)
        ) {
            System.out.println("ID\tName\tAge\tBranch");
            System.out.println("--------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String branch = rs.getString("branch");

                String ageValue = rs.wasNull()
                        ? "NULL" : String.valueOf(age);

                System.out.println(id + "\t" + name + "\t"
                        + ageValue + "\t" + branch);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
