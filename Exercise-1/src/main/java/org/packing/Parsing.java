package org.packing;

import java.util.Arrays;
import java.util.List;

public class Parsing {

    String input;


    public Commodity parseOne(String input){
        short inputLength = (short) input.length();
        String inputWithoutParentheses = input.substring(1,inputLength-1);
        List<String> separatedList = Arrays.asList(inputWithoutParentheses.split(","));
        byte id = Byte.parseByte(separatedList.get(0));
        float weight = Float.valueOf(separatedList.get(1));
        String valueWithoutDollarSign = (separatedList.get(2)).substring(1);
        byte value = Byte.parseByte(valueWithoutDollarSign);
        return new Commodity (id, weight, value);
    }
}
