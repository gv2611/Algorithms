package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class KthPermutationSequence {
  ArrayList<String> al = new ArrayList<>();

  public static void main(String[] args)
  {
    KthPermutationSequence sequence = new KthPermutationSequence();
    int n=5, k=7;

    String str= sequence.getPermutation(n,k);
    System.out.println(str);
  }

  private String getPermutation(int n, int k) {
    StringBuffer str=new StringBuffer();
    for(int i=1;i<=n;i++)
    {
      str=str.append(i);
    }
    permute(str.toString(),0,n-1);
    Collections.sort(al);
    System.out.println(al);
    return al.get(k-1);
  }

  private void permute(String str, int l, int r) {

    if(l==r)
      al.add(str.toString());

    else
    {
      for(int i=l; i<=r;i++)
      {
        str=swap(str, l, i);
        permute(str, l+1, r);
        str=swap(str, l,i);
      }
    }

  }

  private String swap(String str, int i, int j) {
    char temp;
    char[] charArray = str.toCharArray();
    temp = charArray[i] ;
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);

  }
}
