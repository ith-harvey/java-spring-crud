package com.example.demo;

import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static javax.xml.ws.soap.AddressingFeature.ID;

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



}