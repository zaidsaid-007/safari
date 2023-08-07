package com.example.safariguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safariguide.Adapter.ReviewAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class Hellsgate extends AppCompatActivity {

    private List<String> reviewsList;
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellsgate);

        // Initialize the reviews list and RecyclerView
        reviewsList = new ArrayList<>();
        recyclerView = findViewById(R.id.galleryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewAdapter = new ReviewAdapter(reviewsList);
        recyclerView.setAdapter(reviewAdapter);

        // Set click listeners for the buttons
        MaterialButton btnNavigate = findViewById(R.id.btnNavigate);
        btnNavigate.setOnClickListener(v -> openLink(getString(R.string.navigate_link)));

        MaterialButton btnWebsite = findViewById(R.id.btnWebsite);
        btnWebsite.setOnClickListener(v -> openLink(getString(R.string.website_link)));

        MaterialButton btnContact = findViewById(R.id.btnContact);
        btnContact.setOnClickListener(v -> openLink(getString(R.string.contact_link)));

        // Add some sample reviews (you can add real reviews here from an API or database)
        addReview("Kilonzo John", "This is a great place!", 4.0f);
        addReview("Omondi Tubi", "Hell's Gate was an incredible experience! The landscapes were unlike anything I've seen before. ", 4.5f);
        addReview("Juma Opal", "As a nature photographer, Hell's Gate was a dream come true. ", 3.5f);
        addReview("Abdi Obare", "I had an incredible day at Hell's Gate. The scenery was breathtaking, and the rock formations were mind-blowing.", 4.0f);
        addReview("Atieno J.Michael", "Hell's Gate offers a refreshing change from the typical game drives. The ability to explore on foot allowed us to feel connected to nature and appreciate the smaller details. The Fischer's Tower was impressive, and we even saw rock climbers attempting to conquer it. The park's tranquility and stunning landscapes make it a great place to unwind and forget about the hustle and bustle of everyday life.", 4.0f);
        addReview("Rubi Dire", "Hell's Gate is a hidden gem among Kenya's national parks", 2.0f);
        addReview("Hannah Horei", "I fell in love with Hell's Gate! The fact that you can walk and cycle through the park made it such a unique and intimate experience with nature.", 3.0f);
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    // Method to simulate adding reviews
    private void addReview(String author, String reviewText, float rating) {
        reviewsList.add(author + ": " + reviewText);
        reviewAdapter.notifyDataSetChanged();
        // Calculate the new average rating and update the RatingBar
        float newAverageRating = calculateAverageRating(rating);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(newAverageRating);
    }

    // Helper method to calculate the average rating based on new review rating
    // Helper method to calculate the average rating based on new review rating
    private float calculateAverageRating(float newRating) {
        float totalRating = 0;
        int numReviews = reviewsList.size();

        for (String review : reviewsList) {
            String[] parts = review.split(": ");
            if (parts.length >= 2) {
                try {
                    float rating = Float.parseFloat(parts[1]);
                    totalRating += rating;
                } catch (NumberFormatException e) {
                    // Handle invalid rating format gracefully (skip this review)
                    e.printStackTrace();
                }
            }
        }

        return (totalRating + newRating) / (numReviews + 1);
    }
}
