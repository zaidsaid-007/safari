package com.example.safariguide.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safariguide.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<String> reviewsList;

    public ReviewAdapter(List<String> reviewsList) {
        this.reviewsList = reviewsList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        String review = reviewsList.get(position);
        String[] parts = review.split(": ");
        String author = parts[0];
        String reviewText = parts[1];

        holder.tvReviewAuthor.setText(author);
        holder.tvReviewText.setText(reviewText);
    }

    @Override
    public int getItemCount() {
        return reviewsList.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView tvReviewAuthor;
        TextView tvReviewText;

        ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReviewAuthor = itemView.findViewById(R.id.tvReviewAuthor);
            tvReviewText = itemView.findViewById(R.id.tvReviewText);
        }
    }
}
