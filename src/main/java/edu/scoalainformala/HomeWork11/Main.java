package edu.scoalainformala.HomeWork11;

public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.getRandom();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
        }
    }
}