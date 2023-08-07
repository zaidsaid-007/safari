package com.example.safariguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

    private List<TouristAttraction> attractionList;
    private OnItemClickListener clickListener;

    // Interface for handling click events
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public AttractionAdapter(List<TouristAttraction> attractionList, OnItemClickListener clickListener) {
        this.attractionList = attractionList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attraction, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        TouristAttraction attraction = attractionList.get(position);
        holder.bind(attraction);
    }

    @Override
    public int getItemCount() {
        return attractionList.size();
    }

    public class AttractionViewHolder extends RecyclerView.ViewHolder {
        private ImageView attractionImageView;
        private TextView attractionNameTextView;
        private TextView attractionDescriptionTextView;

        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);
            attractionImageView = itemView.findViewById(R.id.attractionImageView);
            attractionNameTextView = itemView.findViewById(R.id.attractionNameTextView);
            attractionDescriptionTextView = itemView.findViewById(R.id.attractionDescriptionTextView);

            // Set OnClickListener to the whole item view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            clickListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        // Bind data to views
        public void bind(TouristAttraction attraction) {
            attractionImageView.setImageResource(attraction.getImageResource());
            attractionNameTextView.setText(attraction.getName());
            attractionDescriptionTextView.setText(attraction.getDescription());
        }
    }
}
