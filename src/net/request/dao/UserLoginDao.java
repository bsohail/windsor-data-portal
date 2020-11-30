package net.request.dao;
 
import java.sql.*;
import net.request.model.Employee;
public class UserLoginDao {
 
    public Employee checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/admin";
        String dbUser = "root";
        String dbPassword = "2512";
        //connecting to mysql database
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        //sql query to get the username and password and to check if the credentials are correct
        String sql = "SELECT * FROM user WHERE username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //setting username and password 
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Employee user = null;
        
        if (result.next()) {
            user = new Employee();
            user.setFirstName(result.getString("firstname"));
            user.setUsername(email);
        }
 
        connection.close();
 
        return user;
    }
}