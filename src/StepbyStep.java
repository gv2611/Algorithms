public class StepbyStep {

  public int solve(int A) {
    int step =0;
    for(int i=1;i<=A;i++)
    {
      A=A-i;
      step++;
      if(A==0)
        return step;
      else if(A<0){
        A = A + i;
        step++;
      }
    }
  return step;
  }
  public static void main (String [] args)
  {
    StepbyStep step = new StepbyStep();
    System.out.println(step.solve(2));

  }
}
