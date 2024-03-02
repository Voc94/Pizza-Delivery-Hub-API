package com.learning.pizzahubapi.api.controllers;

import com.learning.pizzahubapi.api.data.PizzaData;
import com.learning.pizzahubapi.api.models.Pizza;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("pizza")
public class PizzaController {
    @GetMapping
    public String displayPizzaTable(Model model){
        model.addAttribute("title","All The Pizza");
        model.addAttribute("pizzas", PizzaData.getAll());
        return "pizza/index";
    }
    @GetMapping("create")
    public String displayCreatePizzaForm(Model model){
        model.addAttribute("title","Create event");
        model.addAttribute(new Pizza());
        return "pizza/create";
    }
    @PostMapping("create")
    public String processCreatePizzaForm(@ModelAttribute @Valid Pizza newPizza, Errors errors,Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title","Create event");
            return "pizza/create";
        }
        PizzaData.add(newPizza);
        return "redirect:/pizza"; // Ensure this redirects to the intended view.
    }
    @GetMapping("delete")
    public String displayDeletePizzaForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("pizzas",PizzaData.getAll());
        return "pizza/delete";
    }
    @PostMapping("delete")
    public String processDeletePizzaForm(@RequestParam(required = false) Long[] pizzaIds){
        if(pizzaIds != null) {
            for (Long id : pizzaIds) {
                PizzaData.remove(id);
            }
        }
        return "redirect:/pizza";
    }
}
