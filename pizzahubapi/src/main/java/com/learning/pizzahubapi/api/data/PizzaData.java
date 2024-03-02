package com.learning.pizzahubapi.api.data;

import com.learning.pizzahubapi.api.models.Pizza;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PizzaData {
    //Data type to place the pizzas
    private static final Map<Long, Pizza> pizzaMap = new HashMap<>();
    //get all pizzas
    public static Collection<Pizza> getAll(){
        return pizzaMap.values();
    }
    //get a single pizza
    public static Pizza getById(int id){
        return pizzaMap.get(id);
    }
    //add a pizza
    public static void add(Pizza pizza) {
        pizzaMap.put(pizza.getId(),pizza);
    }
    //remove a pizza
    public static void remove(Long id){
        pizzaMap.remove(id);
    }
}
