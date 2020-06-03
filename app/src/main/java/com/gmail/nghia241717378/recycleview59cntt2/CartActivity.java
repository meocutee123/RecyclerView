package com.gmail.nghia241717378.recycleview59cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.nghia241717378.controller.ICartController;
import com.gmail.nghia241717378.model.Product;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    TextView txtProduct;
    ICartController iCartController;
    Button btnDelete, btnPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        iCartController = (ICartController)getApplication();
        addViews();
        addEvents();
        placeOrder();
    }

    private void placeOrder() {
        btnPlace = findViewById(R.id.btnPlace);
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCartController.clearShoppingCart();
                Intent intent = new Intent(CartActivity.this, ConfirmActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addEvents() {
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearShoppingCart();
            }
        });
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

   private void clearShoppingCart(){
        iCartController.clearShoppingCart();
       Toast.makeText(getApplicationContext(), "Đã xóa!", Toast.LENGTH_SHORT).show();
       displayShoppingCart();
   }
}
