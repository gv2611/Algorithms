package com.algorithms.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Combinations {
  public int[][] combine(int n, int k) {
    int arr[][]= new int[4][4];
    ArrayList<Integer> al = new ArrayList<>();

    ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
    for(int i=1;i<=n;i++)
    {
      al.add(i);
    }


return arr;
  }

//  If n = 4 and k = 2, a solution is:
//
//  [
//      [1,2],
//      [1,3],
//      [1,4],
//      [2,3],
//      [2,4],
//      [3,4],
//      ]

  public static void print2dArray(int arr[][])
  {
    int rows=arr.length;
    int columns=arr[0].length;

    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<columns;j++) {
        System.out.print(" " + arr[i][j]);
      }
      System.out.println();
    }
  }
  public static void main(String[] args)
  {

    Combinations combination = new Combinations();
    int n = 5, k = 7;
   // int[][] comb = combination.combine(n, k);

  }
}
