package edu.scoalainformala.Homework3;

public class Logan extends Dacia {
    public Logan(double availableFuel, String chassisNumber) {
        super(50, "PETROL", availableFuel, 15, chassisNumber);
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
        return (float)(this.consumptionPer100Km * (1 + 0.04 * (this.tireSize - 15)));
    }
}







