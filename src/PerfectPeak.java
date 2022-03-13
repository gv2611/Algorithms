public class PerfectPeak {

  public int perfectPeak(int[] A) {

    for(int i=0; i<A.length;i++)
    {
      int maxLeft=Integer.MIN_VALUE;
      int minRight = Integer.MAX_VALUE;
      if(i>0 && i< A.length-1)
      {
        for(int j=0;j<i;j++)
        {
          if(A[j]>maxLeft)
            maxLeft=A[j];

        }
        for(int k=i+1;k<A.length;k++)
        {
          if(A[k]<minRight)
            minRight=A[k];
        }
        if(maxLeft< A[i] && minRight>A[i])
          return 1;
      }
    }
    return 0;
  }

  public int perfectPeak2(int[] A) {
    int minArr[]=new int[A.length];
    int maxArr[]=new int[A.length];
    int max = A[0];
    int min=A[A.length-1];
    maxArr[0]=A[0];
    minArr[A.length-1]=A[A.length-1];

    for(int i=1;i<A.length;i++)
    {
          if(A[i]>max)
            max=A[i];
          maxArr[i]=max;
    }
    for(int i=A.length-2 ; i>=0; i--)
    {
      if(A[i]<min)
        min=A[i];
      minArr[i]=min;
    }
    printArray(minArr);
    printArray(maxArr);

    for(int i=1;i<A.length-1;i++)
    {
      if(maxArr[i]==minArr[i] && A[i]<minArr[i+1] && A[i]>maxArr[i-1] ) {
        System.out.println("For element at "+i+" which is "+A[i]);
        return 1;
      }
    }
    return 0;
  }

  public static void printArray(int arr[])
  {
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i]+"   ");
    }
    System.out.println();
  }


    public static void main(String[] args)
  {
    PerfectPeak pp = new PerfectPeak();
    int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
    int arr2[]={5, 1, 4, 4};
    int arr3[]={9488, 25784, 5652, 9861, 31311, 8611, 1671, 7129, 28183, 2743, 11059, 4473, 7927, 21287, 2259, 7214, 32529};
    int arr4[]={ 0, 1, 3, 4, 5, 4, 3, 2, 3, 10};
    int arr5[]={9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712, 17036, 31323, 8724, 28254, 28704, 26300, 25548, 15142, 12860, 19913, 32663, 32758};
    System.out.println(pp.perfectPeak2(arr4));
  }
}
