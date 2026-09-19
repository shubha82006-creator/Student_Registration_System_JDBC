package com.student;

import java.sql.*;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql = "INSERT INTO students (id, name, department, cgpa) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDepartment());
            ps.setDouble(4, student.getCgpa());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // VIEW STUDENTS
    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n========== STUDENT DETAILS ==========");

            System.out.printf("%-10s %-20s %-15s %-10s%n",
                    "ID", "NAME", "DEPARTMENT", "CGPA");

            while (rs.next()) {

                System.out.printf("%-10d %-20s %-15s %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("cgpa"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // UPDATE STUDENT
    public void updateStudent(int id, String name,
                              String department, double cgpa) {

        String sql = "UPDATE students SET name=?, department=?, cgpa=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, department);
            ps.setDouble(3, cgpa);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // DELETE STUDENT
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}