package com.learning.pizzahubapi.api.controllers;

import com.learning.pizzahubapi.api.data.PizzaData;
import com.learning.pizzahubapi.api.data.PizzaRepository;
import com.learning.pizzahubapi.api.models.Pizza;
import com.learning.pizzahubapi.api.models.PizzaType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("pizza")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;
    //FindAll,Save,findByID
    @GetMapping
    public String displayPizzaTable(Model model){
        model.addAttribute("title","All The Pizza");
        model.addAttribute("pizzas", pizzaRepository.findAll());
        return "pizza/index";
    }
    @GetMapping("create")
    public String displayCreatePizzaForm(Model model){
        model.addAttribute("title","Create Pizza");
        model.addAttribute(new Pizza());
        model.addAttribute("types",PizzaType.values());
        return "pizza/create";
    }
    @PostMapping("create")
    public String processCreatePizzaForm(@ModelAttribute @Valid Pizza newPizza, Errors errors,Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title","Create Pizza");
            return "pizza/create";
        }
        pizzaRepository.save(newPizza);
        return "redirect:/pizza"; // Ensure this redirects to the intended view.
    }
    @GetMapping("delete")
    public String displayDeletePizzaForm(Model model){
        model.addAttribute("title","Delete Pizza");
        model.addAttribute("pizzas",pizzaRepository.findAll());
        return "pizza/delete";
    }
    @PostMapping("delete")
    public String processDeletePizzaForm(@RequestParam(required = false) Long[] pizzaIds){
        if(pizzaIds != null) {
            for (Long id : pizzaIds) {
                pizzaRepository.deleteById(id);
            }
        }
        return "redirect:/pizza";
    }
}
