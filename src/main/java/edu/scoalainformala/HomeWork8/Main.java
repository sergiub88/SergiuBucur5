package edu.scoalainformala.HomeWork8;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/lpinf/IdeaProjects/SergiuBucur3/src/main/java/HomeWork8/csvData.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<Athlete> athletes = BiathlonResultParser.parseResults(lines);
            List<Athlete> standings = BiathlonService.determineStandings(athletes);


            for (int i = 0; i < Math.min(standings.size(), 3); i++) {
                Athlete athlete = standings.get(i);
                System.out.println((i + 1) + ". " + athlete.getAthleteName() + " - Total time: " + athlete.getTotalTimeInSeconds());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
