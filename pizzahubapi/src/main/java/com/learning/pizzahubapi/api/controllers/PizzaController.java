package com.learning.pizzahubapi.api.controllers;

import com.learning.pizzahubapi.api.models.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("pizza")
public class PizzaController {
    public static List<Pizza> pizzas = new ArrayList<>();
    static {
        pizzas.add(new Pizza("Margherita", "Bucatar Coco"));
    }

    @GetMapping
    public String displayPizzaTable(Model model){
        model.addAttribute("title","All The Pizza");
        model.addAttribute("pizzas",pizzas);
        return "pizza/index";
    }
    @GetMapping("create")
    public String displayCreatePizzaForm(Model model){
        model.addAttribute("title","Create event");
        return "pizza/create";
    }
    @PostMapping("create")
    public String processCreatePizzaForm(@RequestParam String pizzaName, @RequestParam String pizzaMaker) {
        pizzas.add(new Pizza(pizzaName, pizzaMaker));
        return "redirect:/pizza"; // Ensure this redirects to the intended view.
    }

}
