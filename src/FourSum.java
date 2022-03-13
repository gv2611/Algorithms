import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
  static class pair
  {
    int first,second;
    public pair(int first, int second)
    {
      this.first=first;
      this.second=second;
    }
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> listOf4Sums = new ArrayList<List<Integer>>();
    int len = nums.length;
    HashMap<Integer, pair> sumWithIndexes = new HashMap<Integer, pair>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        sumWithIndexes.put(sum, new pair(i, j));

      }
    }
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        int sum = nums[i] + nums[j];
        if (sumWithIndexes.containsKey(target - sum)) {
          pair p = sumWithIndexes.get(target - sum);
          if (p.first != i && p.first != j && p.second != i && p.second != j) {
            ArrayList<Integer> oneList = new ArrayList();
            oneList.add(nums[i]);
            oneList.add(nums[j]);
            oneList.add(nums[p.first]);
            oneList.add(nums[p.second]);
            System.out.println(oneList);
            listOf4Sums.add(oneList);
          }
        }

      }
    }
    return listOf4Sums;
  }

  static void findFourElements(int arr[],  int X)
  {
    int n=arr.length;
    // Store sums of all pairs in a hash table
    HashMap<Integer, pair> mp
        = new HashMap<Integer, pair>();
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++)
        mp.put(arr[i] + arr[j], new pair(i, j));

    // Traverse through all pairs and search
    // for X - (current pair sum).
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = arr[i] + arr[j];

        // If X - sum is present in hash table,
        if (mp.containsKey(X - sum)) {

          // Making sure that all elements are
          // distinct array elements and an
          // element is not considered more than
          // once.
          pair p = mp.get(X - sum);
          if (p.first != i && p.first != j && p.second != i && p.second != j) {
            ArrayList<Integer> oneList = new ArrayList<>();
            oneList.add(arr[i]);
            oneList.add(arr[j]);
            oneList.add(arr[p.first]);
            oneList.add(arr[p.second]);
        //    System.out.print(arr[i] + ", " + arr[j] + ", " + arr[p.first] + ", " + arr[p.second]);
            System.out.println(oneList);
          }
        }
      }
    }
  }

  public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    int i=0;
    while(i<num.length-3){
      int j=i+1;
      while(j<num.length-2){
        int left=j+1, right=num.length-1;
        while(left<right){
          if(num[left]+num[right]==target-num[i]-num[j]){
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.add(num[i]);
            t.add(num[j]);
            t.add(num[left]);
            t.add(num[right]);
            res.add(t);
            left++;
            right--;
            while(left<right && num[left]==num[left-1])
              left++;
            while(left<right && num[right]==num[right+1])
              right--;
          }else if(num[left]+num[right]>target-num[i]-num[j])
            right--;
          else
            left++;
        }
        j++;
        while(j<num.length-2 && num[j]==num[j-1])
          j++;
      }
      i++;
      while(i<num.length-3 && num[i]==num[i-1])
        i++;
    }
    return res;
  }






  public static void printListOfList(ArrayList<ArrayList<Integer>> al)
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

  public static void main(String[]args)
  {
    FourSum fourSum= new FourSum();
    int arr[]= {1,0,-1,0,-2,2};
    int arr2[]={2,2,2,2,2};
    int target=0;
    int target2=8;
    ArrayList<ArrayList<Integer>> listOf4SumsOutput = new ArrayList<>();
    listOf4SumsOutput=fourSum.fourSum2(arr2,target2);
    printListOfList(listOf4SumsOutput);
   // findFourElements(arr,target);
  }
}
