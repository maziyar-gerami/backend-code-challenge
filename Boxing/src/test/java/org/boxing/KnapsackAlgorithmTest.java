package org.boxing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class KnapsackAlgorithmTest {

    @Test
    void findOptimalSelection_ShouldReturnCorrectSelection() {
        // Arrange
        List<Product> productList = Arrays.asList(
                new Product(1, 10.0, 60),
                new Product(2, 20.0, 100),
                new Product(3, 30.0, 80)
        );
        double[] weights = {10.0, 20.0, 30.0};
        int[] prices = {60, 100, 80};
        double maxWeight = 50.0;

        // Act
        List<Integer> selectedItems = KnapsackAlgorithm.findOptimalSelection(productList, weights, prices, maxWeight);

        // Assert
        Assertions.assertEquals(Arrays.asList(3, 2), selectedItems);
    }

    @Test
    void findOptimalSelection_ShouldReturnEmptyList_WhenMaxWeightIsZero() {
        // Arrange
        List<Product> productList = Arrays.asList(
                new Product(1, 10.0, 60),
                new Product(2, 20.0, 100),
                new Product(3, 30.0, 80)
        );
        double[] weights = {10.0, 20.0, 30.0};
        int[] prices = {60, 100, 80};
        double maxWeight = 0.0;

        // Act
        List<Integer> selectedItems = KnapsackAlgorithm.findOptimalSelection(productList, weights, prices, maxWeight);

        // Assert
        Assertions.assertTrue(selectedItems.isEmpty());
    }
}
