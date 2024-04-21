package edu.scoalainformala.HomeWork8;

import java.util.List;
import java.util.stream.Collectors;

public class BiathlonService {
    public static List<Athlete> determineStandings(List<Athlete> athletes) {
        return athletes.stream()
                .sorted(new ResultComparator())
                .collect(Collectors.toList());
    }
}
