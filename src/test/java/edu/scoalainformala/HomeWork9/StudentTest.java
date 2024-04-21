package edu.scoalainformala.HomeWork9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class StudentTest {

    @Test
    void testStudentConstructorValidData() {
        assertDoesNotThrow(() -> {
            new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        });
    }

    @Test
    void testStudentConstructorNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student(null, "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        });
        assertTrue(exception.getMessage().contains("Numele și prenumele nu pot fi goale"));
    }

    @Test
    void testStudentConstructorEmptyLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("John", "", LocalDate.of(2000, 1, 1), "M", "123456");
        });
        assertTrue(exception.getMessage().contains("Numele și prenumele nu pot fi goale"));
    }

    @Test
    void testStudentConstructorInvalidGender() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("John", "Doe", LocalDate.of(2000, 1, 1), "X", "123456");
        });
        assertTrue(exception.getMessage().contains("Genul trebuie să fie 'M' sau 'F'"));
    }

    @Test
    void testStudentConstructorNullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", null);
        });
        assertTrue(exception.getMessage().contains("ID-ul nu poate fi gol"));
    }

    @Test
    void testStudentConstructorInvalidDateOfBirthTooOld() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("John", "Doe", LocalDate.of(1899, 12, 31), "M", "123456");
        });
        assertTrue(exception.getMessage().contains("Data nasterii este în afara intervalului acceptat"));
    }

    @Test
    void testStudentConstructorInvalidDateOfBirthTooYoung() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("John", "Doe", LocalDate.now().minusYears(17), "M", "123456");
        });
        assertTrue(exception.getMessage().contains("Data nasterii este în afara intervalului acceptat"));
    }

    // Tests for setters and getters
    @Test
    void testSetAndGetFirstName() {
        Student student = new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        student.setFirstName("Jane");
        assertEquals("Jane", student.getFirstName());
    }

    @Test
    void testSetAndGetLastName() {
        Student student = new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        student.setLastName("Smith");
        assertEquals("Smith", student.getLastName());
    }

    @Test
    void testSetAndGetDateOfBirth() {
        Student student = new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        LocalDate newDateOfBirth = LocalDate.of(1999, 12, 31);
        student.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, student.getDateOfBirth());
    }

    @Test
    void testSetAndGetGender() {
        Student student = new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        student.setGender("F");
        assertEquals("F", student.getGender());
    }

    @Test
    void testSetAndGetId() {
        Student student = new Student("John", "Doe", LocalDate.of(2000, 1, 1), "M", "123456");
        student.setId("654321");
        assertEquals("654321", student.getId());
    }
}