package com.example.safariguide;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap map;
    private SearchView searchView;
    private SupportMapFragment mapFragment;

    private List<String> touristAttractions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        searchView = view.findViewById(R.id.location);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;
                if (location != null && !location.equals("")) {
                    Geocoder geocoder = new Geocoder(getContext());
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                        map.addMarker(new MarkerOptions().position(latLng).title(location));
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);

        // Add tourist attractions to the list
        touristAttractions = new ArrayList<>();
        touristAttractions.add("Nairobi National Park");
        touristAttractions.add("Maasai Mara National Reserve");
        touristAttractions.add("Amboseli National Park");
        touristAttractions.add("Tsavo National Park");
        touristAttractions.add("Lake Nakuru National Park");
        touristAttractions.add("Mount Kenya");
        touristAttractions.add("Samburu National Reserve");
        touristAttractions.add("Lake Naivasha");
        touristAttractions.add("Diani Beach");
        touristAttractions.add("Nairobi National Museum");
        touristAttractions.add("Fort Jesus, Mombasa");
        touristAttractions.add("Hell's Gate National Park");
        touristAttractions.add("Lamu Old Town");
        touristAttractions.add("Mombasa Marine National Park");
        touristAttractions.add("Nairobi Railway Museum");
        touristAttractions.add("Karen Blixen Museum");
        touristAttractions.add("Giraffe Centre, Nairobi");
        touristAttractions.add("Thompson's Falls");
        touristAttractions.add("Mombasa Old Town");
        touristAttractions.add("Malindi Marine National Park");
        touristAttractions.add("Nairobi National Archives");
        touristAttractions.add("Karura Forest");
        touristAttractions.add("Nairobi Safari Walk");
        touristAttractions.add("Nairobi Snake Park");
        touristAttractions.add("Kit Mikayi");
        touristAttractions.add("Shimba Hills National Reserve");
        touristAttractions.add("Nairobi Animal Orphanage");
        touristAttractions.add("Nyeri Museum");
        touristAttractions.add("Haller Park");
        touristAttractions.add("Lake Bogoria National Reserve");
        touristAttractions.add("Sheldrick Wildlife Trust");
        touristAttractions.add("Kisite-Mpunguti Marine National Park");
        touristAttractions.add("Ruma National Park");
        touristAttractions.add("Ol Donyo Sabuk National Park");
        touristAttractions.add("Nairobi Railway Museum");
        touristAttractions.add("Nairobi National Botanic Garden");
        touristAttractions.add("Mamba Village Centre");
        touristAttractions.add("Nairobi National Theatre");
        touristAttractions.add("Tana River Primate Reserve");
        touristAttractions.add("Nairobi Giraffe Centre");
        touristAttractions.add("Marsabit National Park");
        touristAttractions.add("Gede Ruins");
        touristAttractions.add("Nairobi Railway Museum");
        touristAttractions.add("Ngong Hills");
        touristAttractions.add("Rift Valley Province");
        touristAttractions.add("Mount Longonot National Park");
        touristAttractions.add("Lake Victoria");
        touristAttractions.add("Rusinga Island");
        touristAttractions.add("Kisumu Impala Sanctuary");
        touristAttractions.add("Kakamega Forest");

        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        // Add markers for tourist attractions
        for (String attraction : touristAttractions) {
            Geocoder geocoder = new Geocoder(getContext());
            try {
                List<Address> addressList = geocoder.getFromLocationName(attraction + ", Kenya", 1);
                if (addressList != null && addressList.size() > 0) {
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    map.addMarker(new MarkerOptions().position(latLng).title(attraction));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
