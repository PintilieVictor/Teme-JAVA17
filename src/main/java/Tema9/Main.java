package Tema9;

import java.util.List;

public class Main {
        public static void main(String[] args) {
            StudentRepository repository = new StudentRepository();

            try {
                repository.addStudent("Matt", "Smith", "1995-05-15", "M", "123456789");
                repository.addStudent("Mary", "Sue", "1998-08-22", "F", "987654321");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                repository.deleteStudentById("123456789");
                repository.deleteStudentById(""); // Throws exception
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                List<Student> studentsWithAge25 = repository.retrieveStudentsWithAge(25);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                List<Student> studentsOrderedByLastName = repository.listStudentsOrderedByLastName();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                List<Student> studentsOrderedByBirthDate = repository.listStudentsOrderedByBirthDate();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
