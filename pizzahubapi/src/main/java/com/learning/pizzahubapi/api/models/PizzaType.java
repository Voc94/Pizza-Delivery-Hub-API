package com.learning.pizzahubapi.api.models;

public enum PizzaType {
    ALERGEN_FREE("No Alergens"),
    VEGETARIAN("Vegetarian"),
    GOURMET("Gourmet"),
    CLASSIC("Classic");

    private final String displayName;

    PizzaType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
}
