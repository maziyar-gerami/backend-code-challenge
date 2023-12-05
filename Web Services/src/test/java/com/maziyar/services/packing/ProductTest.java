package com.maziyar.services.packing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.maziyar.exception.OutOfRangeException;
import com.maziyar.web_services.boxing.Product;

public class ProductTest {
    private static Product product;
    @BeforeAll
    public static void setup(){
        product = new Product();
    }

    @Test
    public void weightRangeCheck(){
        Assertions.assertDoesNotThrow(() -> {product.setWeight(55.1f);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {product.setWeight(101);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {product.setWeight(0);});
    }

    @Test
    public void valueRangeCheck(){
        Assertions.assertDoesNotThrow(() -> {product.setPrice(55);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {product.setPrice(101);});
        Assertions.assertThrows(OutOfRangeException.class,()-> {product.setPrice(0);});
    }
}
