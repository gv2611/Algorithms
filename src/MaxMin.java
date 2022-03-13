public class MaxMin {

  public int maxMin(int[] A) {
    int max= Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for(int i=0;i<A.length;i++)
    {
      if(A[i]>max)
      {
        max=A[i];
      }
      if(A[i]<min)
      {
        min = A[i];
      }
    }
    return max+min;

  }

  public static void main(String[] args)
  {
    MaxMin mm= new MaxMin();
    int arr[]={-2, 1, -4, 5, 3};
    int arr2[]={1, 3, 4, 1};
    System.out.println(mm.maxMin(arr2));

  }
}
