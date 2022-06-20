package com.ds.recursion;

import java.util.ArrayList;

public class AllPossibleStrings {
  static ArrayList<String> allStrings = new ArrayList<>();


  public void allPossibleStrings(char[] letters,  String prefix, int n,int k)
  {
    if(k==0)
    {
      allStrings.add(prefix);
      return ;
    }
    for(int i=0;i<n;i++)
    {
      String newPrefix = prefix + letters[i];
    }



  }

  public static void main(String[] args)
  {
    char[] ch= {'a','b'};
    AllPossibleStrings aps = new AllPossibleStrings();
    aps.allPossibleStrings(ch, "", 2,3);
    System.out.println(allStrings);


  }

}
