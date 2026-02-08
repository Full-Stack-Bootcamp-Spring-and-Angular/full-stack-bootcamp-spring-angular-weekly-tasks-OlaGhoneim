package com.vehiclesSystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class Plane implements Vehicle{

    int id;
    String brand;
    Type type;


}

