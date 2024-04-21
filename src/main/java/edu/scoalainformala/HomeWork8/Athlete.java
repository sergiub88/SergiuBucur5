package edu.scoalainformala.HomeWork8;

public class Athlete {
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private int totalPenaltySeconds;


    public Athlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.totalPenaltySeconds = 0;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public int getTotalPenaltySeconds() {
        return totalPenaltySeconds;
    }

    public void setTotalPenaltySeconds(int totalPenaltySeconds) {
        this.totalPenaltySeconds = totalPenaltySeconds;
    }

    public void addPenaltySeconds(int penaltySeconds) {
        this.totalPenaltySeconds += penaltySeconds;
    }

    public int getTotalTimeInSeconds() {
        String[] parts = this.skiTimeResult.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return (minutes * 60 + seconds) + this.totalPenaltySeconds;
    }
}
