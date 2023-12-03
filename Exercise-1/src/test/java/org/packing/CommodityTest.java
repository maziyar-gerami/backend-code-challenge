package org.packing;

import org.exception.OutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CommodityTest {
    private static Commodity commodity;
    @BeforeAll
    public static void setup(){
        commodity = new Commodity();
    }

    @Test
    public void weightRangeCheck(){
        Assertions.assertDoesNotThrow(() -> {commodity.setWeight(55.1f);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {commodity.setWeight(101);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {commodity.setWeight(0);});
    }

    @Test
    public void valueRangeCheck(){
        Assertions.assertDoesNotThrow(() -> {commodity.setValue((byte) 55);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {commodity.setValue((byte) 101);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {commodity.setValue((byte) 0);});
    }
}
