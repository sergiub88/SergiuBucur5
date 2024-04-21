package edu.scoalainformala.HomeWork11;

public class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 200));
            gate.addTicket(ticketType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}