package com.example.safariguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Hotels extends AppCompatActivity {

    MaterialCardView master,master1,master2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        master = findViewById(R.id.master);
        master1 = findViewById(R.id.master2);
        master2 = findViewById(R.id.master3);


        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotels.this,Book.class);
                intent.putExtra("name","Master");
                intent.putExtra("price",50000);
                startActivity(intent);
            }
        });

        master1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotels.this,Book.class);
                intent.putExtra("name","Single");
                intent.putExtra("price",25000);
                startActivity(intent);
            }
        });

        master2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotels.this,Book.class);
                intent.putExtra("name","Double");
                intent.putExtra("price",35000);
                startActivity(intent);
            }
        });
    }
}