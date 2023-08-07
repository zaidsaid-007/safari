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

public class Masaaimara extends AppCompatActivity {

    private List<String> reviewsList;
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masaaimara);

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
        addReview("Kunei Oki", "A wildlife lover's dream come true! Masai Mara National Park is a true safari paradise.", 4.0f);
        addReview("Ian Onana", "Amazing views and wildlife!", 5.0f);
        addReview("Uiop Riop", "Masai Mara was a bit of a letdown for us. The wildlife encounters were few and far between, and our guide seemed disinterested in finding the best sightings. The lack of proper communication equipment meant we missed out on potential sightings, and it was frustrating.", 1.0f);
        addReview("Aoop uui", "Masai Mara didn't live up to the hype for us. We had high expectations for wildlife sightings, but unfortunately, we saw very few animals during our safari. The vast savannah made it challenging to spot wildlife, and we often felt disappointed. The accommodations were basic, and the heat during the day was overwhelming. It's a hit-or-miss destination, so be prepared for the possibility of a less eventful safari.", 2.5f);
        addReview("Quio Hui", "Masai Mara stole my heart! The Maasai guides were incredibly knowledgeable and passionate about their land and culture. ", 4.0f);
        addReview("Yui wiyu", "Masai Mara was like stepping into a wildlife documentary. The sheer abundance of animals is mind-boggling. ", 2.0f);
        addReview("Jik r3u", "Masai Mara is a wildlife photographer's paradise! The diversity of animals and landscapes made every shot unique.", 3.0f);
        addReview("Io luke", "Masai Mara is a world of wonders. We enjoyed watching elephants bathing in the river and got some incredible shots of the majestic African sunset. ", 4.0f);
        addReview("WAdi qutr", "A safari like no other! Masai Mara's abundant wildlife surpassed our wildest expectations. We were spellbound by the massive herds of elephants and wildebeests stretching to the horizon. The Masai guides' cultural insights added a deeper understanding of the park's significance. ", 4.0f);
        addReview("Abdullaki wat", "Masai Mara's natural beauty is simply awe-inspiring. From the picturesque landscapes to close encounters with lions, we were immersed in the heart of the wild. The Masai village visit was a humbling experience, learning about their customs and survival skills.", 2.0f);
        addReview("Wrty ioppi", "Loved the elephants!", 4.0f);

        // Get the VideoView from the layout
        VideoView videoView = findViewById(R.id.vvAttractionVideo);

        // Set the video URI (Replace "video_uri" with the actual video URI)
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.masaimara);
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
