package com.gmail.nghia241717378.recycleview59cntt2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {
    TextView txtSumPrice;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        txtSumPrice = findViewById(R.id.txtSumPrice);
        int data = getIntent().getIntExtra("Price", 0);

        txtSumPrice.setText(String.valueOf(data));

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ConfirmActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
