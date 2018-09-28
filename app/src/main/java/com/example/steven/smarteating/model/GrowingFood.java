package com.example.steven.smarteating.model;

/**
 * Created by steven on 9/29/2018.
 */

public class GrowingFood {
    String description;
    String image_url;
    String name;

    public GrowingFood() {
    }

    public GrowingFood(String description, String image_url, String name) {

        this.description = description;
        this.image_url = image_url;
        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
