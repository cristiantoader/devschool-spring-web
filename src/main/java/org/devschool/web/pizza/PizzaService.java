package org.devschool.web.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> findAllPizzas() {
        return this.pizzaRepository.findAll()
                .stream()
                .map(this::makePizzaFromEntity)
                .collect(Collectors.toList());
    }

    private Pizza makePizzaFromEntity(PizzaEntity pizzaEntity) {
        Pizza pizza = new Pizza();
        pizza.setId(pizzaEntity.getId());
        pizza.setName(pizzaEntity.getName());
        pizza.setPrice(pizzaEntity.getPrice());
        return pizza;
    }
}
