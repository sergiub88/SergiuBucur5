package edu.scoalainformala.HomeWork9;

import java.util.List;

public interface StudentRepository {
    void addStudent(Student student) throws StudentException;
    void deleteStudent(String id) throws StudentException;
    List<Student> findAllStudentsWithAge(int age) throws StudentException;
    List<Student> listStudentsOrderByLastNameOrBirthDate(String orderBy) throws StudentException;
}