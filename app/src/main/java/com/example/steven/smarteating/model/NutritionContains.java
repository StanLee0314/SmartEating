package com.example.steven.smarteating.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by steven on 8/22/2018.
 */

public class NutritionContains {
    private String food_ID;
    private String food_Name;
    private Long category;


    private Long energy;
    private Long carbohydrates;
    private Long protein;
    private Long dietary_fibre;
    private Long total_fat;
    private Long total_sugars;
    private Long vitamin_B1;
    private Long vitamin_B2;
    private Long vitamin_B3;
    private Long vitamin_B6;
    private Long vitamin_B12;
    private Long vitamin_C;
    private Long vitamin_E;
    private Long vitamin_A;
    private Long total_Folates;
    private Long calcium;
    private Long iodine;
    private Long iron;

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public NutritionContains(String food_ID, String food_Name, Long category, Long energy, Long carbohydrates, Long protein, Long dietary_fibre, Long total_fat, Long total_sugars, Long vitamin_B1, Long vitamin_B2, Long vitamin_B3, Long vitamin_B6, Long vitamin_B12, Long vitamin_C, Long vitamin_E, Long vitamin_A, Long total_Folates, Long calcium, Long iodine, Long iron, Long magnesium, Long phosphorus, Long potassium, Long selenium, Long sodium, Long zinc, Long cholesterol, Long starch) {
        this.food_ID = food_ID;
        this.food_Name = food_Name;
        this.category = category;
        this.energy = energy;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.dietary_fibre = dietary_fibre;

        this.total_fat = total_fat;
        this.total_sugars = total_sugars;
        this.vitamin_B1 = vitamin_B1;
        this.vitamin_B2 = vitamin_B2;
        this.vitamin_B3 = vitamin_B3;
        this.vitamin_B6 = vitamin_B6;
        this.vitamin_B12 = vitamin_B12;
        this.vitamin_C = vitamin_C;
        this.vitamin_E = vitamin_E;
        this.vitamin_A = vitamin_A;
        this.total_Folates = total_Folates;
        this.calcium = calcium;
        this.iodine = iodine;
        this.iron = iron;
        this.magnesium = magnesium;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.selenium = selenium;
        this.sodium = sodium;
        this.zinc = zinc;
        this.cholesterol = cholesterol;
        this.starch = starch;
    }

    public String getFood_ID() {

        return food_ID;
    }

    public void setFood_ID(String food_ID) {
        this.food_ID = food_ID;
    }

    public String getFood_Name() {
        return food_Name;
    }

    public void setFood_Name(String food_Name) {
        this.food_Name = food_Name;
    }

    public Long getEnergy() {
        return energy;
    }

    public void setEnergy(Long energy) {
        this.energy = energy;
    }

    public Long getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Long carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Long getProtein() {
        return protein;
    }

    public void setProtein(Long protein) {
        this.protein = protein;
    }

    public Long getDietary_fibre() {
        return dietary_fibre;
    }

    public void setDietary_fibre(Long dietary_fibre) {
        this.dietary_fibre = dietary_fibre;
    }

    public Long getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(Long total_fat) {
        this.total_fat = total_fat;
    }

    public Long getTotal_sugars() {
        return total_sugars;
    }

    public void setTotal_sugars(Long total_sugars) {
        this.total_sugars = total_sugars;
    }

    public Long getVitamin_B1() {
        return vitamin_B1;
    }

    public void setVitamin_B1(Long vitamin_B1) {
        this.vitamin_B1 = vitamin_B1;
    }

    public Long getVitamin_B2() {
        return vitamin_B2;
    }

    public void setVitamin_B2(Long vitamin_B2) {
        this.vitamin_B2 = vitamin_B2;
    }

    public Long getVitamin_B3() {
        return vitamin_B3;
    }

    public void setVitamin_B3(Long vitamin_B3) {
        this.vitamin_B3 = vitamin_B3;
    }

    public Long getVitamin_B6() {
        return vitamin_B6;
    }

    public void setVitamin_B6(Long vitamin_B6) {
        this.vitamin_B6 = vitamin_B6;
    }

    public Long getVitamin_B12() {
        return vitamin_B12;
    }

    public void setVitamin_B12(Long vitamin_B12) {
        this.vitamin_B12 = vitamin_B12;
    }

    public Long getVitamin_C() {
        return vitamin_C;
    }

    public void setVitamin_C(Long vitamin_C) {
        this.vitamin_C = vitamin_C;
    }

    public Long getVitamin_E() {
        return vitamin_E;
    }

    public void setVitamin_E(Long vitamin_E) {
        this.vitamin_E = vitamin_E;
    }

    public Long getVitamin_A() {
        return vitamin_A;
    }

    public void setVitamin_A(Long vitamin_A) {
        this.vitamin_A = vitamin_A;
    }

    public Long getTotal_Folates() {
        return total_Folates;
    }

    public void setTotal_Folates(Long total_Folates) {
        this.total_Folates = total_Folates;
    }

    public Long getCalcium() {
        return calcium;
    }

    public void setCalcium(Long calcium) {
        this.calcium = calcium;
    }

    public Long getIodine() {
        return iodine;
    }

    public void setIodine(Long iodine) {
        this.iodine = iodine;
    }

    public Long getIron() {
        return iron;
    }

    public void setIron(Long iron) {
        this.iron = iron;
    }

    public Long getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Long magnesium) {
        this.magnesium = magnesium;
    }

    public Long getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(Long phosphorus) {
        this.phosphorus = phosphorus;
    }

    public Long getPotassium() {
        return potassium;
    }

    public void setPotassium(Long potassium) {
        this.potassium = potassium;
    }

    public Long getSelenium() {
        return selenium;
    }

    public void setSelenium(Long selenium) {
        this.selenium = selenium;
    }

    public Long getSodium() {
        return sodium;
    }

    public void setSodium(Long sodium) {
        this.sodium = sodium;
    }

    public Long getZinc() {
        return zinc;
    }

    public void setZinc(Long zinc) {
        this.zinc = zinc;
    }

    public Long getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Long cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Long getStarch() {
        return starch;
    }

    public void setStarch(Long starch) {
        this.starch = starch;
    }

    private Long magnesium;
    private Long phosphorus;
    private Long potassium;
    private Long selenium;
    private Long sodium;
    private Long zinc;
    private Long cholesterol;
    private Long starch;

    public NutritionContains() {
    }


}
