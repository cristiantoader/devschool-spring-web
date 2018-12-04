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

    // PUT localhost:8080/pizza/1 {...json content...}
    @PutMapping(value = "/{id}")
    public Pizza updatePizza(@PathVariable("id") Long id,
                             @RequestBody Pizza pizza) {
        log.info("Updating pizza with id {} using modifications {}.", id, pizza);
        return this.pizzaService.updatePizza(pizza);
    }
}
