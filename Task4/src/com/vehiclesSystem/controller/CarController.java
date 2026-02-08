package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarController implements VehicleController{

    @Autowired
    DatabaseOperations db;
    public void saveVehicle(Vehicle vehicle){

        db.save(vehicle);
    }
    @Override
    public List<Vehicle> getVehicles(){
        return db.getAllVehicles();
    }
}
