package org.devschool.web.pizza;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
