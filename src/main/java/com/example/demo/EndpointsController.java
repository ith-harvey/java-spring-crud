package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

/**
 * Created by ianharvey on 5/19/17.
 */
@RestController
public class EndpointsController {

    @GetMapping("/coffees")
    public String getCoffees() {
        return "GET to coffees route";
    }

    @GetMapping("/coffees/req")
    public String getRequest(
            @RequestParam("name") String name,
            @RequestParam(value = "sort-dir") String sortDirection) {
                 return format("name is %s and sortDirection is %s", name, sortDirection);
    }

    @PostMapping("/coffees")
    public String createCoffees() {
        return "Posted to coffees route";
    }

}
