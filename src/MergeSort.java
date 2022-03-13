public class MergeSort {

  public static void printArray(int arr[], int n)
  {
    for(int i=0;i<n;i++)
    {
      System.out.println(arr[i]);
    }
  }

  public static void mergeSort(int arr[], int left, int right)
  {
    if(left<right)
    {
      int middle=left+(right-left)/2;
      mergeSort(arr,left,middle);
      mergeSort(arr,middle+1,right);
      merge(arr,left,middle,right);
    }
  }

  public static void merge(int arr[], int left, int middle, int right)
  {
    int length1=middle-left+1;
    int length2=right-middle;

    int L[]=new int [length1];
    int R[]= new int [length2];

    for(int i=0; i<length1;i++)
    {
      L[i]=arr[left+i];
    }
    for (int j = 0; j < length2; ++j) {
      R[j] = arr[middle + 1 + j];
    }
    int i=0,j=0,iter=left;

    while (i<length1 && j<length2)
    {
      if(L[i]<=R[j])
      {
        arr[iter]=L[i];
        i++;
      }
      else
      {
        arr[iter]=R[j];
        j++;
      }
      iter++;

    }

    while(i<length1)
    {
      arr[iter]=L[i];
      i++;
      iter++;
    }

    while(j<length2)
    {
      arr[iter]=R[j];
      j++;
      iter++;
    }
  }

  public static void main(String[] args)
  {
    MergeSort mergeSort= new MergeSort();
    int[] arr = { 10, 7, 8, 9, 1, 5 };
    int n = arr.length;

    mergeSort(arr, 0, n - 1);
    System.out.println("Sorted array: ");
    printArray(arr, n);
  }
}
