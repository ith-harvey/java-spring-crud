package com.example.demo;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ianharvey on 5/19/17.
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeRepository repository;

    public CoffeeController(CoffeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Coffee> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Coffee create(@RequestBody Coffee coffee) {
        return this.repository.save(coffee);
    }

}