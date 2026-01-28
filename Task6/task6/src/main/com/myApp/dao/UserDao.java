package main.com.myApp.dao;

import main.com.myApp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class UserDao {

    @Autowired
    private DataSource dataSource;

    public int save(UserModel user) {
        int status = 0;

        String sql = "INSERT INTO registration " +
                "(username,email, password) " +
                "VALUES (?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
