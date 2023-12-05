package com.maziyar.services.packing;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Max box size");
        //int n = scanner.nextInt();
        int n =81;
        //scanner.nextLine();
        //System.out.println("Enter specs");
        //String specs = scanner.nextLine();
        scanner.close();
        String specs = "(1,53.38,$45)(2,88.62,$98)(3,78.48,$3)(4,72.30,$76)(5,30.18,$9)(6,46.34,$48)";
        Input input = new Input(n, specs);
        List<Product> products = new Parsing().parseAllProducts(specs);
        input.productsToArrays(products);
        List<Integer> selectedItems = KnapsackAlgorithm.findOptimalSelection(products, input.getWeights(), input.getPrices(), (double) n);
        System.out.println("Selected item[s]: " + selectedItems);        
}
}