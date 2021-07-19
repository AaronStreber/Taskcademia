package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taskcademia.R;

public class FoodAct extends AppCompatActivity {
    private Button mcMarket;
    private Button soleil;
    private Button chickFilA;
    private Button caliente;
    private Button tetonGrill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layout);
        mcMarket = findViewById(R.id.McMarket);
        soleil = findViewById(R.id.Soleil);
        chickFilA = findViewById(R.id.loginbtn2);
        caliente = findViewById(R.id.Caliente);
        tetonGrill = findViewById(R.id.TetonGrill);

        mcMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.byui.edu/university-services/food-services/food-venues/mc-market");
            }
        });
        soleil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.byui.edu/university-services/food-services/food-venues/soleil");
            }
        });
        chickFilA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.byui.edu/university-services/food-services/food-venues/chick-fil-a");
            }
        });
        caliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.byui.edu/university-services/food-services/food-venues/caliente");
            }
        });
        tetonGrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.byui.edu/university-services/food-services/food-venues/teton-grill");
            }
        });
    }

    private void goToUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

}