package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String delete(@PathVariable("id") Long id) {
        this.repository.delete(id);
        return "The record with the id of " + id + " was successfully deleted.";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Coffee> patch(
            @PathVariable("id") Long id,
            @RequestBody Coffee coffee) {

        if (this.repository.exists(id)) {
            return new ResponseEntity<Coffee>(this.repository.save(coffee), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("crap", HttpStatus.BAD_REQUEST);
        }
        }
    }