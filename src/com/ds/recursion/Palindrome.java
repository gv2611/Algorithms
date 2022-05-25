package com.ds.recursion;


public class Palindrome {

  public static void main(String[] args)
  {
    Palindrome palin = new Palindrome();
//  boolean check=palin.checkIfPalindrome(2002);
//  System.out.println(check);
    String str= String.valueOf(202102);
//  String str="nitin";
    char ch[]= str.toCharArray();
    boolean check2=palin.checkIfPalindrome2(str, 0, str.length()-1, 0);
    System.out.println(check2);


  }

  private boolean checkIfPalindrome(int n) {

    if(n/10 < 1)
    {
      return true;
    }
      checkIfPalindrome(n%10);
    return false;
  }

  private void debug(int spaces, String msg) {
    for (int i = 0; i < spaces; i++) {
      System.out.print(" ");
    }
    System.out.println(msg);
  }

  private boolean checkIfPalindrome2(String str, int start, int end, int spaces) {
    debug(spaces, start + ", " + end);

    if(start == end && str.charAt(start) == str.charAt(end)) {
      return true;
    }
    debug(spaces, "Start end not equal");
    if(str.charAt(start) != str.charAt(end)) {
      return false;
    }
    return checkIfPalindrome2(str, start+1, end-1, spaces + 2);
  }
}
