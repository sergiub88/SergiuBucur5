package edu.scoalainformala.HomeWork11;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(5000);
                if (!gate.getTicketsQueue().isEmpty()) {
                    generateStatistics();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateStatistics() {
        System.out.println("\nStatistics:");
        long total = gate.getTicketsQueue().size();
        System.out.println(total + " people entered");

        for (TicketType type : TicketType.values()) {
            long count = gate.getTicketsQueue().stream().filter(t -> t == type).count();
            System.out.println(count + " have " + type.toString().toLowerCase().replace("_", " ") + " tickets");
        }
    }
}