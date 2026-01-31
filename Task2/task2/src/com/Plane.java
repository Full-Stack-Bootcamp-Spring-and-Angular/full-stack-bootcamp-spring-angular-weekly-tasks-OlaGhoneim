package com.config;
import com.Vehicle;
import com.config.DatabaseOperations;

public class Plane implements Vehicle
{

    public DatabaseOperations databaseOperations;

    private String brand;

    public Plane(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public void saveToDatabase(Vehicle vehicle)
    {
        databaseOperations.save(vehicle);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}
