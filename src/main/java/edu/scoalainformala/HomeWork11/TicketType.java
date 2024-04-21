package edu.scoalainformala.HomeWork11;

public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    public static TicketType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
