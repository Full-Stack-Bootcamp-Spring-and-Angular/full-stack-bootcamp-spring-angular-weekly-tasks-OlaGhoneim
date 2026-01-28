package main.com.myApp.controller.Entity;

import javax.persistence.*;
import java.util.Date;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name="products")

public class Product {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(
            name = " product_id"
    )
    private int id;

    private String name;
    private String description;
    private int price;
    private int stock_quantity;
    private String   manufacturer;

    @Temporal( TemporalType.TIME)
    private Date production_date;



    public Product() {}

    public Product(String name, String description, int price, int stock_quantity, String manufacturer, Date production_date) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.manufacturer = manufacturer;
        this.production_date = production_date;

    }

}
