package com.adminPanel.app.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private long id;



    @Column
    private String name;


    @NotNull(message = "Expiration date is required")
    @Column(name = "expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date expirationDate;

    @Column(name= "manufacturer")
    private String manufacturer;


    @Column
    private double price;

    @Column
    private boolean available;

    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;




}
