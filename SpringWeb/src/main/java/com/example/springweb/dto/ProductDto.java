package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;

    private Long code_sell;

    private String name;

    private Long price;

    private int quantity;

    private String image;

    private  int timeInsurance;

}
