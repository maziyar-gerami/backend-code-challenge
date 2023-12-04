package com.maziyar.services.packing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parsing {
    public Product parseOneParentheses(String commoditySpecs){
        short inputLength = (short) commoditySpecs.length();
        String inputWithoutParentheses = commoditySpecs.substring(1,inputLength-1);
        List<String> separatedList = Arrays.asList(inputWithoutParentheses.split(","));
        int id = Integer.valueOf(separatedList.get(0));
        float weight = Float.valueOf(separatedList.get(1));
        String valueWithoutDollarSign = (separatedList.get(2)).substring(1);
        int value = Integer.valueOf(valueWithoutDollarSign);
        return new Product (id, weight, value);
    }

    public String[] splitByParentheses(String input) {
        String inputWithoutSpacing = input.replaceAll("\\s", "");
        return inputWithoutSpacing.split("(?<=\\))|(?=\\()");
    }

public  List<Product> commoditiesToArrays(String input){
        String [] split = splitByParentheses(input);

        List<Product> allCommodities = new LinkedList<>();
        for (String s:split)
            allCommodities.add(parseOneParentheses(s));
        
            return allCommodities;
}


}


