package com.maziyar.services.packing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parsing {

    public Product parseOneParentheses(String commoditySpecs) {
        String[] parts = commoditySpecs.substring(1, commoditySpecs.length() - 1).split(",");
        int id = Integer.parseInt(parts[0]);
        float weight = Float.parseFloat(parts[1]);
        int value = Integer.parseInt(parts[2].substring(1));
        return new Product(id, weight, value);
    }

    public String[] splitByParentheses(String input) {
        return input.replaceAll("\\s", "").split("(?<=\\))|(?=\\()");
    }

    public List<Product> parseAllCommodities(String input) {
        return Arrays.stream(splitByParentheses(input))
                .map(this::parseOneParentheses)
                .collect(Collectors.toList());
    }
}
