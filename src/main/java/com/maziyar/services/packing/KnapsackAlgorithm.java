package com.maziyar.services.packing;

import java.util.ArrayList;
import java.util.List;

public class KnapsackAlgorithm {

    public static List<Integer> findOptimalSelection(List<Product> productList, double[] weights, int[] prices, double maxWeight) {
        int n = productList.size();
        Product[] productArray = productList.toArray(new Product[n]);


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
                selectedItems.add(productArray[i - 1].getId());
                w -= weights[i - 1];
            }
            i--;
        }

        return selectedItems;
    }
}

