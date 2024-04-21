package edu.scoalainformala.Homework12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
    private Connection connection;

    public DatabaseUtil() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public void insertAccommodation(String type, String bedType, int maxGuests, String description) throws SQLException {
        String sql = "INSERT INTO accommodation (type, bed_type, max_guests, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);
            statement.setString(2, bedType);
            statement.setInt(3, maxGuests);
            statement.setString(4, description);
            statement.executeUpdate();
        }
    }

    public void insertRoomFair(double value, String season) throws SQLException {
        String sql = "INSERT INTO room_fair (value, season) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, value);
            statement.setString(2, season);
            statement.executeUpdate();
        }
    }

    public void insertRelation(int accommodationId, int roomFairId) throws SQLException {
        String sql = "INSERT INTO accommodation_room_fair_relation (accommodation_id, room_fair_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, accommodationId);
            statement.setInt(2, roomFairId);
            statement.executeUpdate();
        }
    }

    public void printRoomPrices() throws SQLException {
        String sql = "SELECT a.type, rf.value FROM accommodation a " +
                "JOIN accommodation_room_fair_relation arr ON a.id = arr.accommodation_id " +
                "JOIN room_fair rf ON arr.room_fair_id = rf.id";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Room Type: " + resultSet.getString("type") + ", Price: " + resultSet.getDouble("value"));
            }
        }
    }
}