package com.algorithms.backtracking;

import java.util.ArrayList;

public class NQueens {
  public static void main(String[] args)
  {
    NQueens nqueens= new NQueens();
    ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
//    al=nqueens.solveNQueens(8);
//    System.out.println(al);
  }

//  private ArrayList<ArrayList<String>> solveNQueens(int a) {
//    ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
//    ArrayList<String> row = new ArrayList<String>();
//
//    if(a==)
//
//    char arr[][] = new char[a][a];
//    char arrNew[][]=initializeToBlank(arr, a);
//    int firstRow=0;
//
//    for(int i =1;i<a;i++)
//    {
//      arrNew[0][firstRow]=1;
//      for(int j=1;j<a;j++)
//      {
//        if(isSafe(arrNew,i,j,a))
//        {
//          arrNew[i][j]
//
//        }
//
//
//      }
//    }
//
//  }

  public boolean isSafe(char arr[][], int i, int j, int size)
  {
    return false;

  }





  private char[][] initializeToBlank(char[][] arr, int n) {

    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        arr[i][j]='_';
      }
    }
    return arr;
  }
}
