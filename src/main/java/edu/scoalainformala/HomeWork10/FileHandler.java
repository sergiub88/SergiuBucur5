package edu.scoalainformala.HomeWork10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {

    public static List<Person> readFromFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .map(line -> line.split(","))
                .map(parts -> new Person(parts[0], parts[1], LocalDate.parse(parts[2], DateTimeFormatter.ISO_DATE)))
                .collect(Collectors.toList());
    }

    public static void writeToFile(List<Person> people, String filename) throws IOException {
        List<String> lines = people.stream()
                .map(p -> p.getFirstName() + ", " + p.getLastName())
                .collect(Collectors.toList());
        Files.write(Paths.get(filename), lines);
    }

    public static void filterAndWriteByMonth(String inputFilename, int month, String outputFilename) throws IOException {
        List<Person> filtered = readFromFile(inputFilename).stream()
                .filter(p -> p.getDateOfBirth().getMonthValue() == month)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
        writeToFile(filtered, outputFilename);
    }
}