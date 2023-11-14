package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendForm {

    private String purposeRestaurant;
    private String purposeCafe;
    private String purposePub;
    private int priceLow;
    private int priceHigh;

}
