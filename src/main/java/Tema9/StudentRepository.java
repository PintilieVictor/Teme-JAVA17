package Tema9;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepository {
    private List<Student> students;
    private Logger logger;

    public StudentRepository() {
        students = new ArrayList<>();
        logger = Logger.getLogger(StudentRepository.class.getName());
    }

    public void addStudent(String firstName, String lastName, String dateOfBirthStr, String gender, String id)
            throws IllegalArgumentException {
        validateFirstName(firstName);
        validateLastName(lastName);
        LocalDate dateOfBirth = validateAndParseDateOfBirth(dateOfBirthStr);
        validateGender(gender);
        validateID(id);

        students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
        logger.log(Level.INFO, "Student added: " + firstName + " " + lastName);
    }

    public void deleteStudentById(String id) throws IllegalArgumentException {
        validateID(id);

        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Student with ID: " + id + " does not exist");
        }

        logger.log(Level.INFO, "Student deleted: " + id);
    }

    public List<Student> retrieveStudentsWithAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        List<Student> studentsWithAge = new ArrayList<>();
        for (Student student : students) {
            int studentAge = student.calculateAge();
            if (studentAge == age) {
                studentsWithAge.add(student);
            }
        }

        return studentsWithAge;
    }

    public List<Student> listStudentsOrderedByLastName() {
        List<Student> orderedStudents = new ArrayList<>(students);
        orderedStudents.sort(Comparator.comparing(Student::getLastName));

        return orderedStudents;
    }

    public List<Student> listStudentsOrderedByBirthDate() {
        List<Student> orderedStudents = new ArrayList<>(students);
        orderedStudents.sort(Comparator.comparing(Student::getDateOfBirth));

        return orderedStudents;
    }
    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First Name should not be empty");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last Name should not be empty");
        }
    }

    private LocalDate validateAndParseDateOfBirth(String dateOfBirthStr) {
        try {
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
            int currentYear = LocalDate.now().getYear();
            int minYear = currentYear - 100; // Assuming the oldest person is 100 years old
            int maxYear = currentYear - 18; // Assuming minimum age is 18 years old
            if (dateOfBirth.isBefore(LocalDate.of(minYear, 1, 1)) || dateOfBirth.isAfter(LocalDate.of(maxYear, 12, 31))) {
                throw new IllegalArgumentException("Date of birth should be between " + minYear + " and " + maxYear);
            }
            return dateOfBirth;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd");
        }
    }

    private void validateGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender should not be empty");
        }
        String genderLowerCase = gender.toLowerCase();
        if (!(genderLowerCase.equals("male") || genderLowerCase.equals("female") || genderLowerCase.equals("m") || genderLowerCase.equals("f"))) {
            throw new IllegalArgumentException("Gender should be male or female");
        }
    }

    private void validateID(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID should not be empty");
        }
    }
}
