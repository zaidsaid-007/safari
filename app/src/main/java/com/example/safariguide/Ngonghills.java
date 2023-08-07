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

public class Ngonghills extends AppCompatActivity {

    private List<String> reviewsList;
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngonghills);

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

        // Add some sample reviews (you can add real reviews here from an API or database)
        addReview("Aisha Lopez", "This is a great place!", 3.0f);
        addReview("Ian Onana", "Amazing views and wildlife!", 2.0f);
        addReview("Zakayo Musa", "Opportunity to visit local Maasai communities and learn about their traditions.", 2.8f);
        addReview("Otieno Anny", "Diverse species, including elephants, lions, giraffes, and more", 3.0f);
        addReview("Huda Musa", "Efforts to preserve the ecosystem and protect endangered species", 1.8f);
        addReview("Hafsa Abdi", "I appreciate the conservation efforts in the park, aimed at preserving the delicate ecosystem and protecting endangered species", 5.0f);

        // Get the VideoView from the layout
        VideoView videoView = findViewById(R.id.vvAttractionVideo);

        // Set the video URI (Replace "video_uri" with the actual video URI)
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vdl1);
        videoView.setVideoURI(videoUri);

        // Create a MediaController for video playback control
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
