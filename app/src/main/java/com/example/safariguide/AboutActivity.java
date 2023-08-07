package com.example.safariguide;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Assuming you have a TextView in your 'activity_about.xml' layout with id 'textAppName'
        TextView textAppName = (TextView) findViewById(R.id.textAppName);
        textAppName.setText("MyApp");

        // Assuming you have a TextView in your 'activity_about.xml' layout with id 'textVersion'
        TextView textVersion = (TextView) findViewById(R.id.textVersion);
        textVersion.setText("Version 1.0");

        // Assuming you have a TextView in your 'activity_about.xml' layout with id 'textDescription'
        TextView textDescription = (TextView) findViewById(R.id.textDescription);
        textDescription.setText("Welcome to MyApp, the best app ever!");
    }
}
