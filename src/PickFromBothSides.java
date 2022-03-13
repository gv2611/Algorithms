public class PickFromBothSides {
  public int pick(int[] A, int B) {
    int N = A.length;
    int sum = 0;
    for (int i = 0; i < B; i++) {
      sum += A[N - i - 1];
    }
    int maxSum = sum;
    for (int i = 0; i < B; i++) {
      sum += A[i];
      sum -= A[N - B + i];
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }

  public static void printArray(int arr[])
  {
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i]+" ");
    }
    System.out.println();

  }

  public static void main(String[] args)
  {
    PickFromBothSides pic= new PickFromBothSides();
    int arr[]={5, -2, 3 , 1, 2};
    int arr2[]={1, 2};
    // System.out.println(remove.removeElement(arr2, 2));
    System.out.println(pic.pick(arr2, 1));
    System.out.println(pic.pick(arr, 3));



    //printArray(arrOut);


  }
}
