public class MaximumSumTriplet {

  public int maximumTriplet(int[] A) {
    int preComputeSum[]=preComputeMax(A);
    int maxSum= Integer.MIN_VALUE;

    for(int i=0;i<A.length-1;i++)
    {
      for(int j=i+1; j<A.length;j++)
      {
        if(A[i]<A[j]) {
          int sum = A[i] + preComputeSum[j];
          if (sum > maxSum) {
            maxSum = sum;
        //    System.out.println("i="+i+" j="+j+" sum="+sum+" maxSum="+maxSum);
          }
        }
      }
    }
    return maxSum;
  }

  public int[] preComputeMax(int arr[])

      //calculate cumulative max value from right to left
  {
    int preComputeMax[]=new int[arr.length];
    int maxValue = Integer.MIN_VALUE;

    for(int i=arr.length-1; i>=0;i--)
    {
      if(arr[i]>maxValue)
      {
        maxValue=arr[i];
      }
      preComputeMax[i]=maxValue;

    }
      //calculate the max sum at i for values from n-1 to i

    int preComputeSum[]= new int[arr.length];
    for(int i=preComputeMax.length-1; i>=0;i--)
    {
      if(arr[i]!=preComputeMax[i]) {
        preComputeSum[i] = preComputeMax[i] + arr[i];
      }
    }
    return preComputeSum;
  }


  public int maxSumTriplet(int arr[])
  {
    int ans = 0;
    int n=arr.length;

    for (int i = 1; i < n - 1; ++i) {
      int max1 = 0, max2 = 0;

      for (int j = 0; j < i; ++j)
        if (arr[j] < arr[i])
          max1 = Math.max(max1, arr[j]);

      for (int j = i + 1; j < n; ++j)
        if (arr[j] > arr[i])
          max2 = Math.max(max2, arr[j]);

      if(max1 > 0 && max2 > 0)
        ans = Math.max(ans, max1 + arr[i] + max2);
    }

    return ans;
  }

//prints an array
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
    MaximumSumTriplet max= new MaximumSumTriplet();
    int arr[]={2, 5, 3, 1, 4, 9};
    int arr2[]={1,2,3};
    int arr3[]={18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605};
    System.out.println(max.maxSumTriplet(arr));
  }
}
