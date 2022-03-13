import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> listOf3Sums = new ArrayList<List<Integer>>();
    int len = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < len-1; i++) {

      int sum = 0;
      int l = i + 1;
      int r = len - 1;
      while (l < r) {
        sum = nums[i] + nums[l] + nums[r];
        if (sum == 0) {
          List<Integer> oneTriplet = new ArrayList<Integer>();
          oneTriplet.add(nums[i]);
          oneTriplet.add(nums[l]);
          oneTriplet.add(nums[r]);
          listOf3Sums.add(oneTriplet);
          while(l+1<r &&  nums[l+1]==nums[l])
            l++;
          while(r-1>l &&  nums[r-1]==nums[r])
            r--;

        }
        if (sum > 0) {
          r--;
        } else {
          l++;
        }
      }
      while(i+1<len && nums[i+1]==nums[i]) i++;

    }
    return listOf3Sums;
  }

  public int threeSumClosest(int[] nums, int target) {

    int len = nums.length;
    int minDiff = Integer.MAX_VALUE;
    int finalSum = Integer.MAX_VALUE;

    Arrays.sort(nums);
    for (int i = 0; i < len - 1; i++) {

      int sum = 0;
      int l = i + 1;
      int r = len - 1;
      while (l < r) {
        sum = nums[i] + nums[l] + nums[r];
        int diff = target - sum;
        diff=Math.abs(diff);
        if (diff < minDiff) {
          minDiff = diff;
          finalSum = sum;
        }
        if (sum > target) {
          r--;
        } else {
          l++;
        }

      }
    }
    return finalSum;
  }



  public static void printListOfList(List<List<Integer>> al)
  {
    for(int i=0;i<al.size();i++)
    {
      for(int j=0;j<al.get(i).size();j++)
      {
        System.out.print(al.get(i).get(j)+" ");

      }
      System.out.println();
    }

  }



  public static void main(String[] args)
  {
    ThreeSum three = new ThreeSum();
    int arr[]={-1,0,1,2,-1,-4};
    int arr2[]={-1,2,1,-4};
    int arr3[]={1,1,1,0};
    int target2=-100;
    int target=1;
   // List<List<Integer>> listOf3SumsOutput = new ArrayList<List<Integer>>();
    //listOf3SumsOutput=three.threeSum(arr);
  //  System.out.println(listOf3SumsOutput.size());
   // printListOfList(listOf3SumsOutput);

    System.out.println(three.threeSumClosest(arr2,target));


  }


}
