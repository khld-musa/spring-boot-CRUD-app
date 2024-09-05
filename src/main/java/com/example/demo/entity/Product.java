package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    @NotNull(message = "Product quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;
}
