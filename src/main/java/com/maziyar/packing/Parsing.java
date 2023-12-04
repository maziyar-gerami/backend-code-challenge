package com.maziyar.packing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parsing {
    public Commodity parseOneParentheses(String commoditySpecs){
        short inputLength = (short) commoditySpecs.length();
        String inputWithoutParentheses = commoditySpecs.substring(1,inputLength-1);
        List<String> separatedList = Arrays.asList(inputWithoutParentheses.split(","));
        byte id = Byte.parseByte(separatedList.get(0));
        float weight = Float.valueOf(separatedList.get(1));
        String valueWithoutDollarSign = (separatedList.get(2)).substring(1);
        byte value = Byte.parseByte(valueWithoutDollarSign);
        return new Commodity (id, weight, value);
    }

    public String[] splitByParentheses(String input) {
        String inputWithoutSpacing = input.replaceAll("\\s", "");
        return inputWithoutSpacing.split("(?<=\\))|(?=\\()");
    }

public  List<Commodity> commoditiesToArrays(String input){
        String [] split = splitByParentheses(input);

        List<Commodity> allCommodities = new LinkedList<>();
        for (String s:split)
            allCommodities.add(parseOneParentheses(s));
        
            return allCommodities;
}

}
