package com.maziyar.services.packing;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.maziyar.exception.OutOfRangeException;

public class InputTest {

    Input input = new Input();
    @Test
    public void setMaxBoxSize(){

        Assertions.assertThrows(OutOfRangeException.class, ()-> {input.setMaxBoxWeight(110);},
                "When the Maximum size of a box is more then 10, an Exception should be raised");

        Assertions.assertThrows(OutOfRangeException.class, ()-> {input.setMaxBoxWeight(0);},
                "When the Maximum size of a box is 0 or less, an Exception should be raised");
    }

    @Test
    void setCommoditiesSpecs() {
        String spec= "(1,15.3,$34)";
        String sixteenSpecs = spec.repeat(16);
        Assertions.assertThrows(OutOfRangeException.class, ()-> {input.setproductsSpecs(sixteenSpecs);},
                "When the Maximum number of Specifications is More then 15, an Exception should be raised");
    }
}
