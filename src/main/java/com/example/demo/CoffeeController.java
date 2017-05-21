package com.example.demo;

import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

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

    @GetMapping("/{id}")
    public Coffee getSomething(@PathVariable("id") Long id) {
        return this.repository.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.repository.delete(id);
    }

    @PatchMapping("/{id}")
    public Coffee patch(
            @PathVariable("id") Long id,
            @RequestBody Coffee coffee) {
        System.out.println(coffee);
        if (repository.exists(id)) {
            return this.repository.save(coffee);
        }
        else {
        return this.repository.findOne(id);
        }
    }

}