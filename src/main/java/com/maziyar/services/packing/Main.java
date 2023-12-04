package com.maziyar.services.packing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Max box size");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter specs");
        String specs = scanner.nextLine();
        scanner.close();
        Input input = new Input(n, specs);
        input.productsToArrays();
        Knapsack knapsack = new Knapsack(input);
        System.out.println(knapsack.knapsackDP());
        System.out.println(input);
        
    }
}