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
                .map(PizzaService::makePizzaFromEntity)
                .collect(Collectors.toList());
    }

    public Pizza createPizza(Pizza pizza) {
        PizzaEntity pizzaModel = new PizzaEntity();
        pizzaModel.setName(pizza.getName());
        pizzaModel.setPrice(pizza.getPrice());

        PizzaEntity persistedPizza = this.pizzaRepository.save(pizzaModel);
        return makePizzaFromEntity(persistedPizza);
    }

    private static Pizza makePizzaFromEntity(PizzaEntity pizzaEntity) {
        Pizza pizza = new Pizza();
        pizza.setId(pizzaEntity.getId());
        pizza.setName(pizzaEntity.getName());
        pizza.setPrice(pizzaEntity.getPrice());
        return pizza;
    }

    public Pizza updatePizza(Long id, UpdatePizza updatePizza) {
        PizzaEntity pizzaEntity = this.pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found :("));

        pizzaEntity.setPrice(updatePizza.getPrice());

        PizzaEntity savedPizza = this.pizzaRepository.save(pizzaEntity);
        return makePizzaFromEntity(savedPizza);
    }

    public void removePizza(Long id) {
        this.pizzaRepository.deleteById(id);
    }
}
