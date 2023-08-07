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

public class Diani extends AppCompatActivity {

    private List<String> reviewsList;
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diani);

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
        addReview("Hannah Oio", "Diani Beach is close to popular spots for dolphin watching, providing a chance to see these beautiful creatures in their natural habitat.!", 4.0f);
        addReview("Yunis Makoy", " Travelers often praised the availability of delicious local cuisine, including fresh seafood dishes, at restaurants and eateries near the beach", 5.0f);
        addReview("Avy Daren", " Diani Beach is known for its pristine white sands and clear turquoise waters", 4.0f);
        addReview("Ouyg Yugis", "Diani Beach was an absolute paradise", 4.0f);
        addReview("Dada Musa", "What an incredible experience at Diani Beach!", 4.0f);
        addReview("Moki Yunis", "I had an amazing time at Diani Beach with my family.", 4.0f);


        VideoView videoView = findViewById(R.id.vvAttractionVideo);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dianib);
        videoView.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();
    }
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void addReview(String author, String reviewText, float rating) {
        reviewsList.add(author + ": " + reviewText);
        reviewAdapter.notifyDataSetChanged();
        float newAverageRating = calculateAverageRating(rating);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(newAverageRating);
    }

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
                    e.printStackTrace();
                }
            }
        }

        return (totalRating + newRating) / (numReviews + 1);
    }
}
