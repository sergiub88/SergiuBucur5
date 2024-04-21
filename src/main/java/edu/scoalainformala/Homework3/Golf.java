package edu.scoalainformala.Homework3;

public class Golf extends Vw {
    public Golf(double availableFuel, String chassisNumber) {
        super(55, "DIESEL", availableFuel, 17, chassisNumber);
    }

    @Override
    public void shiftGear(int gear) {
        System.out.println("Shifting to gear " + gear);
    }

    @Override
    public float getAvailableFuel() {
        return (float)this.availableFuel;
    }

    @Override
    public float getAverageFuelConsumption() {
        return (float)(this.consumptionPer100Km * (1 + 0.03 * (this.tireSize - 15)));
    }
}