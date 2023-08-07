package com.example.safariguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safariguide.Adapter.ReviewAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class Tsavo extends AppCompatActivity {

    private List<String> reviewsList;
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsavo);

        // Initialize the reviews list and RecyclerView
        reviewsList = new ArrayList<>();
        recyclerView = findViewById(R.id.galleryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewAdapter = new ReviewAdapter(reviewsList);
        recyclerView.setAdapter(reviewAdapter);

        MaterialButton btnNavigate = findViewById(R.id.btnNavigate);
        btnNavigate.setOnClickListener(v -> openLink(getString(R.string.navigate_link)));

        MaterialButton btnWebsite = findViewById(R.id.btnWebsite);
        btnWebsite.setOnClickListener(v -> openLink(getString(R.string.website_link)));

        MaterialButton btnContact = findViewById(R.id.btnContact);
        btnContact.setOnClickListener(v -> openLink(getString(R.string.contact_link)));

        addReview("Maria Kim", "A breathtaking summit experience with stunning views all around", 3.0f);
        addReview("Uyt Qwei", "Difficult and challenging terrain, not recommended for inexperienced hikers", 1.0f);
        addReview("Qawer Awwe", "Knowledgeable guides and porters ensured a safe and enjoyable climb", 3.0f);
        addReview("Judi Wert", "High-altitude effects can be taxing on the body; acclimatization is crucial.", 1.0f);
        addReview("Opp tyui", "Difficult and challenging terrain, not recommended for inexperienced hikers.", 2.0f);
        addReview("Rtu Opi", "A sense of accomplishment after reaching the summit, an amazing journey", 4.5f);
        addReview("Werv ni", "The diverse landscapes and wildlife sightings made for an unforgettable trek", 3.0f);
        addReview("Hoi huji", "Some trails poorly marked, requiring careful navigation", 2.8f);

        VideoView videoView = findViewById(R.id.vvAttractionVideo);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.masaimara);
        videoView.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Start the video playback
        videoView.start();
    }

    // Method to open a link in a web browser or a map application
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
