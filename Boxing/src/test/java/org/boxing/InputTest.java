package org.boxing;

import org.exception.OutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTest {

    Input input = new Input();

    @Test
    public void setMaxBoxSize_ShouldThrowException_WhenSizeExceedsLimit() {
        // Arrange, Act & Assert
        Assertions.assertThrows(OutOfRangeException.class, () -> {
            input.setMaxBoxWeight(110);
        }, "When the Maximum size of a box is more than 100, an Exception should be raised");

        Assertions.assertThrows(OutOfRangeException.class, () -> {
            input.setMaxBoxWeight(0);
        }, "When the Maximum size of a box is 0 or less, an Exception should be raised");
    }

    @Test
    void setCommoditiesSpecs_ShouldThrowException_WhenExceedingMaxSpecifications() {
        // Arrange
        String spec = "(1,15.3,$34)";
        String sixteenSpecs = spec.repeat(16);

        // Act & Assert
        Assertions.assertThrows(OutOfRangeException.class, () -> {
            input.setProductsSpecs(sixteenSpecs);
        }, "When the Maximum number of Specifications is More than 15, an Exception should be raised");
    }
}
