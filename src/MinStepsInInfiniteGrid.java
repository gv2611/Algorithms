public class MinStepsInInfiniteGrid {

  public int coverPoints(int[] A, int[] B) {
    int count=0;

    for(int i=0; i<A.length-1; i++)
    {
      count=count+shortestPath(A[i],B[i],A[i+1], B[i+1]);
    }



    return count;
  }

  private int shortestPath(int x1, int y1, int x2, int y2) {
    int dx= Math.abs(x2-x1);
    int dy=Math.abs(y2-y1);

    return Math.max(dx,dy);

  }


  public static void main (String args[])
  {
    MinStepsInInfiniteGrid  min = new MinStepsInInfiniteGrid();
    int A[] = {0, 1, 1};
    int B[] = {0, 1, 2};
    System.out.println(min.coverPoints(A,B));

  }
}
