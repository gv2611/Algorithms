import java.util.Arrays;

public class BinarySearch {

  public int search(int[] nums, int target) {


    int min=0, max=nums.length-1;
    while(min<=max) {
      int mid = min+(max-min)/2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        min = mid + 1;
      } else if (nums[mid] > target) {
        max = mid - 1;
      }
    }
      return -1;

  }
  public static void main(String[] args)
  {
    BinarySearch bs= new BinarySearch();
    int num[]={5,6,7,8,9,10,11};
    int target=7;
    System.out.println(bs.search(num,target));
  }
}

