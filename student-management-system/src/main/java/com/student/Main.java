package com.student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    Student student =
                            new Student(id, name, department, cgpa);

                    dao.addStudent(student);
                    break;


                case 2:

                    dao.viewStudents();
                    break;


                case 3:

                    System.out.print("Enter Student ID to update: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    department = sc.nextLine();

                    System.out.print("Enter New CGPA: ");
                    cgpa = sc.nextDouble();

                    dao.updateStudent(id, name, department, cgpa);
                    break;


                case 4:

                    System.out.print("Enter Student ID to delete: ");
                    id = sc.nextInt();

                    dao.deleteStudent(id);
                    break;


                case 5:

                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    System.exit(0);
                    break;


                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}