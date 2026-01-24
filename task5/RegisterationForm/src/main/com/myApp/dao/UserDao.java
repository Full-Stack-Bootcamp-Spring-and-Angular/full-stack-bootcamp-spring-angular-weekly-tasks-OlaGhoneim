package main.com.myApp.dao;

import main.com.myApp.model.UserModel;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {

    private final String URL = "jdbc:mysql://localhost:3306/regestration";
    private final String USER = "root";
    private final String PASSWORD = "38326277";

    public int save(UserModel user) {
        int status = 0;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Insert into registration table
            String sql = "INSERT INTO registration (first_name, last_name, email, dob, city) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setDate(4, Date.valueOf(user.getDateOfBirth())); // dob as yyyy-mm-dd
            ps.setString(5, user.getCity());

            status = ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
