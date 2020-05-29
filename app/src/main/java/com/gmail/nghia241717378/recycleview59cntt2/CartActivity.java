package com.gmail.nghia241717378.recycleview59cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.gmail.nghia241717378.controller.ICartController;
import com.gmail.nghia241717378.model.Product;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    TextView txtProduct;
    ICartController iCartController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        iCartController = (ICartController)getApplication();
        addViews();
    }

    private void addViews() {
        txtProduct = findViewById(R.id.txtProduct);
        displayShoppingCart();
    }

    private void displayShoppingCart() {
        List<Product> shoppingCart;
        shoppingCart = iCartController.getShoppingCart();
        StringBuilder stringBuilder = new StringBuilder();
        for(Product product : shoppingCart){
            stringBuilder.append(product.getName()).append(product.getPrice()).append(product.getDescription())
                    .append("\n");
        }
        if(stringBuilder.length()>0){
            txtProduct.setText(stringBuilder.toString());
        }
        else {
            txtProduct.setText("Emty");
        }
    }
}
