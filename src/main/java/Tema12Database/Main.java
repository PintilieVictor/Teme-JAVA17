package Tema12Database;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/booking_db";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            createTables(connection);
            insertData(connection);
            printRoomPrices(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // Create the accommodation table
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS accommodation (" +"id INT PRIMARY KEY, " + "type VARCHAR(32), " +
                            "bed_type VARCHAR, " + "max_guests INT, " + "description VARCHAR");

            // Create the room_fair table
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS room_fair (" + "id INT PRIMARY KEY, " + "value DOUBLE, " + "season VARCHAR(32))");

            // Create the accommodation_room_fair_relation table
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS accommodation_room_fair_relation (" + "id INT PRIMARY KEY, " +
                            "accommodation_id INT, " + "room_fair_id INT, "
                            + "FOREIGN KEY (accommodation_id) REFERENCES accommodation(id), " + "FOREIGN KEY (room_fair_id) REFERENCES room_fair(id))");
        }
    }

    public static void insertData(Connection connection) throws SQLException {
        // Insert data into accommodation and room_fair tables
        try (PreparedStatement accommodationInsert = connection.prepareStatement(
                "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)");
             PreparedStatement roomFairInsert = connection.prepareStatement(
                     "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)")) {

            accommodationInsert.setInt(1, 1);
            accommodationInsert.setString(2, "Standard");
            accommodationInsert.setString(3, "Double");
            accommodationInsert.setInt(4, 2);
            accommodationInsert.setString(5, "Cozy room with a view.");
            accommodationInsert.executeUpdate();

            roomFairInsert.setInt(1, 1);
            roomFairInsert.setDouble(2, 150.0);
            roomFairInsert.setString(3, "Off-Peak");
            roomFairInsert.executeUpdate();
        }

        try (PreparedStatement relationInsert = connection.prepareStatement(
                "INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES")) {
            relationInsert.setInt(1, 1);
            relationInsert.setInt(2, 1);
            relationInsert.setInt(3, 1);
            relationInsert.executeUpdate();
        }
    }

    public static void printRoomPrices(Connection connection) throws SQLException {
        try (PreparedStatement query = connection.prepareStatement(
                "SELECT a.type, r.value " +
                        "FROM accommodation a " +
                        "JOIN accommodation_room_fair_relation arr ON a.id = arr.accommodation_id " +
                        "JOIN room_fair r ON arr.room_fair_id = r.id")) {
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                String accommodationType = resultSet.getString("type");
                double roomPrice = resultSet.getDouble("value");
                System.out.println("Accommodation Type: " + accommodationType + ", Room Price: " + roomPrice);
            }
        }
    }
}
