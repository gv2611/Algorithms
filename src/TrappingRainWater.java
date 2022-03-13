public class TrappingRainWater {

  public int trap(int[] height) {
    int trappedWater=0;
    int len=height.length;
    int left[]= new int[len];
    int right[]=new int[len];
    left[0]=height[0];
    for(int i=1;i<len;i++)
    {
      left[i]= Math.max(left[i-1],height[i]);
    }
    right[len-1]=height[len-1];
    for(int j=len-2; j>=0; j--)
    {
      right[j]=Math.max(right[j+1],height[j]);
    }

    for(int i=0; i<len;i++)
    {
      trappedWater+=Math.min(left[i],right[i])- height[i];
    }
    return trappedWater;
  }


  public static void main(String[] args)
  {
    TrappingRainWater rainWater = new TrappingRainWater();
    int arr[]={4,2,0,3,2,5};
    System.out.println(rainWater.trap(arr));
  }
}
