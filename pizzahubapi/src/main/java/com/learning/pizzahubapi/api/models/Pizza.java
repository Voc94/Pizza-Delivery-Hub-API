package com.learning.pizzahubapi.api.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

import java.util.Objects;
//Bussines Data
@Entity
@Getter
public class Pizza {
    @Id
    @GeneratedValue
    private Long id;
    private static Long nextId = 1L;

    @Setter
    @Valid
    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2,max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Setter
    @NotNull(message = "Chef is mandatory")
    @NotBlank(message = "Chef is mandatory")
    @Size(min = 3,max = 50, message = "Chef must be between 3 and 50 characters")
    private String madeBy;

    @Setter
    private PizzaType type;

    public Pizza(String name, String madeBy,PizzaType type) {
        this.name = name;
        this.madeBy = madeBy;
        this.type = type;
    }
    public Pizza(){
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", madeBy='" + madeBy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
