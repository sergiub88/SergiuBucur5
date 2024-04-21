package edu.scoalainformala.Homework3;

public class Main {
    public static void main(String[] args) {

        Logan logan = new Logan(27, "wigh0934hkkadsn");
        Golf Golf = new Golf(30, "1987ddjbk7867876");


        logan.start();
        logan.shiftGear(1);
        logan.drive(0.01);
        logan.shiftGear(2);
        logan.drive(0.02);
        logan.shiftGear(3);
        logan.drive(0.5);
        logan.shiftGear(4);
        logan.drive(1.5);
        logan.shiftGear(5);
        logan.drive(10);
        logan.stop();


        System.out.println("Logan available fuel: " + logan.getAvailableFuel() + " liters");
        System.out.println("Logan average fuel consumption: " + logan.getAverageFuelConsumption() + " liters/100km");


        Golf.start();
        Golf.drive(1);
        Golf.stop();


        System.out.println("Golf available fuel: " + Golf.getAvailableFuel() + " liters");
        System.out.println("Golf average fuel consumption: " + Golf.getAverageFuelConsumption() + " liters/100km");


        Car car = Golf;
        car.start();
        car.drive(1);
        car.stop();


        System.out.println("Car (Golf) available fuel: " + ((Car) car).getAvailableFuel() + " liters");
        System.out.println("Car (Golf) fuel consumed per 100Km: " + ((Car) car).getAverageFuelConsumption() + " liters/100km");
    }
}
