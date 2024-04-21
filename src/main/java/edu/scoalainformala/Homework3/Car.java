package edu.scoalainformala.Homework3;

public abstract class Car implements Vehicle {
    protected final int fuelTankSize;
    protected final String fuelType;
    protected final int gears;
    protected final double consumptionPer100Km;
    protected double availableFuel;
    protected int tireSize;
    protected final String chassisNumber;

    public Car(int fuelTankSize, String fuelType, int gears, double consumptionPer100Km, double availableFuel, int tireSize, String chassisNumber) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.gears = Math.min(gears, 6);
        this.consumptionPer100Km = consumptionPer100Km;
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.chassisNumber = chassisNumber;
    }

    public abstract void shiftGear(int gear);

    public abstract float getAvailableFuel();
    public abstract float getAverageFuelConsumption();
}