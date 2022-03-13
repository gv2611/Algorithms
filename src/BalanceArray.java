public class BalanceArray {

  public int isBalancedArray(int[] A) {
    int n = A.length;
    int result = 0;
    int even = 0;
    int odd =0;

    for(int i = 0 ; i < A.length ; i++){
      if(i%2 == 0)
        even += A[i];
      else
        odd += A[i];
    }
    System.out.println("Even="+even+" Odd="+odd);

    int keven = 0;
    int kodd =0;

    for(int i = 0 ; i < A.length ; i++){
      if(i%2 == 0){
        if((even - (A[i]+keven) + kodd) == ((odd-kodd) + keven))
          result += 1;
        keven += A[i];
      }
      else{
        if((odd - (A[i]+kodd) + keven) == (kodd + (even-keven)))
          result += 1;
        kodd += A[i];
      }
    }

    return result;
  }

  public static void main(String[] args)
  {
    BalanceArray ba= new BalanceArray();
    int arr[]={2, 1, 6, 4};
    int arr2[]={5, 5, 2, 5, 8};
    System.out.println(ba.isBalancedArray(arr2));

  }
}
