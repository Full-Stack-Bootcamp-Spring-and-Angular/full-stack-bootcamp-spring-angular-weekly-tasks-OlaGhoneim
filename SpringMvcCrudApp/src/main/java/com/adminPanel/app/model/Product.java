package com.adminPanel.app.model;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @Column
    private String name;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProductDetails productDetails;
}
