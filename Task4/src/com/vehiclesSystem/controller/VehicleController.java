package com.vehiclesSystem.controller;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;


public interface VehicleController {

    public void saveVehicle(Vehicle vehicle);
    public List<Vehicle> getVehicles();
}
