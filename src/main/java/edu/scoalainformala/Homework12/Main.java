package edu.scoalainformala.Homework12;

public class Main {
    public static void main(String[] args) {
        try {

            DatabaseUtil dbUtil = new DatabaseUtil();


            dbUtil.insertAccommodation("Single", "Single Bed", 1, "A single room with one bed for one person.");
            dbUtil.insertAccommodation("Double", "Double Bed", 2, "A double room with one large bed for two people.");


            dbUtil.insertRoomFair(100.0, "Low");
            dbUtil.insertRoomFair(150.0, "High");


            dbUtil.insertRelation(1, 1);
            dbUtil.insertRelation(2, 2);


            dbUtil.printRoomPrices();

        } catch (Exception e) {
            System.out.println("Error during database operations: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
