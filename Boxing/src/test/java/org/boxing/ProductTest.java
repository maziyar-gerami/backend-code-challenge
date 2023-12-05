package org.boxing;

import org.exception.OutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private static Product product;

    @BeforeAll
    public static void setup() {
        product = new Product();
    }

    @Test
    public void weightRangeCheck_ShouldNotThrowExceptionInRange() {
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> {
            product.setWeight(55.1f);
        });

        // Assert
        Assertions.assertThrows(OutOfRangeException.class, () -> {
            product.setWeight(101);
        }, "Weight should be between 0 and 100; Else it should trigger an OutOfRangeException");
        Assertions.assertThrows(OutOfRangeException.class, () -> {
            product.setWeight(0);
        }, "Price should be between 0 and 100; Else it should trigger an OutOfRangeException");
    }

    @Test
    public void valueRangeCheck_ShouldNotThrowExceptionInRange() {
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> {
            product.setPrice(55);
        });

        // Assert
        Assertions.assertThrows(OutOfRangeException.class, () -> {
            product.setPrice(101);
        }, "Price should be between 0 and 100; Else it should trigger an OutOfRangeException");
        Assertions.assertThrows(OutOfRangeException.class, () -> {
            product.setPrice(0);
        }, "Price should be between 0 and 100; Else it should trigger an OutOfRangeException");
    }
}
