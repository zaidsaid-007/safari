package com.example.safariguide;

public class TouristAttraction {
    private String name;
    private String description;
    private int imageResource;
    private float rating;

    public TouristAttraction(String name, String description, int imageResource, float rating) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
        this.rating = rating;
    }

    // Add getters for other fields
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public float getRating() {
        return rating;
    }
}
