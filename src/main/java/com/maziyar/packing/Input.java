package com.maziyar.packing;

import com.maziyar.exception.OutOfRangeException;

public class Input {
    private byte maxBoxSize;
    private String commoditiesSpecs;

    public void setMaxBoxSize(byte maxBoxSize) {
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

}
