package com.maziyar.services.packing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for parsing and processing product specifications.
 */
public class Parsing {

    /**
     * Parses a single product specification enclosed in parentheses.
     *
     * @param productSpecs String representation of a product specification.
     * @return Product object representing the parsed product.
     */
    public Product parseOneParentheses(String productSpecs) {
        String[] parts = productSpecs.substring(1, productSpecs.length() - 1).split(",");
        int id = Integer.parseInt(parts[0]);
        float weight = Float.parseFloat(parts[1]);
        int value = Integer.parseInt(parts[2].substring(1));
        return new Product(id, weight, value);
    }

    /**
     * Splits a string containing multiple product specifications into an array.
     *
     * @param input String containing product specifications.
     * @return Array of strings, each representing a single product specification.
     */
    public String[] splitByParentheses(String input) {
        return input.replaceAll("\\s", "").split("(?<=\\))|(?=\\()");
    }

    /**
     * Parses all product specifications from a string and returns a list of Product objects.
     *
     * @param input String containing multiple product specifications.
     * @return List of Product objects representing the parsed products.
     */
    public List<Product> parseAllProducts(String input) {
        return Arrays.stream(splitByParentheses(input))
                .map(this::parseOneParentheses)
                .collect(Collectors.toList());
    }
}
