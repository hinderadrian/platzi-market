package com.platzi.platzi_market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;
}
