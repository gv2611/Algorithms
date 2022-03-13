public class SquareOfASortedArray {

  public int[] sortedSquares(int[] nums) {
    int l=0, r=nums.length-1;
    int n=nums.length;
    int arr[]=new int[n];


    for(int i=n-1;i>=0;i--)
    {

      if(Math.abs(nums[l])>nums[r])
      {
        arr[i]=nums[l]*nums[l];
        l++;
      }
      else
      {
        arr[i]=nums[r]*nums[r];
        r--;
      }
    }

    return arr;
  }

  public static void main(String[] args)
  {
    SquareOfASortedArray square = new SquareOfASortedArray();
    int nums[]={-7,-3,2,3,11};
    int arr[]=square.sortedSquares(nums);
    for(int i=0;i<arr.length;i++)
    {
      System.out.println(arr[i]);
    }

  }
}
