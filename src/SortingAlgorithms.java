public class SortingAlgorithms {

  public static int[] bubbleSort(int arr[])
  {
    int len=arr.length;
    for(int i=0;i<len-1;i++)
    {
      for(int j=0;j<len-i-1;j++)
      {
        if(arr[j]>arr[j+1])
        {
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
        }
      }
    }
    return arr;
  }

  public static int[] insertionSort(int arr[])
  {
    int len=arr.length;
    for(int i=1;i<len;i++)
    {
      int key=arr[i];
      int j=i-1;
      while (j>=0 && arr[j]>key)
      {
        arr[j+1]=arr[j];
        j=j-1;
      }
      arr[j+1]=key;
    }
    return arr;
  }

  void printArray(int arr[])
  {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args)
  {
    SortingAlgorithms sort= new SortingAlgorithms();
    int arr[]={64, 34, 25, 12, 22, 11, 90};
    int outputBubble[]=sort.bubbleSort(arr);
    sort.printArray(outputBubble);
    int arr2[]={64, 34, 25, 12, 22, 11, 90};

    int outputInsertion[]=sort.insertionSort(arr2);
    sort.printArray(outputInsertion);


  }

}
