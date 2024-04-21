package edu.scoalainformala.HomeWork9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepositoryImpl();


        try {
            logger.info("Adaugarea studenților...");
            repository.addStudent(new Student("Ion", "Popescu", LocalDate.of(2002, 5, 21), "M", "1234567890123"));
            repository.addStudent(new Student("Vass", "Paul", LocalDate.of(2003, 8, 15), "F", "9876543210987"));
            repository.addStudent(new Student("Cristian", "Popescu", LocalDate.of(2001, 3, 10), "M", "1928374650912"));
        } catch (Exception e) {
            logger.error("Eroare la adăugarea studenților: " + e.getMessage());
        }


        try {
            logger.info("Stergerea unui student...");
            repository.deleteStudent("1234567890123");
        } catch (Exception e) {
            logger.error("Eroare la stergerea studentului: " + e.getMessage());
        }


        try {
            logger.info("Cautarea studentilor cu varsta de 19 ani...");
            repository.findAllStudentsWithAge(19).forEach(student ->
                    logger.info(student.getFirstName() + " " + student.getLastName()));
        } catch (Exception e) {
            logger.error("Eroare la căutarea studentilor: " + e.getMessage());
        }


        try {
            logger.info("Listarea studentilor ordonati dupa numele de familie...");
            repository.listStudentsOrderByLastNameOrBirthDate("lastname").forEach(student ->
                    logger.info(student.getLastName() + " " + student.getFirstName()));
        } catch (Exception e) {
            logger.error("Eroare la listarea studentilor: " + e.getMessage());
        }


        try {
            logger.info("Listarea studentilor ordonați dupa data nasterii...");
            repository.listStudentsOrderByLastNameOrBirthDate("birthdate").forEach(student ->
                    logger.info(student.getFirstName() + " " + student.getLastName() + " - " + student.getDateOfBirth()));
        } catch (Exception e) {
            logger.error("Eroare la listarea studentilor: " + e.getMessage());
        }
    }
}