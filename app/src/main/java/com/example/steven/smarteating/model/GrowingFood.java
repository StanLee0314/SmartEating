package com.example.steven.smarteating.model;

/**
 * Created by steven on 9/29/2018.
 */

public class GrowingFood {
    String description;
    String image_url;
    String name;
    String growing_from_seed;
    String harvesting;
    int id;
    String optimal_soil;
    String optimal_sun;
    String planting_considerations;
    String spacing;
    String storage_use;
    String transplanting;
    String watering;
    String when_to_plant;

    public GrowingFood(String description, String image_url, String name, String growing_from_seed, String harvesting, int id, String optimal_soil, String optimal_sun, String planting_considerations, String spacing, String storage_use, String transplanting, String watering, String when_to_plant) {
        this.description = description;
        this.image_url = image_url;
        this.name = name;
        this.growing_from_seed = growing_from_seed;
        this.harvesting = harvesting;
        this.id = id;
        this.optimal_soil = optimal_soil;
        this.optimal_sun = optimal_sun;
        this.planting_considerations = planting_considerations;
        this.spacing = spacing;
        this.storage_use = storage_use;
        this.transplanting = transplanting;
        this.watering = watering;
        this.when_to_plant = when_to_plant;
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

    public String getGrowing_from_seed() {
        return growing_from_seed;
    }

    public void setGrowing_from_seed(String growing_from_seed) {
        this.growing_from_seed = growing_from_seed;
    }

    public String getHarvesting() {
        return harvesting;
    }

    public void setHarvesting(String harvesting) {
        this.harvesting = harvesting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptimal_soil() {
        return optimal_soil;
    }

    public void setOptimal_soil(String optimal_soil) {
        this.optimal_soil = optimal_soil;
    }

    public String getOptimal_sun() {
        return optimal_sun;
    }

    public void setOptimal_sun(String optimal_sun) {
        this.optimal_sun = optimal_sun;
    }

    public String getplanting_considerations() {
        return planting_considerations;
    }

    public void setplanting_considerations(String planting_considerations) {
        this.planting_considerations = planting_considerations;
    }

    public String getSpacing() {
        return spacing;
    }

    public void setSpacing(String spacing) {
        this.spacing = spacing;
    }

    public String getstorage_use() {
        return storage_use;
    }

    public void setstorage_use(String storage_use) {
        this.storage_use = storage_use;
    }

    public String getTransplanting() {
        return transplanting;
    }

    public void setTransplanting(String transplanting) {
        this.transplanting = transplanting;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getWhen_to_plant() {
        return when_to_plant;
    }

    public void setWhen_to_plant(String when_to_plant) {
        this.when_to_plant = when_to_plant;
    }

    public GrowingFood() {
    }


}
