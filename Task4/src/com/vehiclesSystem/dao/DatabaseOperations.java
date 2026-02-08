package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseOperations {
    Connection connection;

    @Value("${database.url}")
    String url;
@Value("${database.username}")
    String username;
    @Value("${database.password}")
    String password;

    @PostConstruct
    public void connectToDatabase() {
    try {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database");
    } catch (SQLException e) {
        throw new RuntimeException(e);

    }
    }
    @PreDestroy
    public void disconnectFromDatabase() {
     try {
         if(connection != null && !connection.isClosed()) {
             connection.close();
         }
     } catch (SQLException e) {
         System.err.println("Failed to close database connection");

         throw new RuntimeException(e);
     }
    }
    public void save( Vehicle vehicle) {
      String sql ="insert into vehicle (brand,type) values (?,?)";
      try(PreparedStatement ps =connection.prepareStatement(sql)){
         ps.setString(1,vehicle.getBrand());
         ps.setString(2,vehicle.getType().name());
         ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }
    public void delete( Vehicle vehicle) {
        int id = vehicle.getId();
     String sql="delete from vehicle where id=? ";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
          ps.setInt(1,id);
          ps.executeUpdate();
          System.out.println("successfully deleted vehicle");


      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }

    public void update( Vehicle vehicle) {
    String sql="Update vehicle set brand=?, type=? where id=?";
    try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setString(1,vehicle.getBrand());
        ps.setString(2,vehicle.getType().name());
        ps.setInt(3,vehicle.getId());
        ps.executeUpdate();
        System.out.println("successfully updated vehicle");
    }
    catch (SQLException e){
        throw new RuntimeException(e);
    }
    }
    public  Vehicle  SearchById( Vehicle vehicle) {
     String sql="select *from vehicle where id=?";
     try(PreparedStatement ps=connection.prepareStatement(sql)){
         ps.setInt(1,vehicle.getId());
         ResultSet result=ps.executeQuery();
        if(result.next()) {
            String type = result.getString("type");

            vehicle.setId(result.getInt("id"));
            vehicle.setType(Type.valueOf(result.getString("type")));
            vehicle.setBrand(result.getString("brand"));
        }


         return vehicle;
     }
     catch (SQLException e){
         throw new RuntimeException(e);
     }
    }

    public List<Vehicle>getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        String sql= "select * from vehicle";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
           ResultSet result=ps.executeQuery();
            while(result.next()){
             String type= result.getString("type");
             Vehicle vehicle = null;
             if(type.equals("Plane")){
                  vehicle = new Plane();

             }
             else if(type.equals("Bike")){
                  vehicle = new Bike();
             }
             else if(type.equals("Car")){
                  vehicle = new Car();
             }
             vehicle.setId(result.getInt("id"));
             vehicle.setType(Type.valueOf(result.getString("type")));
             vehicle.setBrand(result.getString("brand"));
                vehicles.add(vehicle);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
}
//1-establish connection
//2-prepare sql query
//3-inject string sql in statemnt
//set values
//4-execute statemnt
//5-close connection
