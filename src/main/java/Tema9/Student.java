package Tema9;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public static <U extends Comparable<? super U>, T> U getLastName(T t) {
        return null;
    }

    public static <U extends Comparable<? super U>, T> U getDateOfBirth(T t) {
        return null;
    }

    public Object getId() {
        return null;
    }
}

