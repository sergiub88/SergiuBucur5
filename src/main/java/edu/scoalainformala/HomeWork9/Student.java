package edu.scoalainformala.HomeWork9;


import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Numele și prenumele nu pot fi goale.");
        }
        if (!(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
            throw new IllegalArgumentException("Genul trebuie să fie 'M' sau 'F'.");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID-ul nu poate fi gol.");
        }
        if (dateOfBirth.isBefore(LocalDate.of(1900, 1, 1)) || dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Data nasterii este în afara intervalului acceptat.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender.toUpperCase();
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }
}