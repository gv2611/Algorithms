package com.ds.recursion;

public class FindGreatest {
  public static void main(String[] args)
  {
    FindGreatest find = new FindGreatest();
    int arr[] ={12,2,32,65,78,5,200,5};
    int great=find.findGreatest(arr,arr.length);
    System.out.println(great);
  }

  private int findGreatest(int[] arr, int length) {
    int greatest;
    if(length==1)
      return arr[0];
    else
       greatest=findGreatest(arr,length-1);
    if(arr[length-1] > greatest)
      return arr[length-1];
    else
      return greatest;
  }
}
