package edu.scoalainformala.HomeWork10;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String inputFile = args.length > 0 ? args[0] : "input.txt";
        int targetMonth = args.length > 1 ? Integer.parseInt(args[1]) : 5;
        String outputFile = args.length > 2 ? args[2] : "output.txt";


        String basePath = Paths.get("src", "main", "resources").toString();
        String inputFilePath = Paths.get(basePath, inputFile).toString();
        String outputFilePath = Paths.get(basePath, outputFile).toString();


        System.out.println("Input file path: " + inputFilePath);
        System.out.println("Output file path: " + outputFilePath);


        if (args.length != 3) {
            System.out.println("Usage: Main <inputFile> <targetMonth> <outputFile>");
        }


        try {
            FileHandler.filterAndWriteByMonth(inputFilePath, targetMonth, outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}