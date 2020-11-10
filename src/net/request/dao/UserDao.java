package net.request.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.request.model.User;

public class UserDao {

    public int registerUser(User user) throws ClassNotFoundException {

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/info?allowPublicKeyRetrieval=true&useSSL=false", "root", "2512");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("insert into  info.data values (default, ?, ?, ?, ? , ?)")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCompanyName());
            preparedStatement.setString(4, user.getDescription());
            if (user.getFile() != null) {
            	preparedStatement.setBlob(5, user.getFile());
            }
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}