package com.example.angularmockproject.products;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    Long productId;
    String productName;
    String productCode;
    String releaseDate;
    Float price;
    String description;
    Float starRating;
    String imageUrl;
}
