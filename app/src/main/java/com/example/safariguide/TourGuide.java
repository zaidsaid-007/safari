package com.example.safariguide;

public class TourGuide {
    private int photoId;
    private String name;
    private float rating;
    private String twitterHandle;
    private String instagramHandle;
    private String whatsappNumber;

    public TourGuide(int photoId, String name, float rating, String twitterHandle, String instagramHandle, String whatsappNumber) {
        this.photoId = photoId;
        this.name = name;
        this.rating = rating;
        this.twitterHandle = twitterHandle;
        this.instagramHandle = instagramHandle;
        this.whatsappNumber = whatsappNumber;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }
}
