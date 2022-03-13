public class RotateArray {

  public void rotate(int[] nums, int k) {
    int arr[]=new int[nums.length];
    int iter=0;

    if(k>nums.length)
    {
      k=k%nums.length;
    }

    for (int i = nums.length - k; i < nums.length; i++) {
        arr[iter] = nums[i];
        iter++;
      }
      for (int i = 0; i < nums.length - k; i++) {
        arr[iter] = nums[i];
        iter++;
      }


    for(int i=0;i<nums.length;i++)
    {
      nums[i]=arr[i];
    }
    for(int i=0;i<nums.length;i++)
    {
      System.out.println(nums[i]);
    }


  }
  public static void main(String[] args) {
    RotateArray rotate= new RotateArray();
    int nums[]={-1};
    int k=3;
    rotate.rotate(nums,k);
  }
  }


