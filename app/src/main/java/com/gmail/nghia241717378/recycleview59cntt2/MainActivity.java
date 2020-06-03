package com.gmail.nghia241717378.recycleview59cntt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.nghia241717378.controller.CartController;
import com.gmail.nghia241717378.controller.ICartController;
import com.gmail.nghia241717378.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private List<Product> productList;
    private RecyclerView recyclerView;
    private Adapter adapter;
    ICartController iCartController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rvDSMatHang);
        addControl();
        addEvent();
    }



    private class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView txtName, txtPrice, txtDescription;
        ImageView imgCart;
        Product product;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtNameSP);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDescription = this.itemView.findViewById(R.id.txtDescription);
            imgCart = this.itemView.findViewById(R.id.imgCart);
            imgCart.setOnClickListener(this);


        }
        @SuppressLint("SetTextI18n")
        void bind(Product p){

            this.product = p;
            txtName.setText(p.getName());
            txtPrice.setText(Integer.valueOf(p.getPrice()).toString());
            txtDescription.setText(p.getDescription());
        }

        @Override
        public void onClick(View v) {
        if (iCartController.addToCart(product)){
            Toast.makeText(MainActivity.this,"Added: "+ product.getName() + " into shopping cart", Toast.LENGTH_SHORT).show();
            }
        else {
            Toast.makeText(MainActivity.this,product.getName() + " already have!", Toast.LENGTH_SHORT).show();
            }
         }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mnu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnuClose: finish();
            case R.id.mnuCart: showCart(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showCart() {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    private class Adapter extends RecyclerView.Adapter<ProductViewHolder>{
        List<Product> productList;

        Adapter(List<Product> productList) {
            this.productList = productList;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
            holder.bind(productList.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), holder.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

    }
    private void addControl(){
        recyclerView = findViewById(R.id.rvDSMatHang);
        productList = new ArrayList<>();
        iCartController = (ICartController) getApplication();
        productList = iCartController.getAllProduct();
        adapter = new Adapter(productList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    private void addEvent() {
        CartController cartController = new CartController();
        productList = cartController.getAllProduct();
        adapter.notifyDataSetChanged();
    }
}
