package edu.scoalainformala.HomeWork8;

import java.util.Comparator;


public class ResultComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
        return Integer.compare(a1.getTotalTimeInSeconds(), a2.getTotalTimeInSeconds());
    }
}