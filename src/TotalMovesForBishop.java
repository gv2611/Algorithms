public class TotalMovesForBishop {

  public int solve(int A, int B) {
    int i=A,j=B;
    int count=0;

    while(i<=8 && j>0)
    {
      i++;
      j--;
      if(i<=8 && j>0) {
        count++;
        System.out.println("i="+i+"j="+j);

      }
    }
    i=A;j=B;
    while(i>0 && j<=8)
    {
      i--;
      j++;
      if(i>0 && j<=8) {
        count++;
        System.out.println("i="+i+"j="+j);

      }

    }
    i=A;j=B;
    while(i>0 && j>0)
    {
     i--;
     j--;
     if(i>0 && j>0)
     {
       count++;
       System.out.println("i="+i+"j="+j);

     }
    }
    i=A;j=B;
    while(i<=8 && j<=8)
    {
      i++;
      j++;
      if(i<=8 && j<=8)
      {
        count++;
        System.out.println("i="+i+"j="+j);

      }
    }
    return count;



  }

    public static void main(String[] args)
    {
      TotalMovesForBishop moves = new TotalMovesForBishop();
      System.out.println(moves.solve(4,4));
    }
  }

