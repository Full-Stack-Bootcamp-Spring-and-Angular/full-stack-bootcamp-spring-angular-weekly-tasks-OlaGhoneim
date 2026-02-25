package com.adminPanel.app.model;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;



@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_details")
public class ProductDetails {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column
     private Integer id;


    @NotBlank(message = "Name is required")
    @Column
    private String name;


    @NotNull(message = "Expiration date is required")
    @Column(name = "expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date expirationDate;

    @NotBlank(message = "Manufacturer is required")
    @Column(name= "manufacturer")
    private String manufacturer;

    @Min(value = 0, message = "Price must be positive")
    @Column
    private double price;

    @Column
    private boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;




}
