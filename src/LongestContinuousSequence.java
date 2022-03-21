public class LongestContinuousSequence {

  public static int longestContinuousSequence(int[] arr) {
    int index = 0;
    int result = -1;
    int MAX_ONES = Integer.MIN_VALUE;

    int countOfOnes = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        index = i;
        countOfOnes=0;
      }
      if (arr[i] == 1) {
        countOfOnes++;
        if (countOfOnes > MAX_ONES) {
          result = index;
          MAX_ONES = countOfOnes;
        }
        continue;

      }

    }
    return result;


  }

    public static void main (String[] args) {

      LongestContinuousSequence longest= new LongestContinuousSequence();
      int arr[]={0,1,0,1,1,0,1,1,1,0,1};
      System.out.println(longest.longestContinuousSequence(arr));

    }
    }
