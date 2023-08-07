package com.example.safariguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the LinearLayouts by their IDs
        LinearLayout restaurant = view.findViewById(R.id.restaurant);
        LinearLayout sectionSettings = view.findViewById(R.id.sectionSettings);
        LinearLayout sectionAbout = view.findViewById(R.id.sectionAbout);
        LinearLayout terms = view.findViewById(R.id.terms);
        LinearLayout share = view.findViewById(R.id.share);
        LinearLayout logout = view.findViewById(R.id.logout);

        // Set click listeners for each LinearLayout
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle restaurant click intent here
                Intent intent = new Intent(getActivity(), Hotels.class);
                startActivity(intent);
            }
        });

        sectionSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle settings click intent here
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        sectionAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle about click intent here
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle share click intent here
                Intent intent = new Intent(getActivity(), ShareActivity.class);
                startActivity(intent);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle share click intent here
                Intent intent = new Intent(getActivity(), ConditionsActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout click intent here
                Intent intent = new Intent(getActivity(), LogoutActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
