package org.boxing;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter Max box weight: ");
        Double maxBoxWeiht = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter packs specification as a string: ");
        String specs = scanner.nextLine();
        scanner.close();

        Input input = new Input(maxBoxWeiht, specs);
        List<Product> products = new Parsing().parseAllProducts(specs);
        input.productsSpecsToArrays(products);
        List<Integer> selectedItems = KnapsackAlgorithm.findOptimalSelection(products, input.getWeights(), input.getPrices(), maxBoxWeiht);
        System.out.println("Selected item[s] id: " + selectedItems);        
}
}