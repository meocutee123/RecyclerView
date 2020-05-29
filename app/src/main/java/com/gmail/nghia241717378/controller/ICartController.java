package com.gmail.nghia241717378.controller;

import com.gmail.nghia241717378.model.Product;

import java.util.List;

public interface ICartController {
    List<Product> getAllProduct();
    public boolean addToCart(Product product);
    public List<Product> getShoppingCart();
    public void clearShoppingCart();
}
