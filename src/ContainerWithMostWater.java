public class ContainerWithMostWater {

  public static int maxArea(int arr[])
  {
    int area;
    int maxArea=Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++)
    {
      for(int j=i+1;j<arr.length;j++)
      {
        int width=j-i;
        area=Math.min(arr[i], arr[j]) * width;
        if(area>maxArea)
        {
          maxArea=area;
        }
      }
    }
    return maxArea;
  }

  public int maxArea2(int[] height) {
    int area, maxArea=Integer.MIN_VALUE;
    int left=0, right= height.length-1;

    while(left<right)
    {
      int width= right-left;
   //   area= Math.min(height[left], height[right])*width;
      maxArea=Math.max(maxArea,(Math.min(height[left], height[right])* width));
      if(height[left]<height[right])
        left++;
else
  right--;
    }
    return maxArea;

  }


    public static void main(String[] args)
  {
    ContainerWithMostWater container = new ContainerWithMostWater();
    int arr[]={1,8,6,2,5,4,8,3,7};
    System.out.println(container.maxArea2(arr));
  }
}
