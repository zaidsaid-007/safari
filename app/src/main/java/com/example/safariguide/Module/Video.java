package com.example.safariguide.Module;

public class Video {
    private String videoURL,title,desc;

    public Video(String videoURL, String title, String desc) {
        this.videoURL = videoURL;
        this.title = title;
        this.desc = desc;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
