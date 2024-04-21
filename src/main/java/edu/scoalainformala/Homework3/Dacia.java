package edu.scoalainformala.Homework3;

public abstract class Dacia extends Car {
    public Dacia(int fuelTankSize, String fuelType, double availableFuel, int tireSize, String chassisNumber) {
        super(fuelTankSize, fuelType, 6, 5.0, availableFuel, tireSize, chassisNumber);
    }

    @Override
    public void start() {
        System.out.println("Dacia started.");
    }

    @Override
    public void stop() {
        System.out.println("Dacia stopped.");
    }

    @Override
    public void drive(double kilometers) {
        System.out.println("Dacia drives " + kilometers + " kms.");
    }
}
