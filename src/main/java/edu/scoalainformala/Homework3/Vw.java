package edu.scoalainformala.Homework3;

public abstract class Vw extends Car {
    public Vw(int fuelTankSize, String fuelType, double availableFuel, int tireSize, String chassisNumber) {
        super(fuelTankSize, fuelType, 7, 6.0, availableFuel, tireSize, chassisNumber);
    }

    @Override
    public void start() {
        System.out.println("VW started.");
    }

    @Override
    public void stop() {
        System.out.println("VW stopped.");
    }

    @Override
    public void drive(double kilometers) {
        System.out.println("VW drives " + kilometers + " kms.");
    }
}

