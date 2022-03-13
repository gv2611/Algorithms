public class RemoveElement {
  public int[] removeElement(int[] nums, int val) {
    int l=0,r=nums.length-1;
    printArray(nums);
    if(nums.length==1 && val==nums[0])
      nums=null;
    while(l<r)
    {
      if(nums[l]==val && nums[r]!=val)
      {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
        r--;
      }
      if(nums[r]==val && nums[l]!=val)
      {
        r--;
        l++;
      }

      if(nums[l]==val && nums[r]==val)
      {
        r--;
      }
      else
        l++;

    }
    return nums;

  }

  public int removeElement2(int[] nums, int val) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[count++] = nums[i];
      }
    }
    printArray(nums);
    return count;

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
    RemoveElement remove= new RemoveElement();
    int arr[]={3,2,2,3};
    int arr2[]={0,1,2,2,3,0,4,2};
    int arr3[]={1};
    System.out.println(remove.removeElement2(arr3, 1));
   // int arrOut[]=remove.removeElement2(arr3, 1);
   // printArray(arrOut);


  }
}
