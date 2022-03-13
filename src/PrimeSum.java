public class PrimeSum {
  //Goldbach’s conjecture.

  public int[] primesum(int A) {
    int pair[]=new int[2];
    boolean isPrime[]=generatePrimeOrNotArray(A);
   // for(int i=0;i<isPrime.length;i++)
      //System.out.println(i+" is Prime?"+isPrime[i]);

    for(int i=0;i<A;i++)
    {
      if(isPrime[i] && isPrime[A-i])
      {
        pair[0]=A-i;
        pair[1]=i;
      }
    }
    return pair;
  }

  //SieveOfEratosthenes
  //If a number is prime, all it's multiples are set to false
  public boolean[] generatePrimeOrNotArray(int A)
  {
    boolean isPrime[]=new boolean[A+1];
    isPrime[0]=false;
    isPrime[1]=false;
    for(int i=2;i<=A;i++)
    {
      isPrime[i]=true;
    }
    for(int i=2;i*i<=A;i++)
    {
      if(isPrime[i]==true)
      {
        for(int j=i*i;j<=A;j+=i)
        {
          isPrime[j]=false;
        }
      }
    }
    return isPrime;
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
    PrimeSum ps = new PrimeSum();
    int output[]=ps.primesum(4);
    //ps.primesum(20);
    printArray(output);
  }
}
