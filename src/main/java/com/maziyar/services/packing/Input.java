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

    public int[] getIds(){
        return this.ids;
    }

    public int[] getWeights(){
        return this.weights;
    }

    public int[] getPrices(){
        return this.prices;
    }

    public int getMaxBoxSize(){
        return this.maxBoxSize;
    }


    public Input (int maxBoxSize , String commoditiesSpecs){
        setMaxBoxSize(maxBoxSize);
        setCommoditiesSpecs(commoditiesSpecs);
    }

    public void setMaxBoxSize(int maxBoxSize) {
        if ((maxBoxSize >0) && (maxBoxSize <= 100))
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

    public void listToArrays(){
        List<Product>  products = new Parsing().commoditiesToArrays(commoditiesSpecs);
        List<Integer> idList = new LinkedList<>();
        List<Integer> weightList = new LinkedList<>();
        List<Integer> priceList = new LinkedList<>();
        for (Product product : products) {
            idList.add(product.getId());
            weightList.add((int) (product.getWeight()*100));
            priceList.add(Integer.valueOf(product.getPrice()));
        }

        ids = idList.stream().mapToInt(Integer::intValue).toArray();
        prices = priceList.stream().mapToInt(Integer::intValue).toArray();
        weights = weightList.stream().mapToInt(Integer::intValue).toArray();
    }



}
