package com.learning.pizzahubapi.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Pizza {
    private Long id;
    private static Long nextId = 1L;
    @Setter
    private String name;
    @Setter
    private String madeBy;

    public Pizza(String name, String madeBy) {
        this.id = nextId;
        this.name = name;
        this.madeBy = madeBy;
        nextId++;
    }
    public Pizza(){

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", madeBy='" + madeBy + '\'' +
                '}';
    }
}
