package edu.scoalainformala.HomeWork9;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {


        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            throw new IllegalArgumentException("Un student cu acest ID există deja.");
        }
        students.add(student);
    }

    @Override
    public void deleteStudent(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID-ul nu poate fi gol.");
        }
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            throw new NoSuchElementException("Nu există un student cu acest ID.");
        }
    }

    @Override
    public List<Student> findAllStudentsWithAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Vârsta nu poate fi negativă.");
        }
        return students.stream()
                .filter(student -> Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() == age)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> listStudentsOrderByLastNameOrBirthDate(String orderBy) {
        if (orderBy == null || orderBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Criteriul de ordonare nu poate fi gol.");
        }
        switch (orderBy.toLowerCase()) {
            case "lastname":
                return students.stream()
                        .sorted(Comparator.comparing(Student::getLastName))
                        .collect(Collectors.toList());
            case "birthdate":
                return students.stream()
                        .sorted(Comparator.comparing(Student::getDateOfBirth))
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Criteriul de ordonare '" + orderBy + "' nu este recunoscut.");
        }
    }
}