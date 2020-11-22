package ua.iot.lviv.persistant;

import java.sql.*;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/s3_db_lab_4?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "student";
    private static final String PASSWORD = "1234";

    private static Connection connection = null;

    public ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        return connection;
    }
//
//    public static void closeStatement(Statement statement) {
//        if (statement != null) {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                System.out.println("SQLException: " + e.getMessage());
//                System.out.println("SQLState: " + e.getSQLState());
//                System.out.println("VendorError: " + e.getErrorCode());
//            }
//        }
//    }
//
//    public static void closeResultSet(ResultSet resultSet) {
//        if (resultSet != null) {
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                System.out.println("SQLException: " + e.getMessage());
//                System.out.println("SQLState: " + e.getSQLState());
//                System.out.println("VendorError: " + e.getErrorCode());
//            }
//        }
//    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
    }
}
