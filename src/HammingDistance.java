public class HammingDistance
{

  public int hammingDistance(final int[] A) {
    int sumHamming=0;
    for(int i=0;i<A.length;i++)
    {
      for(int j=0;j<A.length;j++)
      {
        int hammingDist= findHammingDistance(A[i],A[j]);
        sumHamming=(sumHamming+hammingDist)%1000000007;

      }
    }
    return sumHamming;
  }

  public int findHammingDistance(int n1, int n2)
  {
    int x= n1^n2;
    int setBits=0;

    while(x>0)
    {
      setBits+=x&1;
      x>>=1;
    }
    return setBits;

  }

  public int hammingDistance2(final int[] A) {
    int ans = 0; // Initialize result
    int n=A.length;

    // traverse over all bits
    for (int i = 0; i < 32; i++) {

      // count number of elements
      // with i'th bit set
      int count = 0;

      for (int j = 0; j < n; j++)
        if ((A[j] & (1 << i)) != 0)
          count++;

      // Add "count * (n - count) * 2"
      // to the answer...(n - count = unset bit count)
      ans += (count * (n - count) * 2);
    }

    return ans;

    }


    public static void main(String[] args)
  {
    HammingDistance hamDist = new HammingDistance();
    int arr[]= {2, 4, 6};
    System.out.println(hamDist.hammingDistance2(arr));
  }
}
