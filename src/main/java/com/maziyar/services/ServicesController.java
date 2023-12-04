package com.maziyar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maziyar.services.packing.Product;
import com.maziyar.services.packing.Parsing;

@RestController
public class ServicesController {

    private final CommodityRepository repository;

    @Autowired
    public ServicesController(CommodityRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/commodities")
    public boolean saveInDB(@RequestBody String input) {
        List<Product> commodities = new Parsing().commoditiesToArrays(input);
        if (commodities != null) {
            try {
                repository.saveAll(commodities);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @GetMapping("/commodities")
    public List<Product> findAll() {
        return repository.findAll();
    }
}
