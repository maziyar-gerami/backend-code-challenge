package com.maziyar.services.packing;

import java.util.LinkedList;
import java.util.List;

import com.maziyar.exception.OutOfRangeException;

public class Input {
    private int maxBoxSize;
    private int[] ids;
    private int[] weights;
    private int[] prices;
    private String commoditiesSpecs;

    public Input(int maxBoxSize, String commoditiesSpecs) {
        setMaxBoxSize(maxBoxSize);
        setCommoditiesSpecs(commoditiesSpecs);
    }

    public void setMaxBoxSize(int maxBoxSize) {
        if ((maxBoxSize > 0) && (maxBoxSize <= 100))
            this.maxBoxSize = maxBoxSize;
        else
            throw new OutOfRangeException("Box Size");
    }

    public void setCommoditiesSpecs(String commoditiesSpecs) {
        String[] parsedCommodities = new Parsing().splitByParentheses(commoditiesSpecs);
        int commoditiesNumber = parsedCommodities.length;
        if (commoditiesNumber <= 15)
            this.commoditiesSpecs = commoditiesSpecs;
        else
            throw new OutOfRangeException("Max Box Size");
    }

    public void productsToArrays() {
        List<Product> products = new Parsing().commoditiesToArrays(commoditiesSpecs);

        ids = products.stream().mapToInt(Product::getId).toArray();
        weights = products.stream().mapToInt(product -> (int) (product.getWeight() * 100)).toArray();
        prices = products.stream().mapToInt(Product::getPrice).toArray();
    }

    public int[] getIds() {
        return this.ids;
    }

    public int[] getWeights() {
        return this.weights;
    }

    public int[] getPrices() {
        return this.prices;
    }

    public int getMaxBoxSize() {
        return this.maxBoxSize;
    }
}
