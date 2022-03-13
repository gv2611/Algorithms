public class NearestSmallerElement {

  public static void main(String[] args)
  {
    NearestSmallerElement near= new NearestSmallerElement();
    int arr[]=  {34, 35, 27, 42, 5, 28, 39, 20, 28};
    int result[]=near.findNearestSmallerElement(arr);
    printArray(result);
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

  public static int[] initializeArray(int arr[])
  {
    for(int i=0;i<arr.length;i++)
    {
      arr[i]=-1;
    }
    return arr;
  }

  private int[] findNearestSmallerElement(int[] arr) {
    int G[]= new int[arr.length];
    G[0]=-1;
    initializeArray(G);

    for(int i=1; i<arr.length;i++)
    {
      int j=i-1;
      while(j>=0)
      {
        if(arr[j]<arr[i])
        {
          G[i]=arr[j];
          break;
        }
        j--;
      }

     // G[j]=-1;

    }
    return G;

  }
}
