package edu.scoalainformala.HomeWork8;

import java.util.ArrayList;
import java.util.List;


public class BiathlonResultParser {

    public static List<Athlete> parseResults(List<String> lines) {
        List<Athlete> athletes = new ArrayList<>();

        for (String line : lines) {
            line = line.replace("\uFEFF", "");
            String[] parts = line.split(";");
            Athlete athlete = new Athlete(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    parts[3]
            );


            for (int i = 4; i <= 6; i++) {
                long misses = parts[i].chars().filter(ch -> ch == 'o').count();
                athlete.addPenaltySeconds((int)misses * 10);
            }

            athletes.add(athlete);
        }

        return athletes;
    }
}