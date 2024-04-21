package edu.scoalainformala.HomeWork11;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private final ConcurrentLinkedQueue<TicketType> ticketsQueue = new ConcurrentLinkedQueue<>();

    public void addTicket(TicketType ticketType) {
        ticketsQueue.add(ticketType);
    }

    public ConcurrentLinkedQueue<TicketType> getTicketsQueue() {
        return ticketsQueue;
    }
}