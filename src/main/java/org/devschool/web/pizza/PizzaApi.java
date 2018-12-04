package org.devschool.web.pizza;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pizza")
public class PizzaApi {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaApi(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> fetchAllPizzas() {
        log.info("Fetching all pizzas");
        return this.pizzaService.findAllPizzas();
    }

    @PostMapping
    public Pizza makePizza(@RequestBody Pizza pizza) {
        log.info("Creating new pizza {}.", pizza);
        return this.pizzaService.createPizza(pizza);
    }

    @PutMapping(value = "/{id}")
    public Pizza updatePizza(@PathVariable("id") Long id,
                             @RequestBody UpdatePizza updatePizza) {
        log.info("Updating pizza with id {} using modifications {}.", id, updatePizza);
        return this.pizzaService.updatePizza(id, updatePizza);
    }

    @DeleteMapping(value = "/{id}")
    public void removePizza(@PathVariable("id") Long id) {
        log.info("Deleting pizza with id {}.", id);
        this.pizzaService.removePizza(id);
    }
}
