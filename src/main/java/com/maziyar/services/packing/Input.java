package com.maziyar.services.packing;

import java.util.List;

import com.maziyar.exception.OutOfRangeException;

public class Input {
    private double maxBoxWeight;
    private int[] ids;
    private double[] weights;
    private int[] prices;
    private String productsSpecs;

    public Input(double maxBoxWeight, String productsSpecs) {
        setMaxBoxWeight(maxBoxWeight);
        setproductsSpecs(productsSpecs);
    }

    public Input() {
    }

    public Input(int[] ids, double[] weights, int[] prices) {
        this.ids = ids;
        this.weights = weights;
        this.prices = prices;
    }

    public void setMaxBoxWeight(double maxBoxSize) {
        if ((maxBoxSize > 0) && (maxBoxSize <= 100))
            this.maxBoxWeight = maxBoxSize;
        else
            throw new OutOfRangeException("Box Size");
    }

    public void setproductsSpecs(String productsSpecs) {
        String[] parsedproducts = new Parsing().splitByParentheses(productsSpecs);
        int productsNumber = parsedproducts.length;
        if (productsNumber <= 15)
            this.productsSpecs = productsSpecs;
        else
            throw new OutOfRangeException("Max Box Size");
    }

    public Input productsToArrays(List <Product> products) {
        

        ids = products.stream().mapToInt(Product::getId).toArray();
        weights = products.stream().mapToDouble(Product::getWeight).toArray();
        prices = products.stream().mapToInt(Product::getPrice).toArray();

        return new Input(ids , weights,prices);
    }

    public int[] getIds() {
        return this.ids;
    }

    public double[] getWeights() {
        return this.weights;
    }

    public int[] getPrices() {
        return this.prices;
    }

    public double getMaxBoxWeight() {
        return this.maxBoxWeight;
    }
}
