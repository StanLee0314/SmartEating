package com.example.steven.smarteating.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by steven on 8/22/2018.
 */

public class NutritionContains {
    private String food_ID;
    private String food_Name;
    private double category;


    private double energy;
    private double carbohydrates;
    private double protein;
    private double dietary_fibre;
    private double total_fat;
    private double total_sugars;
    private double vitamin_B1;
    private double vitamin_B2;
    private double vitamin_B3;
    private double vitamin_B6;
    private double vitamin_B12;
    private double vitamin_C;
    private double vitamin_E;
    private double vitamin_A;
    private double total_Folates;
    private double calcium;
    private double iodine;
    private double iron;

    public double getCategory() {
        return category;
    }

    public void setCategory(double category) {
        this.category = category;
    }

    public NutritionContains(String food_ID, String food_Name, double category, double energy, double carbohydrates, double protein, double dietary_fibre, double total_fat, double total_sugars, double vitamin_B1, double vitamin_B2, double vitamin_B3, double vitamin_B6, double vitamin_B12, double vitamin_C, double vitamin_E, double vitamin_A, double total_Folates, double calcium, double iodine, double iron, double magnesium, double phosphorus, double potassium, double selenium, double sodium, double zinc, double cholesterol, double starch) {
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

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getDietary_fibre() {
        return dietary_fibre;
    }

    public void setDietary_fibre(double dietary_fibre) {
        this.dietary_fibre = dietary_fibre;
    }

    public double getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(double total_fat) {
        this.total_fat = total_fat;
    }

    public double getTotal_sugars() {
        return total_sugars;
    }

    public void setTotal_sugars(double total_sugars) {
        this.total_sugars = total_sugars;
    }

    public double getVitamin_B1() {
        return vitamin_B1;
    }

    public void setVitamin_B1(double vitamin_B1) {
        this.vitamin_B1 = vitamin_B1;
    }

    public double getVitamin_B2() {
        return vitamin_B2;
    }

    public void setVitamin_B2(double vitamin_B2) {
        this.vitamin_B2 = vitamin_B2;
    }

    public double getVitamin_B3() {
        return vitamin_B3;
    }

    public void setVitamin_B3(double vitamin_B3) {
        this.vitamin_B3 = vitamin_B3;
    }

    public double getVitamin_B6() {
        return vitamin_B6;
    }

    public void setVitamin_B6(double vitamin_B6) {
        this.vitamin_B6 = vitamin_B6;
    }

    public double getVitamin_B12() {
        return vitamin_B12;
    }

    public void setVitamin_B12(double vitamin_B12) {
        this.vitamin_B12 = vitamin_B12;
    }

    public double getVitamin_C() {
        return vitamin_C;
    }

    public void setVitamin_C(double vitamin_C) {
        this.vitamin_C = vitamin_C;
    }

    public double getVitamin_E() {
        return vitamin_E;
    }

    public void setVitamin_E(double vitamin_E) {
        this.vitamin_E = vitamin_E;
    }

    public double getVitamin_A() {
        return vitamin_A;
    }

    public void setVitamin_A(double vitamin_A) {
        this.vitamin_A = vitamin_A;
    }

    public double getTotal_Folates() {
        return total_Folates;
    }

    public void setTotal_Folates(double total_Folates) {
        this.total_Folates = total_Folates;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getIodine() {
        return iodine;
    }

    public void setIodine(double iodine) {
        this.iodine = iodine;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getSelenium() {
        return selenium;
    }

    public void setSelenium(double selenium) {
        this.selenium = selenium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getStarch() {
        return starch;
    }

    public void setStarch(double starch) {
        this.starch = starch;
    }

    private double magnesium;
    private double phosphorus;
    private double potassium;
    private double selenium;
    private double sodium;
    private double zinc;
    private double cholesterol;
    private double starch;

    public NutritionContains() {
    }


}
