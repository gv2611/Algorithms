public class IsRectangle {

  public int solve(int A, int B, int C, int D) {

    if(A==B && C==D)
      return 1;
    if(A==C && B==D)
      return 1;
    if(A==D && C==B)
      return 1;
    return 0;
  }

  public static void main(String[] args)
  {
    IsRectangle isrect = new IsRectangle();
    System.out.println(isrect.solve(2,3,2,2));

  }
}
