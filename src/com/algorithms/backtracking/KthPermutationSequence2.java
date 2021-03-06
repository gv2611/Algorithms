package com.algorithms.backtracking;

import java.util.ArrayList;

public class KthPermutationSequence2 {

  public String getPermutation(int A, int B) {
    ArrayList<Integer> candidateSet = new ArrayList<>();
    for (int i = 1; i <= A; i++) {
      candidateSet.add(i);
    }
    return getPermutation(B - 1, candidateSet);
  }


  private static String getPermutation(int k, ArrayList<Integer> candidateSet) {
    int n = candidateSet.size();
    if (n == 0) {
      return "";
    }
    if (k > factorial(n)) return ""; // invalid. Should never reach here.

    int f = factorial(n - 1);
    int pos = k / f;
    k %= f;
    String ch = String.valueOf(candidateSet.get(pos));
    // now remove the character ch from candidateSet.
    candidateSet.remove(pos);
    return ch + getPermutation(k, candidateSet);
  }

  static int factorial(int n) {
    if (n > 12) {
      // this overflows in int. So, its definitely greater than k
      // which is all we care about. So, we return INT_MAX which
      // is also greater than k.
      return Integer.MAX_VALUE;
    }
    // Can also store these values. But this is just < 12 iteration, so meh!
    int fact = 1;
    for (int i = 2; i <= n; i++) fact *= i;
    return fact;
  }

  public static void main(String[] args) {
    KthPermutationSequence2 sequence = new KthPermutationSequence2();
    int n = 5, k = 7;

    String str = sequence.getPermutation(n, k);
    System.out.println(str);
  }
}