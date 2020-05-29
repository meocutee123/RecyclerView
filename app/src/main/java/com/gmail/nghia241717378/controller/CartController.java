package com.gmail.nghia241717378.controller;

import android.app.Application;

import com.gmail.nghia241717378.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartController extends Application implements ICartController {
    List<Product> productList = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    public CartController() {
        productList.add(new Product("Khoai lang 20cm", 1000, "10cm ngang"));
        productList.add(new Product("Khoai tây 21cm", 2000, "20cm ngang"));
        productList.add(new Product("Khoai môn 22cm", 3000, "30cm ngang"));
        productList.add(new Product("Khoai sọ 23cm", 4000, "40cm ngang"));
        productList.add(new Product("Khoai tím 24cm", 5000, "50cm ngang"));
        productList.add(new Product("Chuối tây 24cm", 5000, "50cm ngang"));
        productList.add(new Product("Chuối ta 10cm", 5000, "2cm ngang"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public boolean addToCart(Product product) {
        if(shoppingCart.contains(product))
        {return false;}
        shoppingCart.add(product);
        return true;
    }

    @Override
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
