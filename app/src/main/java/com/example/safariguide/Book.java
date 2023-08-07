package com.example.safariguide;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Book extends AppCompatActivity {

    TextView name;
    TextView price;
    EditText quantity;
    int nights;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);

        name.setText(getIntent().getExtras().getString("name") + "Bed");
        price.setText("Price:  "+ getIntent().getExtras().getInt("price"));
        this.nights = Integer.parseInt(quantity.getText().toString());

    }

    public void book(View view) {
        this.nights = Integer.parseInt(quantity.getText().toString());
        Toast.makeText(this, "Your Booking has been Registered" + this.nights, Toast.LENGTH_SHORT).show();

        String book = getIntent().getExtras().getString("name")+" bed for "+this.nights+", worth "+getIntent().getExtras().getInt("price")*this.nights+"";
        MainActivity.Booked = book;
    }

    public void checkBooking(View view) {
        Toast.makeText(this, MainActivity.Booked, Toast.LENGTH_SHORT).show();
    }
}