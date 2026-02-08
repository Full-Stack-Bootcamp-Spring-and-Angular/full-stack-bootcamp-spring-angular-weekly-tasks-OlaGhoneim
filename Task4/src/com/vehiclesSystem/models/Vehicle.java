package com.vehiclesSystem.models;

public interface Vehicle {
    int getId();
    void setId(int id);
    String getBrand() ;
    Type getType();
    void setType(Type type);
    void setBrand(String brand);
}
