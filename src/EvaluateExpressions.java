public class EvaluateExpressions {

  public int evalRPN(String[] A) {
    return 0;


  }

  public static void main(String[] args)
  {
    EvaluateExpressions eval = new EvaluateExpressions();
    String A[]={"2", "1", "+", "3", "*"};
    String str="12";
    int val=Integer.parseInt(str);
    System.out.println(val);
    System.out.println(eval.evalRPN(A));
  }
}
