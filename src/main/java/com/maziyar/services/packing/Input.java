package com.maziyar.services.packing;

import java.util.List;
import com.maziyar.exception.OutOfRangeException;

/**
 * Represents input data for the knapsack problem.
 * The input includes the maximum weight of a box, product specifications, and methods for parsing and conversion.
 */
public class Input {

    /** The maximum weight of a box. Must be between 0 and 100. */
    private double maxBoxWeight;

    /** Array of product IDs. */
    private int[] ids;

    /** Array of product weights. */
    private double[] weights;

    /** Array of product prices. */
    private int[] prices;

    /** String representation of product specifications. */
    private String productsSpecs;

    /**
     * Constructs an Input object with the given maximum box weight and product specifications.
     * @param maxBoxWeight The maximum weight of a box. Must be between 0 and 100.
     * @param productsSpecs String representation of product specifications.
     */
    public Input(double maxBoxWeight, String productsSpecs) {
        setMaxBoxWeight(maxBoxWeight);
        setProductsSpecs(productsSpecs);
    }

    /**
     * Default constructor for Input.
     */
    public Input() {
    }

    /**
     * Constructs an Input object from arrays of product IDs, weights, and prices.
     * @param ids Array of product IDs.
     * @param weights Array of product weights.
     * @param prices Array of product prices.
     */
    public Input(int[] ids, double[] weights, int[] prices) {
        this.ids = ids;
        this.weights = weights;
        this.prices = prices;
    }

    /**
     * Sets the maximum weight of a box.
     * @param maxBoxSize The maximum weight of a box. Must be between 0 and 100.
     * @throws OutOfRangeException If the input is out of the specified range.
     */
    public void setMaxBoxWeight(double maxBoxSize) {
        if ((maxBoxSize > 0) && (maxBoxSize <= 100))
            this.maxBoxWeight = maxBoxSize;
        else
            throw new OutOfRangeException("Box Size");
    }

    /**
     * Sets the product specifications.
     * @param productsSpecs String representation of product specifications.
     * @throws OutOfRangeException If the number of products exceeds the specified limit.
     */
    public void setProductsSpecs(String productsSpecs) {
        String[] parsedProducts = new Parsing().splitByParentheses(productsSpecs);
        int productsNumber = parsedProducts.length;
        if (productsNumber <= 15)
            this.productsSpecs = productsSpecs;
        else
            throw new OutOfRangeException("Max Box Size");
    }

    /**
     * Converts a list of products to arrays of IDs, weights, and prices.
     * @param products List of Product objects.
     * @return Input object containing arrays of IDs, weights, and prices.
     */
    public Input productsToArrays(List<Product> products) {
        ids = products.stream().mapToInt(Product::getId).toArray();
        weights = products.stream().mapToDouble(Product::getWeight).toArray();
        prices = products.stream().mapToInt(Product::getPrice).toArray();
        return new Input(ids, weights, prices);
    }

    /**
     * Gets the array of product IDs.
     * @return Array of product IDs.
     */
    public int[] getIds() {
        return this.ids;
    }

    /**
     * Gets the array of product weights.
     * @return Array of product weights.
     */
    public double[] getWeights() {
        return this.weights;
    }

    /**
     * Gets the array of product prices.
     * @return Array of product prices.
     */
    public int[] getPrices() {
        return this.prices;
    }

    /**
     * Gets the maximum weight of a box.
     * @return The maximum weight of a box.
     */
    public double getMaxBoxWeight() {
        return this.maxBoxWeight;
    }
}
