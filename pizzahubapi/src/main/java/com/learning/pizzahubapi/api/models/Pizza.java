package com.learning.pizzahubapi.api.models;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

import java.util.Objects;
@Getter
public class Pizza {
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

    public Pizza(String name, String madeBy) {
        this.id = nextId;
        this.name = name;
        this.madeBy = madeBy;
      //  nextId++;
    }
    public Pizza(){
        this.id = nextId;
        nextId++;
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
