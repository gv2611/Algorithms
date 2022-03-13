public class RemoveDuplicates {
  public int removeDuplicates(int[] nums) {
    int extraElements=0;
    for(int i=0;i<nums.length-1;i++)
    {
      if(nums[i]==nums[i+1])
        extraElements++;
    }
    int iter=1;
    for(int i=0;i<nums.length-1;i++)
    {
      if(nums[i]==nums[i+1])
        continue;
      if(nums[i]!=nums[i+1])
      {
        nums[iter]=nums[i+1];
        iter++;
      }
    }
    printArray(nums);
    return nums.length-extraElements;
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
    RemoveDuplicates remove = new RemoveDuplicates();
    int arr[]={1,1,2,2,3,3,3,4,4};
    System.out.println(remove.removeDuplicates(arr));
  }
}
