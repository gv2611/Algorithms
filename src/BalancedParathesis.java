import java.util.Stack;

public class BalancedParathesis {
  public int solve(String A) {

    Stack<Character> para = new Stack<>();
    char ch[]= A.toCharArray();

    for(int i=0;i<ch.length;i++)
    {

      if(ch[i]=='(')
      {
        para.push(ch[i]);
        continue;
      }
      else if(ch[i]==')' )
      {
        if(para.isEmpty())
          return 0;
        else
        para.pop();
      }
    }
    if(para.isEmpty())
      return 1;
    else
      return 0;


  }

  public static void main(String[] args)
  {
    BalancedParathesis bp = new BalancedParathesis();
    System.out.println(bp.solve("()()(())(()"));

  }
}
//{)){