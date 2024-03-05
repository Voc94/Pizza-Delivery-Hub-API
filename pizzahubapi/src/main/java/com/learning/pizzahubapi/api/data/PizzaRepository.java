package com.learning.pizzahubapi.api.data;

import com.learning.pizzahubapi.api.models.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza,Long> {
}
