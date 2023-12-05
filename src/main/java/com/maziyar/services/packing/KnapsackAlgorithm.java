package com.maziyar.services.packing;

import java.util.ArrayList;
import java.util.List;

public class KnapsackAlgorithm {

    public static List<Integer> findOptimalSelection(Product[] products, double[] weights, int[] prices, double maxWeight) {
        int n = products.length;

        // Initialize a 2D array to store the optimal values
        int[][] m = new int[n + 1][(int) maxWeight + 1];

        // Populate the array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (weights[i - 1] <= w) {
                    m[i][w] = Math.max(m[i - 1][w], m[i - 1][(int) (w - weights[i - 1])] + prices[i - 1]);
                } else {
                    m[i][w] = m[i - 1][w];
                }
            }
        }

        // Backtrack to find the selected items
        List<Integer> selectedItems = new ArrayList<>();
        int i = n;
        int w = (int) maxWeight;
        while (i > 0 && w > 0) {
            if (m[i][w] != m[i - 1][w]) {
                selectedItems.add(products[i - 1].getId());
                w -= weights[i - 1];
            }
            i--;
        }

        return selectedItems;
    }

    public static void main(String[] args) {
        // Example usage
        Product[] products = {
            new Product(1, 53.38, 45),
            new Product(2, 88.62, 98),
            new Product(3, 78.48, 3),
            new Product(4, 72.30, 76),
            new Product(5, 30.18, 9),
            new Product(6, 46.34, 48)
        };

        double[] weights = {53.38, 88.62, 78.48, 72.30, 30.18,46.34};
        int[] prices = {45, 98, 3, 76, 9,48};

        double maxWeight = 81.0;

        List<Integer> selectedItems = findOptimalSelection(products, weights, prices, maxWeight);

        System.out.println("Selected Product IDs: " + selectedItems);
    }
}

