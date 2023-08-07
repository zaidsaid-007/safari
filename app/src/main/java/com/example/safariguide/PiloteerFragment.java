package com.example.safariguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safariguide.Adapter.TourGuideAdapter;

import java.util.ArrayList;
import java.util.List;

public class PiloteerFragment extends Fragment {

    private RecyclerView recyclerView;
    private TourGuideAdapter adapter;
    private List<TourGuide> tourGuideList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_piloteer, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tourGuideList = getTourGuides();
        adapter = new TourGuideAdapter(tourGuideList, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<TourGuide> getTourGuides() {
        List<TourGuide> guides = new ArrayList<>();

        // Add your tour guide data here
        guides.add(new TourGuide(R.drawable.linda, "Linda Kioko", 0.1f, "@linda.kioko", "linda_ig", "+254786702284"));
        guides.add(new TourGuide(R.drawable.girl, "Aisha Smith", 3.8f, "@aisha.smith", "aisha_ig", "+254722743405"));
        guides.add(new TourGuide(R.drawable.jobi, "Dr. Muchelule", 5.0f, "@dr.muchelule", "dr_muchelule", "456789123"));
        guides.add(new TourGuide(R.drawable.sadgil, "Sekento Abdi", 4.8f, "@sekento.abdi", "sekento_abdi", "789123456"));
        guides.add(new TourGuide(R.drawable.modelmn, "Lemashon Musaka", 2.8f, "@lemashon.musaka", "lemashon_musaka", "321654987"));
        guides.add(new TourGuide(R.drawable.duba, "Duba Forei", 1.8f, "@duba.forei", "duba_forei", "654987321"));
        guides.add(new TourGuide(R.drawable.jobi, "Jobi Kule", 4.8f, "@jobi.kule", "jobi_kule", "987321654"));
        guides.add(new TourGuide(R.drawable.sule, "Omar Boya", 0.8f, "@omar.boya", "omar_boya", "+25422744305"));
        guides.add(new TourGuide(R.drawable.opn, "Hamza Sule", 4.8f, "@hamza.sule", "hamza_sule", "147258369"));
        guides.add(new TourGuide(R.drawable.hmza, "Alianda Joka", 2.8f, "@alianda.joka", "alianda_joka", "258369147"));
        guides.add(new TourGuide(R.drawable.oya1, "Safina Kariuki ", 2.0f, "@alianda.joka", "alianda_joka", "258369147"));
        guides.add(new TourGuide(R.drawable.oya2, "Moses Kiptop", 1.8f, "@alianda.joka", "alianda_joka", "258369147"));
        guides.add(new TourGuide(R.drawable.isto1, "Zainab Bakari", 4.0f, "@alianda.joka", "alianda_joka", "258369147"));
        guides.add(new TourGuide(R.drawable.masai, "Julias OleMadonka", 3.0f, "@alianda.joka", "alianda_joka", "258369147"));
        guides.add(new TourGuide(R.drawable.autumn, "Hussein Tipis", 0.5f, "@alianda.joka", "alianda_joka", "258369147"));
        guides.add(new TourGuide(R.drawable.masai, "Juma Kitole", 2.0f, "@alianda.joka", "alianda_joka", "258369147"));

        // Add more tour guides as needed...

        return guides;
    }
}
