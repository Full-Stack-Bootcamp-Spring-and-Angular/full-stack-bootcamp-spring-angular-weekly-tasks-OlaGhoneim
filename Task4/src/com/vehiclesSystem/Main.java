package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container=new AnnotationConfigApplicationContext(Config.class);
        CarController carController=container.getBean( CarController.class);
        BikeController bikeController=container.getBean( BikeController.class);
        PlaneController planeController=container.getBean( PlaneController.class);



        Car car =container.getBean(Car.class);
       car.setBrand("Toyta");
       car.setType(Type.Car );
       carController.saveVehicle(car);

        Bike bike=container.getBean(Bike.class);
        bike.setBrand("Scott");
        bike.setType(Type.Bike);
       bikeController.saveVehicle(bike);


        Plane plane=container.getBean(Plane.class);
        plane.setBrand("Airbus");
        plane.setType(Type.Plane);
       planeController.saveVehicle(plane);

       System.out.println("All vehicles have been saved");
       List<Vehicle> vehicles= planeController.getVehicles();
        for (Vehicle v : vehicles) {
            System.out.println("ID: " + v.getId());
            System.out.println("Brand: " + v.getBrand());
            System.out.println("Type: " + v.getType());
            System.out.println("*****************************");
        }


        ((AnnotationConfigApplicationContext) container).close();






    }
}