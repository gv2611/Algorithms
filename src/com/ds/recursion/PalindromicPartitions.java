package com.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromicPartitions {
  public static void main(String[] args)
  {
    PalindromicPartitions palin = new PalindromicPartitions();
    String str="nitin";
    ArrayList<String> all = new ArrayList<>();
    all=palin.findAllPalindromicPartitions(str);
    System.out.println(all);
  }

  private ArrayList<String> findAllPalindromicPartitions(String str) {
    ArrayList<String> al = new ArrayList<>(Arrays.asList("abc"));
    return al;


  }
}
