package com.geekster.ECommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer productQuantity;


    @ManyToOne(cascade = CascadeType.ALL)
    private Users orderUser;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product orderProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address orderAddress;
}
