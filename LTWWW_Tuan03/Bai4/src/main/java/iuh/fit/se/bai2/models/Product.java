package iuh.fit.se.bai2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String model;
    private String description;
    private double price;
    private String imgURL;
}
