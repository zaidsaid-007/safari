package com.example.safariguide.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safariguide.R;
import com.example.safariguide.TourGuide;

import java.util.List;

public class TourGuideAdapter extends RecyclerView.Adapter<TourGuideAdapter.ViewHolder> {

    private List<TourGuide> tourGuides;
    private Context context;

    public TourGuideAdapter(List<TourGuide> tourGuides, Context context) {
        this.tourGuides = tourGuides;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour_guide, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TourGuide tourGuide = tourGuides.get(position);

        holder.imageView.setImageResource(tourGuide.getPhotoId());
        holder.textName.setText(tourGuide.getName());
        holder.ratingBar.setRating(tourGuide.getRating());

        String quote = getQuoteForTourGuide(position);
        holder.textQuote.setText(quote);

        holder.imageTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tourGuide.getTwitterHandle() != null) {
                    String twitterUrl = "https://twitter.com/" + tourGuide.getTwitterHandle();
                    openSocialMediaUrl(twitterUrl);
                }
            }
        });

        holder.imageInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tourGuide.getInstagramHandle() != null) {
                    String instagramUrl = "https://www.instagram.com/" + tourGuide.getInstagramHandle();
                    openSocialMediaUrl(instagramUrl);
                }
            }
        });

        holder.imageWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tourGuide.getWhatsappNumber() != null) {
                    String whatsappUrl = "https://wa.me/" + tourGuide.getWhatsappNumber();
                    openSocialMediaUrl(whatsappUrl);
                }
            }
        });
    }

    private String getQuoteForTourGuide(int position) {
        switch (position) {
            case 0:
                return "We travel not to escape life, but for life not to escape us";
            case 1:
                return "The world is a book, and those who do not travel read only one page";
            case 2:
                return "Even a poor tour guide is entitled to some happiness";
            case 3:
                return "Teaching history to eighth graders is like being a tour guide for people who hate their vacation";
            case 4:
                return "Serendipity was my tour guide, assisted by caprice";
            case 5:
                return "He who has led you so far will guide you further.";
            case 6:
                return "Life is a tour; we are all tourists.";
            case 7:
                return "I want someone to look at me the way I look at a travel brochure.";
            case 8:
                return "People don’t take trips, trips take people.";
            case 9:
                return "You don’t have to be rich to travel well.";
            case 10:
                return "I don't always travel, but when I do, I take pictures to prove it!";
            case 11:
                return "The world is a book and those who do not travel read only one page.";
            case 12:
                return "Jobs fill your pockets, adventures fill your soul.";
            case 13:
                return "Travel is the only thing you buy that makes you richer.";
            case 14:
                return "Life is short and the world is wide. Better get started";
            case 15:
                return "Taking pictures is savoring life intensely, every hundredth of a second.";
            default:
                return "Default quote";
        }
    }

    private void openSocialMediaUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return tourGuides.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textName;
        RatingBar ratingBar;
        TextView textQuote;
        ImageView imageTwitter;
        ImageView imageInstagram;
        ImageView imageWhatsApp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            textQuote = itemView.findViewById(R.id.textQuote);
            imageTwitter = itemView.findViewById(R.id.imageTwitter);
            imageInstagram = itemView.findViewById(R.id.imageInstagram);
            imageWhatsApp = itemView.findViewById(R.id.imageWhatsApp);
        }
    }
}
