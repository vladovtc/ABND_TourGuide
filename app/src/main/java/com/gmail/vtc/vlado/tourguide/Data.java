package com.gmail.vtc.vlado.tourguide;

/**
 * Created by user on 26.3.2018..
 */

public class Data {

    private int image;
    private String name;
    private String description;
    private String wiki;
    private String location;

    public Data(int image, String name, String description, String wiki, String location) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.wiki = wiki;
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWiki() {
        return wiki;
    }

    public String getLocation() {
        return location;
    }

}
