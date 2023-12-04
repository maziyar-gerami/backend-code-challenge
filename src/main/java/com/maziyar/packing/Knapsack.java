// package com.maziyar.packing;

// import java.util.LinkedList;
// import java.util.List;

// // A Dynamic Programming based solution for 0-1 Knapsack problem
// class Knapsack
// {



//     // Returns the maximum value that can be put in a knapsack of capacity maxWeight
//     static int knapSack(int maxWeight, List<Commodity> commodities, int n)
//     {
//         int i, w;
//         int K[][] = new int[n+1][maxWeight+1];

//         // Build table K[][] in bottom up manner
//         for (i = 0; i <= n; i++)
//         {
//             System.out.println("hi");
//             for (w = 0; w <= maxWeight; w++)
//             {
//                 if (i==0 || w==0)
//                     K[i][w] = 0;
//                 else if (commodities.get(i-1).getWeight() <= w)
//                     K[i][w] = Math.max(commodities.get(i-1).getValue() + K[i-1][w-commodities.get(i-1).getWeight()],  K[i-1][w]);
//                 else
//                     K[i][w] = K[i-1][w];
//             }
//         }

//         return K[n][maxWeight];
//     }


//     // Driver program to test above function 
//     public static void main(String args[])
//     {
//         Commodity c1 = new Commodity(1,53.38f,45);
//         Commodity c2 = new Commodity(2,88.62f,98);
//         Commodity c3 = new Commodity(4,78.48f,3);
//         Commodity c4 = new Commodity(4,72.30f,76);
//         Commodity c5 = new Commodity(5,30.18f,9);
//         Commodity c6 = new Commodity(6,46.34f,48);

//         List<Commodity> commodities = new LinkedList<>();
//         commodities.add(c1);
//         commodities.add(c2);
//         commodities.add(c3);
//         commodities.add(c4);
//         commodities.add(c5);
//         commodities.add(c6);

//         int  W = 81;
//         int n = 6;
//         System.out.println(knapSack(W, commodities, n));
//     }
// }
// /*This code is contributed by Rajat Mishra */