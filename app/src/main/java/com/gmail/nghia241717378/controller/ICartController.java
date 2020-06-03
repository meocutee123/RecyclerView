package com.gmail.nghia241717378.controller;

import com.gmail.nghia241717378.model.Product;

import java.util.List;

public interface ICartController {
    List<Product> getAllProduct();
    boolean addToCart(Product product);
    List<Product> getShoppingCart();
    void clearShoppingCart();
}
