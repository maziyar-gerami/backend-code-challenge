package com.maziyar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maziyar.services.packing.Product;
import com.maziyar.services.packing.Parsing;

@RestController
public class ServicesController {

    private final ProductRepository repository;

    @Autowired
    public ServicesController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/products")
    public boolean saveInDB(@RequestBody String input) {
        List<Product> products = new Parsing().parseAllProducts(input);
        if (products != null) {
            try {
                repository.saveAll(products);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping("/products/prices/average")
    public Double avgPrice (@RequestParam(name = "maxWeight") String maxPrice, @RequestParam(name = "minWeight") String minPrice) {
        System.out.println(repository.findAveragePriceForWeightLessThan(Float.valueOf(minPrice), Float.valueOf(maxPrice)));
        return repository.findAveragePriceForWeightLessThan(Float.valueOf(minPrice), Float.valueOf(maxPrice));
    }
}
