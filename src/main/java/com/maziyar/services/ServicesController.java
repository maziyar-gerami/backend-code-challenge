package com.maziyar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maziyar.packing.Commodity;
import com.maziyar.packing.Parsing;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/")
public class ServicesController {

    private Repository repository;

    @Autowired
    public ServicesController(
            Repository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/commodities", method = RequestMethod.POST)
    public Boolean saveInDB(
            @RequestBody String input,
            Model model) {
        List<Commodity> commodities = new Parsing().commoditiesToArrays(input);
        if (commodities != null) 
            repository.saveAll(commodities);
            try {
                repository.saveAll(commodities);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

    }

}
