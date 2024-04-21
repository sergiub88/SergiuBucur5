package edu.scoalainformala.HomeWork10;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;

public class FileHandlerTest {

    @Test
    public void testReadAndWrite() throws Exception {
        String testInputFile = "testInput.txt";
        String testOutputFile = "testOutput.txt";
        List<String> lines = List.of(
                "John,Doe,1990-05-15",
                "Jane,Doe,1990-06-25"
        );
        Files.write(Paths.get(testInputFile), lines);

        FileHandler.filterAndWriteByMonth(testInputFile, 5, testOutputFile);
        List<String> outputLines = Files.readAllLines(Paths.get(testOutputFile));
        assertEquals(1, outputLines.size());
        assertEquals("John, Doe", outputLines.get(0));

        Files.deleteIfExists(Paths.get(testInputFile));
        Files.deleteIfExists(Paths.get(testOutputFile));
    }
}