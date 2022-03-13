public class MaxProd {

  public int maxSpecialProduct(int A[]) {
    int n=A.length;
    int left[]= new int[n];
    int right[] = new int[n];
    left[0]=0;
    right[n-1]=0;

    for(int i=1;i<A.length;i++)
    {
      int j=i-1;

      while(j>0)
      {
        if(A[j]>A[i])
        {
          left[i]=j;
          break;
        }
        j=left[j];
      }

    }

    for(int i=n-2;i>=0;i--)
    {
      int j=i+1;
      while(j>0)
      {
        if( A[j]>A[i])
        {
          right[i]=j;
          break;
        }
        j=right[j];
      }
    }
    printArray(left);
    printArray(right);

    int maxprod=Integer.MIN_VALUE;
    int maxProd[]=new int[n];
    for(int i=0;i<n;i++)
    {
      int prod=left[i]*right[i];
      if(prod>maxprod)
      {
        maxprod=prod;
      }
    }
    return maxprod;
  }
  public static void printArray(int arr[])
  {
    int n=arr.length;
    for(int i=0;i<n;i++)
    {
      System.out.print(" "+arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args)
  {
    MaxProd maxProd = new MaxProd();
    int arr[]={1, 4, 3, 4};
    System.out.println(maxProd.maxSpecialProduct(arr));
  }

}
